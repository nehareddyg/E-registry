package provider;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
import dao.FollowUpEncounterDao;
import dao.FollowUpReportDao;
import dao.NewEncounterDao;
import dao.aPatientDao;
import model.FollowUpEncounter;
import model.NewEncounter;
import model.aFollowUpReport;
import model.aPatient;
import model.aPractitioner;

@Path("/Dashboard")
public class aDashboardResourceProvider {

	@Path("/totalPatients")
	@GET
	@Produces("application/json")
	public Response getTotalNumberOfPatients() throws JSONException {

		JSONObject j = new JSONObject();
		j.put("number", aPatientDao.instance.getModel().size());
	
		String result = j.toString();
		return Response.status(200).entity(result).build();
	}

	@Path("/newPatients")
	@GET
	@Produces("application/json")
	public Response getTotalNumberOfNewPatients() throws JSONException {

		JSONObject j = new JSONObject();
		j.put("number", NewEncounterDao.instance.getModel().size());
		
		String result = j.toString();
		return Response.status(200).entity(result).build();

	}
	
	@Path("/followUpPatients")
	@GET
	@Produces("application/json")
	public Response getTotalNumberOfFollowUpPatients() throws JSONException {

		JSONObject j = new JSONObject();
		j.put("number", FollowUpEncounterDao.instance.getModel().size());
		
		String result = j.toString();
		return Response.status(200).entity(result).build();

	}
	
	@Path("/details")
	@GET
	@Produces("application/json")
	public Response getDashboardDetails() throws JSONException {

		JSONObject j = new JSONObject();
		j.put("total", aPatientDao.instance.getModel().size());
		j.put("new", NewEncounterDao.instance.getModel().size());
		j.put("followUp", FollowUpEncounterDao.instance.getModel().size());
		
		String result = j.toString();
		return Response.status(200).entity(result).build();

	}
}
