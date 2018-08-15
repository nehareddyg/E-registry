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

public enum aPractitionerDao {
	instance;

	private Map<String, aPractitioner> contentProvider = new HashMap<>();

	private aPractitionerDao() {
		
		aPractitioner p1 = new aPractitioner();
		p1.setId("1");
		p1.setName(new HumanNameDt().addGiven("Dr. Rahul"));
		p1.setUsername(new StringDt("rahul"));
		p1.setPassword(new StringDt("123"));
		p1.setRole(aPractitionerRoleEnum.specializedDoctor);
		
		aPractitioner p2 = new aPractitioner();
		p2.setId("2");
		p2.setName(new HumanNameDt().addGiven("Dr. Manish"));
		p2.setUsername(new StringDt("manish"));
		p2.setPassword(new StringDt("456"));
		p2.setRole(aPractitionerRoleEnum.fieldDoctor);
		
		aPractitioner p3 = new aPractitioner();
		p3.setId("3");
		p3.setName(new HumanNameDt().addGiven("Mr. Raj"));
		p3.setUsername(new StringDt("raj"));
		p3.setPassword(new StringDt("789"));
		p3.setRole(aPractitionerRoleEnum.staff);
		
		contentProvider.put(p1.getUsername().toString(), p1);
		contentProvider.put(p2.getUsername().toString(), p2);
		contentProvider.put(p3.getUsername().toString(), p3);
	}

	public Map<String, aPractitioner> getModel(){
		    return contentProvider;
	}
}
