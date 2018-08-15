package provider;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.portable.OutputStream;

import com.google.gson.Gson;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.resource.Location;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import codeableConcepts.AbsenceCodeableConcept;
import codeableConcepts.AgeAtOnsetCodeableConcept;
import codeableConcepts.ClusterAttacksCodeableConcept;
import codeableConcepts.DurationOfSeizuresCodeableConcept;
import codeableConcepts.FamilyHistoryCodeableConcept;
import codeableConcepts.FrequencyOfSeizuresBeforeTreatmentCodeableConcept;
import codeableConcepts.FrequencyOfSeizuresWithTreatmentCodeableConcept;
import codeableConcepts.GeneralIntelligenceCodeableConcept;
import codeableConcepts.MyclonicEpilepsyCodeableConcept;
import codeableConcepts.NeurologicalExaminationCodeableConcept;
import codeableConcepts.PartialSeizuresCodeableConcept;
import codeableConcepts.PastHistoryCodeableConcept;
import codeableConcepts.PersonalityAndMentalStatusCodeableConcept;
import codeableConcepts.PrecipitatingFactorsCodeableConcept;
import codeableConcepts.PreviousTreatmentCodeableConcept;
import codeableConcepts.PrimaryGeneralisedEpilepsyCodeableConcept;
import codeableConcepts.ProbableAetiologicalFactorsCodeableConcept;
import codeableConcepts.StatusEpilepticusCodeableConcept;
import dao.NewEncounterDao;
import dao.aDignosticReportDao;
import dao.aObservationDao;
import dao.aPatientDao;
import dao.aPractitionerDao;
import dao.aPractitionerIdToUsernameDao;
import model.NewEncounter;
import model.aDiagnosticReport;
import model.aObservation;
import model.aPatient;
import model.aPractitioner;
import model.aPractitionerRoleEnum;

@Path("/NewEncounter")
public class aNewEncounterResourceProvider {

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Response getNewEncounterByPatientID(@PathParam("id") String id) throws JSONException {

		NewEncounter n = aPatientDao.instance.getModel().get(id).getNewEncounter();

		if (n == null)
			throw new RuntimeException("Get: New Encounter for patient with " + id + " not found");
		
		JSONObject newEn = new JSONObject();
		newEn.put("id", n.getId().getIdPart());
		newEn.put("date", n.getDate().getValueAsString());
		newEn.put("location", n.getLoc().getName());

		aPractitioner p1 = n.getPractitioner();
		JSONObject pr = new JSONObject();
		pr.put("id", p1.getId().getIdPart());
		pr.put("role", p1.getRole().toString());
		pr.put("name", p1.getName().getNameAsSingleString());
		pr.put("username", p1.getUsername());

		newEn.put("practitioner", pr);
		
		aDiagnosticReport dia = n.getDiagnosticReport();
		
		JSONObject d = new JSONObject();
		d.put("id", dia.getId().getIdPart());
		List<CodeableConceptDt> codes = dia.getCodedDiagnosis();

		
		for (CodeableConceptDt cd : codes) {
			if(cd.getText().equals("precipitatingFactors") || cd.getText().equals("familyHistory")) {
				JSONArray dArr = new JSONArray();
				for(CodingDt c : cd.getCoding()) {
					if(c.getUserSelected() != null) {
						if(c.getUserSelected() == true) {
							dArr.put(c.getDisplay());
						}
					}
				}
				d.put(cd.getText(), dArr);
			}
			else {
				for (CodingDt c : cd.getCoding()) {
					if(c.getUserSelected() != null) {
						if(c.getUserSelected() == true) {
							d.put(cd.getText(), c.getDisplay());
						}
					}
				}
			}
		}
		
		d.put("descriptionOfClinicalSeizures", dia.getDescriptionOfClinicalSeizures());
		d.put("treatmentAdvised", dia.getTreatmentAdvised());
		d.put("mtest", dia.getMtest());
		
		newEn.put("diagnosticReport", d);

		String result = newEn.toString();
		return Response.status(200).entity(result).build();
	}

