package model;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.util.ElementUtil;

public class aObservation extends Observation{
	@Child(name = "myoclonicEpilepsy")
	@Extension(url = "http://epilepsy.com/observation#myoclonicEpilepsy", definedLocally = false, isModifier = false)
	private StringDt myoclonicEpilepsy;

	@Child(name = "partialSeizures")
	@Extension(url = "http://epilepsy.com/observation#partialSeizures", definedLocally = false, isModifier = false)
	private StringDt partialSeizures;

	@Child(name = "frequencyOfSeizures")
	@Extension(url = "http://epilepsy.com/observation#frequencyOfSeizures", definedLocally = false, isModifier = false)
	private StringDt frequencyOfSeizures;

	@Child(name = "pastHistory")
	@Extension(url = "http://epilepsy.com/observation#pastHistory", definedLocally = false, isModifier = false)
	private StringDt pastHistory;
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil.isEmpty(myoclonicEpilepsy,partialSeizures,frequencyOfSeizures,pastHistory);
	}

	public StringDt getMyoclonicEpilepsy() {
		if (myoclonicEpilepsy == null) {
			myoclonicEpilepsy = new StringDt();
		}
		return myoclonicEpilepsy;
	}

	public void setMyoclonicEpilepsy(StringDt myoclonicEpilepsy) {
		this.myoclonicEpilepsy = myoclonicEpilepsy;
	}

	public StringDt getPartialSeizures() {
		if (partialSeizures == null) {
			partialSeizures = new StringDt();
		}
		return partialSeizures;
	}

	public void setPartialSeizures(StringDt partialSeizures) {
		this.partialSeizures = partialSeizures;
	}

	public StringDt getFrequencyOfSeizures() {
		if (frequencyOfSeizures == null) {
			frequencyOfSeizures = new StringDt();
		}
		return frequencyOfSeizures;
	}

	public void setFrequencyOfSeizures(StringDt frequencyOfSeizures) {
		this.frequencyOfSeizures = frequencyOfSeizures;
	}

	public StringDt getPastHistory() {
		if (pastHistory == null) {
			pastHistory = new StringDt();
		}
		return pastHistory;
	}

	public void setPastHistory(StringDt pastHistory) {
		this.pastHistory = pastHistory;
	}
}
