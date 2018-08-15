package provider;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import dao.aObservationDao;
import dao.aPatientDao;
import dao.aPractitionerDao;
import dao.aPractitionerIdToUsernameDao;
import model.aObservation;
import model.aPatient;
import model.aPractitioner;
import model.aPractitionerRoleEnum;

@Path("/Practitioner")
public class aPractitionerResourceProvider {
	
	@Path("/id")
	@GET
	@Produces("application/json")
	public Response getPractitionerByID(@PathParam("id") String id) throws JSONException{
		aPractitioner p = aPractitionerDao.instance.getModel().get(aPractitionerIdToUsernameDao.instance.getModel().get(id));
		
		if (p == null)
			throw new RuntimeException("Get: Practitioner with " + id + " not found");
	
		JSONObject j = new JSONObject();
		j.put("id",p.getId().getIdPart());
		j.put("name",p.getName().getNameAsSingleString());
		j.put("username",p.getUsername());
		j.put("role",p.getRole());
		
		String result = j.toString();
		return Response.status(200).entity(result).build();
	}
	
	@Path("/login")
	@GET
	public Response loginPractitioner(@QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("role") String role) throws JSONException{
		aPractitioner p = aPractitionerDao.instance.getModel().get(username);
		
		if(p == null)
			return Response.status(400).entity("").build();
		
		if(password.equals(p.getPassword().toString()) && role.equals(p.getRole().toString())) {
		
			JSONObject j1 = new JSONObject();
			j1.put("id",p.getId().getIdPart());
			j1.put("name",p.getName().getNameAsSingleString());
			j1.put("username",p.getUsername());
			j1.put("role",p.getRole());
		
			JSONObject j = new JSONObject();
			j.put("practitioner", j1);
			
			String result = j.toString();
			return Response.status(200).entity(result).build();
		} else
			return Response.status(400).entity("").build();
	}
	
}
