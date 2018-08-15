package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.valueset.DiagnosticOrderPriorityEnum;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import codeableConcepts.FollowUpFrequencyCodeableConcept;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import model.FollowUpEncounter;
import model.aFollowUpReport;
import model.aObservation;
import model.aPatient;

public enum FollowUpReportDao {
	instance;

	private Map<String, aFollowUpReport> contentProvider = new HashMap<>();

	private FollowUpReportDao() {
		
		aFollowUpReport followUpReport = new aFollowUpReport();	
	
		FollowUpFrequencyCodeableConcept ffcc = new FollowUpFrequencyCodeableConcept();
		for(CodingDt c : ffcc.getCoding()) {
			if(c.getCode().equals("INR"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		
		followUpReport.addCodedDiagnosis(ffcc);
	
		followUpReport.setId("1");
		followUpReport.setRegularity(new StringDt("regular"));
		followUpReport.setAdverseEvents(new StringDt("event1"));
		followUpReport.setRemarks(new StringDt("No remarks"));
		followUpReport.setNextDate(new DateDt(2016,3,18));
		
		contentProvider.put("1", followUpReport);	
		
		followUpReport = new aFollowUpReport();
	
		ffcc = new FollowUpFrequencyCodeableConcept();
		for(CodingDt c : ffcc.getCoding()) {
			if(c.getCode().equals("INR"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		
		followUpReport.setId("2");
		followUpReport.addCodedDiagnosis(ffcc);
		followUpReport.setRegularity(new StringDt("regular"));
		followUpReport.setAdverseEvents(new StringDt("event2"));
		followUpReport.setRemarks(new StringDt("No remarks"));
		followUpReport.setNextDate(new DateDt(2016,3,20));
		
		contentProvider.put("2", followUpReport);	
	
	}

	public Map<String, aFollowUpReport> getModel(){
		    return contentProvider;
	}
}
