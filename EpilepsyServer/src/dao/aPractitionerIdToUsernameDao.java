package dao;

import java.util.HashMap;
import java.util.Map;

import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import model.aObservation;
import model.aPatient;
import model.aPractitioner;
import model.aPractitionerRoleEnum;

public enum aPractitionerIdToUsernameDao {
	instance;

	private Map<String, String> contentProvider = new HashMap<>();

	private aPractitionerIdToUsernameDao() {
		
		contentProvider.put("1", "rahul");
		contentProvider.put("2", "manish");
		contentProvider.put("3", "raj");
	}

	public Map<String, String> getModel(){
		    return contentProvider;
	}
}
