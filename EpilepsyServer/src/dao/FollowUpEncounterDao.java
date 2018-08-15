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
import model.FollowUpEncounter;
import model.NewEncounter;

public enum FollowUpEncounterDao {
	instance;
	
	private Map<String, FollowUpEncounter> contentProvider = new HashMap<>();

	private FollowUpEncounterDao() {
			FollowUpEncounter followUpEncounter = new FollowUpEncounter(); 
			followUpEncounter.setId("1");
			followUpEncounter.setLoc(new Location().setName("Kolar"));
			followUpEncounter.setPractitioner(aPractitionerDao.instance.getModel().get(aPractitionerIdToUsernameDao.instance.getModel().get("1")));
			followUpEncounter.setDate(new DateDt(2016, 3, 14));
			followUpEncounter.setFollowUpReport(FollowUpReportDao.instance.getModel().get("1"));
			
			contentProvider.put("1", followUpEncounter);
			
			followUpEncounter = new FollowUpEncounter(); 
			followUpEncounter.setId("2");
			followUpEncounter.setLoc(new Location().setName("Kolar"));
			followUpEncounter.setPractitioner(aPractitionerDao.instance.getModel().get(aPractitionerIdToUsernameDao.instance.getModel().get("2")));
			followUpEncounter.setDate(new DateDt(2016, 3, 18));
			followUpEncounter.setFollowUpReport(FollowUpReportDao.instance.getModel().get("2"));
			
			contentProvider.put("2", followUpEncounter);
	}

	public Map<String, FollowUpEncounter> getModel(){
		    return contentProvider;
	}
}
