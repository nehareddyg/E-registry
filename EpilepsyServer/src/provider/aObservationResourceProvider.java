package provider;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import dao.aObservationDao;
import dao.aPatientDao;
import model.aObservation;
import model.aPatient;

@Path("/Observation")
public class aObservationResourceProvider {
	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Response getObservationByID(@PathParam("id") String id) throws JSONException{
		aObservation o = aObservationDao.instance.getModel().get(id);
		
		if (o == null)
			throw new RuntimeException("Get: Observation with " + id + " not found");
	
		JSONObject j = new JSONObject();
		j.put("id",o.getId().getIdPart());
		j.put("myoclonicEpilepsy",o.getMyoclonicEpilepsy());
		j.put("partialSeizures",o.getPartialSeizures());
		j.put("frequencyOfSeizures", o.getFrequencyOfSeizures());
		j.put("pastHistory",o.getPastHistory());
		
		String result = j.toString();
		return Response.status(200).entity(result).build();
	}
	
	@Path("{create}")
	@POST
	@Produces("application/json")
	public Response createObservation(@QueryParam("myoclonicEpilepsy") String myoclonicEpilepsy, @QueryParam("partialSeizures") String partialSeizures, @QueryParam("frequencyOfSeizures") String frequencyOfSeizures, @QueryParam("pastHistory") String pastHistory) throws JSONException{
		
		int nextId = aObservationDao.instance.getModel().size();
		nextId++;
		
		aObservation o = new aObservation();
		o.setId(nextId + "");
		o.setMyoclonicEpilepsy(new StringDt(myoclonicEpilepsy));
		o.setPartialSeizures(new StringDt(partialSeizures));
		o.setFrequencyOfSeizures(new StringDt(frequencyOfSeizures));
		o.setPastHistory(new StringDt(pastHistory));
		
		aObservationDao.instance.getModel().put(nextId + "", o);

		JSONObject j = new JSONObject();
		j.put("id",o.getId().getIdPart());
		j.put("myoclonicEpilepsy",o.getMyoclonicEpilepsy());
		j.put("partialSeizures",o.getPartialSeizures());
		j.put("frequencyOfSeizures", o.getFrequencyOfSeizures());
		j.put("pastHistory",o.getPastHistory());
		
		String result = j.toString();
		return Response.status(200).entity(result).build();

	}
	
}
