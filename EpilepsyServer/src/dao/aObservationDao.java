package dao;

import java.util.HashMap;
import java.util.Map;

import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import model.aObservation;
import model.aPatient;

public enum aObservationDao {
	instance;

	private Map<String, aObservation> contentProvider = new HashMap<>();

	private aObservationDao() {
		
		aObservation o = new aObservation();
		o.setId("1");
		o.setMyoclonicEpilepsy(new StringDt("West's Syndrome"));
		o.setPartialSeizures(new StringDt("Simple partial seizures"));
		o.setFrequencyOfSeizures(new StringDt("Once a day"));
		o.setPastHistory(new StringDt("Birth trauma"));
				
		contentProvider.put("1", o);
	}

	public Map<String, aObservation> getModel(){
		    return contentProvider;
	}
}