	@Path("/create")
	@POST
	@Produces("application/json")
	public Response createNewEncounter(@QueryParam("patientId") String patientId,
			@QueryParam("practitionerId") String practitionerId,
			@QueryParam("location") String location,
			@QueryParam("date") String date,
			@QueryParam("ageAtOnset") String ageAtOnset,
			@QueryParam("typeOfSeizures") String typeOfSeizures,
			@QueryParam("subtypeOfSeizures") String subtypeOfSeizures,
			@QueryParam("durationOfSeizures") String durationOfSeizures,
			@QueryParam("focBeforeTreatment") String focBeforeTreatment,
			@QueryParam("focWithTreatment") String focWithTreatment,
			@QueryParam("clusterAttacks") String clusterAttacks,
			@QueryParam("statusEpilepticus") String statusEpilepticus,
			@QueryParam("precipitatingFactors") String precipitatingFactors,
			@QueryParam("pastHistory") String pastHistory, @QueryParam("familyHistory") String familyHistory,
			@QueryParam("probableAF") String probableAF, @QueryParam("pms") String pms,
			@QueryParam("desOfClinicalSeizures") String desOfClinicalSeizures,
			@QueryParam("prevTreatment") String prevTreatment, @QueryParam("gi") String gi, @QueryParam("ne") String ne,
			@QueryParam("treatmentAdvised") String treatmentAdvised,
			@QueryParam("mtest") String mtest)throws JSONException {

		
		NewEncounter newEncounter = new NewEncounter();
		int nextIdNewEncounter = NewEncounterDao.instance.getModel().size() + 1;
		
		newEncounter.setId(nextIdNewEncounter + "");
		newEncounter.setLoc(new Location().setName(location));
		newEncounter.setPractitioner(aPractitionerDao.instance.getModel()
				.get(aPractitionerIdToUsernameDao.instance.getModel().get(practitionerId)));

		String[] dateArr = date.split("-");
		int year = Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]);
		int day = Integer.parseInt(dateArr[2]);
		newEncounter.setDate(new DateDt(year, month, day));

		aDiagnosticReport diagnosticReport = new aDiagnosticReport();

		int nextIdDiagnosticReport = aDignosticReportDao.instance.getModel().size() + 1;
		diagnosticReport.setId(nextIdDiagnosticReport + "");
		
		CodeableConceptDt cc = new AgeAtOnsetCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(ageAtOnset)) {
				c.setUserSelected(true);
			}
		}

		diagnosticReport.addCodedDiagnosis(cc);

		if (typeOfSeizures.equals("Absence"))
			cc = new AbsenceCodeableConcept();
		else if (typeOfSeizures.equals("Myoclonic Epilepsy"))
			cc = new MyclonicEpilepsyCodeableConcept();
		else if (typeOfSeizures.equals("Primary Generalised Epilepsy"))
			cc = new PrimaryGeneralisedEpilepsyCodeableConcept();
		else if (typeOfSeizures.equals("Partial Seizures"))
			cc = new PartialSeizuresCodeableConcept();

		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(subtypeOfSeizures))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);
		cc = new DurationOfSeizuresCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(durationOfSeizures))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new FrequencyOfSeizuresBeforeTreatmentCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(focBeforeTreatment))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new FrequencyOfSeizuresWithTreatmentCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(focWithTreatment))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new ClusterAttacksCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(clusterAttacks))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new StatusEpilepticusCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(statusEpilepticus))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new PrecipitatingFactorsCodeableConcept();
		String[] codes = precipitatingFactors.split("-");
		for (String str : codes) {
			for (CodingDt c : cc.getCoding()) {
				if (c.getDisplay().equals(str))
					c.setUserSelected(true);
			}
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new PastHistoryCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(pastHistory))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new FamilyHistoryCodeableConcept();
		codes = familyHistory.split("-");
		for (String str : codes) {
			for (CodingDt c : cc.getCoding()) {
				if (c.getDisplay().equals(str))
					c.setUserSelected(true);
			}
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new ProbableAetiologicalFactorsCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(probableAF))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new PersonalityAndMentalStatusCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(pms))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new PreviousTreatmentCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(prevTreatment))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new GeneralIntelligenceCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(gi))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		cc = new NeurologicalExaminationCodeableConcept();
		for (CodingDt c : cc.getCoding()) {
			if (c.getDisplay().equals(ne))
				c.setUserSelected(true);
		}

		diagnosticReport.addCodedDiagnosis(cc);

		diagnosticReport.setDescriptionOfClinicalSeizures(new StringDt(desOfClinicalSeizures));
		diagnosticReport.setTreatmentAdvised(new StringDt(treatmentAdvised));
		diagnosticReport.setMtest(new StringDt(mtest));
		
		newEncounter.setDiagnosticReport(diagnosticReport);

		aDignosticReportDao.instance.getModel().put(nextIdDiagnosticReport + "", diagnosticReport);
		NewEncounterDao.instance.getModel().put(nextIdNewEncounter + "", newEncounter);
		
		aPatientDao.instance.getModel().get(patientId).setNewEncounter(newEncounter);
		aPatientDao.instance.getModel().get(patientId).setIsCaseFormFilled(new BooleanDt(true));

		JSONObject j = new JSONObject();
		j.put("newEncounterId", newEncounter.getId().getIdPart());
		j.put("diagnosticReportId", diagnosticReport.getId().getIdPart());
		String result = j.toString();
		
		return Response.status(200).entity(result).build();
	}
	
	@Path("/create/file")
	@POST
	@Produces("application/json")
    @Consumes("multipart/form-data")
    public Response uploadNewEncounterFile(MultipartFormDataInput input) throws IOException {
		System.out.println("hurray");
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
 
        // Get file data to save
        List<InputPart> inputParts = uploadForm.get("myFile");
        
        for (InputPart inputPart : inputParts) {
            try {
 
                MultivaluedMap<String, String> header = inputPart.getHeaders();
                //String fileName = getFileName(header);
                String fileName = "blah";
                // convert the uploaded file to inputstream
                InputStream inputStream = inputPart.getBody(InputStream.class,null);
 
                byte[] bytes = IOUtils.toByteArray(inputStream);
                // constructs upload file path
                fileName = "C:/Users/user/" + fileName;
                writeFile(bytes, fileName);
 
                  
                return Response.status(200).entity("Uploaded file name : " + fileName)
                        .build();
 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
 
    private String getFileName(MultivaluedMap<String, String> header) {
 
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
 
        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {
 
                String[] name = filename.split("=");
 
                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }
 
    // Utility method
    private void writeFile(byte[] content, String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("not exist> " + file.getAbsolutePath());
            file.createNewFile();
        }
        System.out.println("hurray");
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(content);
        fop.flush();
        fop.close();
    }
}   

