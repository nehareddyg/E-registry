package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Location;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import model.FollowUpEncounter;
import model.NewEncounter;
import model.aPatient;

public enum aPatientDao {
	instance;

	private Map<String, aPatient> contentProvider = new HashMap<>();

	private aPatientDao() {
		aPatient p1 = new aPatient();
		
		p1.setId("1");
		p1.addName().addGiven("Ramesh");
		p1.setAge(new IntegerDt(20));
		p1.setSex(new StringDt("Male"));
		p1.setSiNo(new StringDt("1"));
		p1.setfatherName(new StringDt("Kumar"));
		p1.setVillage(new StringDt("Kolar"));
		p1.setIsCaseFormFilled(new BooleanDt(false)); 
	
	//	p1.setNewEncounter(NewEncounterDao.instance.getModel().get(1));
		
		ArrayList<FollowUpEncounter> followUpEncounters = new ArrayList<FollowUpEncounter>();
		
		followUpEncounters.add(FollowUpEncounterDao.instance.getModel().get("1"));
		followUpEncounters.add(FollowUpEncounterDao.instance.getModel().get("2"));
		
		p1.setFollowUpEncounters(followUpEncounters);
		
		contentProvider.put("1", p1);
		
		aPatient p2 = new aPatient();
		
		p2.setId("2");
		p2.addName().addGiven("Krishna");
		p2.setAge(new IntegerDt(45));
		p2.setSex(new StringDt("Male"));
		p2.setSiNo(new StringDt("2"));
		p2.setfatherName(new StringDt("Praveen"));
		p2.setVillage(new StringDt("Srinivasapura"));
		p2.setIsCaseFormFilled(new BooleanDt(false)); 
	
	//	p1.setNewEncounter(NewEncounterDao.instance.getModel().get(1));
		
		ArrayList<FollowUpEncounter> followUpEncounters2 = new ArrayList<FollowUpEncounter>();
		
		//followUpEncounters2.add(FollowUpEncounterDao.instance.getModel().get("1"));
		//followUpEncounters.add(FollowUpEncounterDao.instance.getModel().get("2"));
		
		p2.setFollowUpEncounters(followUpEncounters2);
		
		contentProvider.put("2", p2);
	}

	public Map<String, aPatient> getModel(){
		    return contentProvider;
	}
}
