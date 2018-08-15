package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Location;
import ca.uhn.fhir.model.primitive.DateDt;
import model.NewEncounter;

public enum NewEncounterDao {
	instance;
	
	private Map<String, NewEncounter> contentProvider = new HashMap<>();

	private NewEncounterDao() {
		/*
			NewEncounter newEncounter = new NewEncounter(); 
			newEncounter.setId("1");
			newEncounter.setLoc(new Location().setName("Nimhans"));
			newEncounter.setPractitioner(aPractitionerDao.instance.getModel().get("1"));
			newEncounter.setDate(new DateDt(2016, 3, 14));
			newEncounter.setDiagnosticReport(aDignosticReportDao.instance.getModel().get("1"));
			
			contentProvider.put("1", newEncounter);*/	
	}

	public Map<String, NewEncounter> getModel(){
		    return contentProvider;
	}
}
