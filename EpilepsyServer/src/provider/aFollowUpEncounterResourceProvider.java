package provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.resource.Location;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import codeableConcepts.FollowUpFrequencyCodeableConcept;
import dao.FollowUpEncounterDao;
import dao.FollowUpReportDao;
import dao.NewEncounterDao;
import dao.aObservationDao;
import dao.aPatientDao;
import dao.aPractitionerDao;
import dao.aPractitionerIdToUsernameDao;
import model.FollowUpEncounter;
import model.NewEncounter;
import model.aFollowUpReport;
import model.aObservation;
import model.aPatient;
import model.aPractitioner;
import model.aPractitionerRoleEnum;

@Path("/FollowUpEncounter")
public class aFollowUpEncounterResourceProvider {
	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Response getFollowUpEncountersByPatientID(@PathParam("id") String id) throws JSONException{
		List<FollowUpEncounter> followUpEncounters = aPatientDao.instance.getModel().get(id).getFollowUpEncounters();
		
		if (followUpEncounters == null)
			return Response.status(404).entity("").build();
	
		JSONArray followUps = new JSONArray();
		
		for (FollowUpEncounter e : followUpEncounters) {
			aFollowUpReport fr = e.getFollowUpReport();

			JSONObject followUpObject = new JSONObject();

			followUpObject.put("id", e.getId().getIdPart());
			followUpObject.put("date", e.getDate().getValueAsString());
			followUpObject.put("location", e.getLoc().getName());

			aPractitioner p2 = e.getPractitioner();
			JSONObject prac = new JSONObject();
			prac.put("id", p2.getId().getIdPart());
			prac.put("role", p2.getRole().toString());
			prac.put("name", p2.getName().getNameAsSingleString());
			prac.put("username", p2.getUsername());

			followUpObject.put("practitioner", prac);

			List<CodeableConceptDt> codes = fr.getCodedDiagnosis();

			JSONObject fReportObject = new JSONObject();
			
			fReportObject.put("id", fr.getId().getIdPart());
			for (CodeableConceptDt cd : codes) {			
				for (CodingDt c : cd.getCoding()) {
					if(c.getUserSelected() != null) {
						if(c.getUserSelected() == true)
							fReportObject.put(cd.getText(), c.getDisplay());
					}
				}
			}

			fReportObject.put("regularity", fr.getRegularity());
			fReportObject.put("adverseEvents", fr.getAdverseEvents());
			fReportObject.put("remarks", fr.getRemarks());
			fReportObject.put("nextDate", fr.getNextDate().getValueAsString());
			
			followUpObject.put("followUpReport", fReportObject);

			followUps.put(followUpObject);
		}

		String result = followUps.toString();

		return Response.status(200).entity(result).build();
	}
	
	@Path("/create")
	@POST
	@Produces("application/json")
	public Response createFollowupEncounter(@QueryParam("patientId") String patientId, @QueryParam("date") String date, @QueryParam("location") String location, @QueryParam("practitionerId") String practitionerId, @QueryParam("frequency") String frequency, @QueryParam("regularity") String regularity, @QueryParam("adverseEvents") String adverseEvent,@QueryParam("remarks") String remarks,@QueryParam("nextDate") String nextDate) throws JSONException{	
		FollowUpEncounter fEncounter = new FollowUpEncounter();
		fEncounter.setId((FollowUpEncounterDao.instance.getModel().size() + 1) + "");
		
		String[] temp = date.split("-");
		int day = Integer.parseInt(temp[2]);
		int month = Integer.parseInt(temp[1]);
		int year = Integer.parseInt(temp[0]);
		
		Date date1 = new Date(year, month-1, day);
		
		fEncounter.setDate(new DateDt(year,month,day));
		fEncounter.setLoc(new Location().setName(location));
		fEncounter.setPractitioner(aPractitionerDao.instance.getModel().get(aPractitionerIdToUsernameDao.instance.getModel().get(practitionerId)));
		
		aFollowUpReport fReport = new aFollowUpReport();
		fReport.setId((FollowUpReportDao.instance.getModel().size() + 1) + "");
		fReport.setRegularity(new StringDt(regularity));
		fReport.setAdverseEvents(new StringDt(adverseEvent));
		fReport.setRemarks(new StringDt(remarks));
		
		temp = nextDate.split("-");
		day = Integer.parseInt(temp[2]);
		month = Integer.parseInt(temp[1]);
		year = Integer.parseInt(temp[0]);
		fReport.setNextDate(new DateDt(year,month,day));
		
		
		Date date2 = new Date(year, month-1, day);
		
		if(date2.compareTo(date1) <= 0)
			return Response.status(400).entity("").build();
		
		FollowUpFrequencyCodeableConcept ffcc = new FollowUpFrequencyCodeableConcept();
		for (CodingDt c : ffcc.getCoding()) {
			if (c.getDisplay().equals(frequency))
				c.setUserSelected(true);
		}
		fReport.addCodedDiagnosis(ffcc);
		
		fEncounter.setFollowUpReport(fReport);
		
		if(aPatientDao.instance.getModel().get(patientId).getFollowUpEncounters() != null)
			aPatientDao.instance.getModel().get(patientId).getFollowUpEncounters().add(fEncounter);
		else {
			ArrayList<FollowUpEncounter> followUpEncounters = new ArrayList<FollowUpEncounter>();
			aPatientDao.instance.getModel().get(patientId).setFollowUpEncounters(followUpEncounters);
			aPatientDao.instance.getModel().get(patientId).getFollowUpEncounters().add(fEncounter);
		}
		FollowUpEncounterDao.instance.getModel().put((FollowUpEncounterDao.instance.getModel().size()+1)+"",fEncounter);
		FollowUpReportDao.instance.getModel().put((FollowUpReportDao.instance.getModel().size()+1)+"",fReport);
		
		/*
		JSONObject followUpObject = new JSONObject();
		
		followUpObject.put("id", fEncounter.getId().getIdPart());
		followUpObject.put("date", fEncounter.getDate().getValueAsString());
		followUpObject.put("location", fEncounter.getLoc().getName());

		aPractitioner p2 = fEncounter.getPractitioner();
		
		JSONObject prac = new JSONObject();
		prac.put("id", p2.getId().getIdPart());
		prac.put("role", p2.getRole().toString());
		prac.put("name", p2.getName().getNameAsSingleString());
		prac.put("username", p2.getUsername());

		followUpObject.put("practitioner", prac);
		
		aFollowUpReport fr = fEncounter.getFollowUpReport();
		
		List<CodeableConceptDt> codes1 = fr.getCodedDiagnosis();

		JSONObject fReportObject = new JSONObject();
		
		fReportObject.put("id", fr.getId().getIdPart());
		for (CodeableConceptDt cd : codes1) {
			for (CodingDt c : cd.getCoding()) {
				fReportObject.put(c.getDisplay(), c.getUserSelected());
			}
		}

		fReportObject.put("regularity", fr.getRegularity());
		fReportObject.put("adverseEvents", fr.getAdverseEvents());
		fReportObject.put("remarks", fr.getRemarks());
		fReportObject.put("nextDate", fr.getNextDate().getValueAsString());
		
		followUpObject.put("followUpReport", fReportObject);
	*/
		JSONObject j = new JSONObject();
		j.put("followUpEncounterId", fEncounter.getId().getIdPart());
		j.put("followUpReportId", fReport.getId().getIdPart());
		String result = j.toString();
		
		return Response.status(200).entity(result).build();
	}
		
}
