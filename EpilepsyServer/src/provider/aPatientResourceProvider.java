package provider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import dao.aPatientDao;
import model.FollowUpEncounter;
import model.NewEncounter;
import model.aFollowUpReport;
import model.aPatient;
import model.aPractitioner;

@Path("/Patient")
public class aPatientResourceProvider {

	@Path("{id}")
	@GET
	@Produces("application/json")
	public Response getPatientByID(@PathParam("id") String id) throws JSONException {
		aPatient p = aPatientDao.instance.getModel().get(id);

		if (p == null)
			throw new RuntimeException("Get: Patient with " + id + " not found");

		JSONObject j = new JSONObject();
		j.put("id", p.getId().getIdPart());
		j.put("name", p.getName().get(0).getGiven().get(0).getValueAsString());
		j.put("age", p.getAge().getValue());
		j.put("sex", p.getSex());
		j.put("siNo", p.getSiNo());
		j.put("fatherName", p.getFatherName());
		j.put("village", p.getVillage());
		j.put("isCaseFormFilled", p.getIsCaseFormFilled().getValue());
		
		
		JSONObject patientObject = new JSONObject();
		patientObject.put("patient", j);

		String result = patientObject.toString();
		return Response.status(200).entity(result).build();
	}

	@Path("/create")
	@POST
	@Produces("application/json")
	public Response createPatient(@QueryParam("name") String name, @QueryParam("age") int age,
			@QueryParam("sex") String sex, @QueryParam("siNo") String siNo, @QueryParam("fatherName") String fatherName,
			@QueryParam("village") String village) throws JSONException {

		int nextId = aPatientDao.instance.getModel().size();
		nextId++;

		aPatient p = new aPatient();
		p.setId(nextId + "");
		p.addName().addGiven(name);
		p.setAge(new IntegerDt(age));
		p.setSex(new StringDt(sex));
		p.setSiNo(new StringDt(siNo));
		p.setfatherName(new StringDt(fatherName));
		p.setVillage(new StringDt(village));
		p.setIsCaseFormFilled(new BooleanDt(false));

		aPatientDao.instance.getModel().put(nextId + "", p);

		JSONObject j = new JSONObject();
		j.put("id", p.getId().getIdPart());
		j.put("name", p.getName().get(0).getGiven().get(0).getValueAsString());
		j.put("age", p.getAge().getValue());
		j.put("sex", p.getSex());
		j.put("siNo", p.getSiNo());
		j.put("fatherName", p.getFatherName());
		j.put("village", p.getVillage());
		j.put("isCaseFormFilled", p.getIsCaseFormFilled().getValue());

		String result = j.toString();
		return Response.status(200).entity(result).build();

	}
/*
	@Path("/create1")
	@POST
	@Produces("application/json")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response createPatient(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileMetaData, @FormDataParam("name") String name,
			@FormDataParam("age") String age, @FormDataParam("sex") String sex, @FormDataParam("siNo") String siNo,
			@FormDataParam("fatherName") String fatherName, @FormDataParam("village") String village)
					throws WebApplicationException, JSONException {

		int nextId = aPatientDao.instance.getModel().size();
		nextId++;

		aPatient p = new aPatient();
		p.setId(nextId + "");
		p.addName().addGiven(name);
		p.setAge(new IntegerDt(Integer.parseInt(age)));
		p.setSex(new StringDt(sex));
		p.setSiNo(new StringDt(siNo));
		p.setfatherName(new StringDt(fatherName));
		p.setVillage(new StringDt(village));
		p.setIsCaseFormFilled(new BooleanDt(false));

		String UPLOAD_PATH = "\\Images\\";

		File file;
		if (fileMetaData.getFileName() != null) {
			try {
				int read = 0;
				byte[] bytes = new byte[1024];

				file = new File(UPLOAD_PATH + fileMetaData.getFileName());
				OutputStream out = new FileOutputStream(file);

				while ((read = fileInputStream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				out.flush();
				out.close();

			} catch (IOException e) {
				throw new WebApplicationException("Error while uploading file. Please try again !!");
			}

			p.setImageUrl(new StringDt(UPLOAD_PATH + fileMetaData.getFileName()));
		} else
			p.setImageUrl(new StringDt(""));

		aPatientDao.instance.getModel().put(nextId + "", p);

		JSONObject j = new JSONObject();
		j.put("id", p.getId().getIdPart());
		j.put("name", p.getName().get(0).getGiven().get(0).getValueAsString());
		j.put("age", p.getAge().getValue());
		j.put("sex", p.getSex());
		j.put("siNo", p.getSiNo());
		j.put("fatherName", p.getFatherName());
		j.put("village", p.getVillage());
		j.put("isCaseFormFilled", p.getIsCaseFormFilled().getValue());
		j.put("imageUrl", p.getImageUrl());

		String result = j.toString();
		return Response.status(200).entity(result).build();
	}

	@Path("/create2")
	@POST
	@Produces("application/json")
	public Response createPatient(@QueryParam("name") String name, @QueryParam("age") int age,
			@QueryParam("sex") String sex, @QueryParam("siNo") String siNo, @QueryParam("fatherName") String fatherName,
			@QueryParam("village") String village, @QueryParam("imageString") String imageString) throws JSONException {

		int nextId = aPatientDao.instance.getModel().size();
		nextId++;

		aPatient p = new aPatient();
		p.setId(nextId + "");
		p.addName().addGiven(name);
		p.setAge(new IntegerDt(age));
		p.setSex(new StringDt(sex));
		p.setSiNo(new StringDt(siNo));
		p.setfatherName(new StringDt(fatherName));
		p.setVillage(new StringDt(village));
		p.setIsCaseFormFilled(new BooleanDt(false));

		String UPLOAD_PATH = "\\Images\\";

		if (imageString != null) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = decodeImage(imageString);

			// Write a image byte array into file system
			FileOutputStream imageOutFile = null;
			try {
				imageOutFile = new FileOutputStream(UPLOAD_PATH + "img.png");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				imageOutFile.write(imageByteArray);
				imageOutFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p.setImageUrl(new StringDt(UPLOAD_PATH + "img.png"));
		}
		else
			p.setImageUrl(new StringDt(""));
		
		aPatientDao.instance.getModel().put(nextId + "", p);

		JSONObject j = new JSONObject();
		j.put("id", p.getId().getIdPart());
		j.put("name", p.getName().get(0).getGiven().get(0).getValueAsString());
		j.put("age", p.getAge().getValue());
		j.put("sex", p.getSex());
		j.put("siNo", p.getSiNo());
		j.put("fatherName", p.getFatherName());
		j.put("village", p.getVillage());
		j.put("isCaseFormFilled", p.getIsCaseFormFilled().getValue());
		j.put("imageUrl", p.getImageUrl());

		String result = j.toString();
		return Response.status(200).entity(result).build();

	}
*/
	/**
	 * Decodes the base64 string into byte array
	 *
	 * @param imageDataString
	 *            - a {@link java.lang.String}
	 * @return byte array
	 */
/*	public byte[] decodeImage(String imageDataString) {
		return Base64.decodeBase64(imageDataString);
	}
*/
}
