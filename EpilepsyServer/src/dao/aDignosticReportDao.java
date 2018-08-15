package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.valueset.DiagnosticOrderPriorityEnum;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import codeableConcepts.AbsenceCodeableConcept;
import codeableConcepts.AgeAtOnsetCodeableConcept;
import codeableConcepts.ClusterAttacksCodeableConcept;
import codeableConcepts.DurationOfSeizuresCodeableConcept;
import codeableConcepts.FamilyHistoryCodeableConcept;
import codeableConcepts.FrequencyOfSeizuresBeforeTreatmentCodeableConcept;
import codeableConcepts.FrequencyOfSeizuresWithTreatmentCodeableConcept;
import codeableConcepts.GeneralIntelligenceCodeableConcept;
import codeableConcepts.MyclonicEpilepsyCodeableConcept;
import codeableConcepts.NeurologicalExaminationCodeableConcept;
import codeableConcepts.PartialSeizuresCodeableConcept;
import codeableConcepts.PastHistoryCodeableConcept;
import codeableConcepts.PersonalityAndMentalStatusCodeableConcept;
import codeableConcepts.PrecipitatingFactorsCodeableConcept;
import codeableConcepts.PreviousTreatmentCodeableConcept;
import codeableConcepts.ProbableAetiologicalFactorsCodeableConcept;
import codeableConcepts.StatusEpilepticusCodeableConcept;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import model.aDiagnosticReport;
import model.aObservation;
import model.aPatient;

public enum aDignosticReportDao {
	instance;

	
	private Map<String, aDiagnosticReport> contentProvider = new HashMap<>();

	private aDignosticReportDao() {

/*		aDiagnosticReport diagnosticReport = new aDiagnosticReport();
		
		CodeableConceptDt m = new AgeAtOnsetCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("6 months 1 year"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);
		
		m = new ClusterAttacksCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Present"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);
		
		m = new DurationOfSeizuresCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("1-2 months"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);
		
		m = new MyclonicEpilepsyCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("West Syndrome"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);
		
		m = new FrequencyOfSeizuresBeforeTreatmentCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Once a day"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);

		m = new FrequencyOfSeizuresWithTreatmentCodeableConcept();		
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Once in 8-15 days"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);

		m = new StatusEpilepticusCodeableConcept();	
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Not applicable"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);

		m = new PrecipitatingFactorsCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Emotional factors") || c.getDisplay().equals("Hunger"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);

		m = new PastHistoryCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Febrile convulsions"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);

		m = new FamilyHistoryCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Psychosis") || c.getDisplay().equals("Mental retardation"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);

		m = new ProbableAetiologicalFactorsCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Traumatic birth injury"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);

		m = new PersonalityAndMentalStatusCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Mental retardation"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);

		diagnosticReport.setDescriptionOfClinicalSeizures(new StringDt("Nothing significant"));
		
		m = new PreviousTreatmentCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Not treated"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);

		m = new GeneralIntelligenceCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Mild subnormality"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);


		m = new NeurologicalExaminationCodeableConcept();
		for(CodingDt c : m.getCoding()) {
			if(c.getDisplay().equals("Abnormal"))
				c.setUserSelected(true);
			else
				c.setUserSelected(false);
		}
		diagnosticReport.addCodedDiagnosis(m);
		
		diagnosticReport.setTreatmentAdvised(new StringDt("Nothing significant"));

		contentProvider.put("1", diagnosticReport);*/
	}

	public Map<String, aDiagnosticReport> getModel(){
		    return contentProvider;
	}
}
