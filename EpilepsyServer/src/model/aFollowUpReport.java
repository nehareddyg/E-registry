package model;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.util.ElementUtil;

public class aFollowUpReport extends DiagnosticReport{

	@Child(name = "regularity")
	@Extension(url = "http://epilepsy.com/followUpReport#regularity", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Regularity of treatment")
	private StringDt regularity;
	
	@Child(name = "adverseEvents")
	@Extension(url = "http://epilepsy.com/followUpReport#aderseEvents", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Adverse Events")
	private StringDt adverseEvents;
	
	@Child(name = "remarks")
	@Extension(url = "http://epilepsy.com/followUpReport#remarks", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Any other remarks")
	private StringDt remarks;

	@Child(name = "nextDate")
	@Extension(url = "http://epilepsy.com/followUpReport#nextDate", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Next date for follow-up")
	private DateDt nextDate;

	@Override
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil.isEmpty(regularity,adverseEvents,remarks,nextDate);
	}

	public StringDt getRegularity() {
		if(regularity == null)
			regularity = new StringDt();
		return regularity;
	}

	public void setRegularity(StringDt regularity) {
		this.regularity = regularity;
	}

	public StringDt getAdverseEvents() {
		if(adverseEvents == null)
			adverseEvents = new StringDt();
		return adverseEvents;
	}

	public void setAdverseEvents(StringDt adverseEvents) {
		this.adverseEvents = adverseEvents;
	}

	public StringDt getRemarks() {
		if(remarks == null)
			remarks = new StringDt();
		return remarks;
	}

	public void setRemarks(StringDt remarks) {
		this.remarks = remarks;
	}

	public DateDt getNextDate() {
		if(nextDate == null)
			nextDate = new DateDt();
		return nextDate;
	}

	public void setNextDate(DateDt nextDate) {
		this.nextDate = nextDate;
	}
	
	
}
