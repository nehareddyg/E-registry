package model;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.util.ElementUtil;

public class FollowUpEncounter extends aEncounter{

	@Child(name = "followUpReport")
	@Extension(url = "http://epilepsy.com/followUpEncounter#followUpReport", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Follow up report of encounter")
	private aFollowUpReport followUpReport;
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil.isEmpty(followUpReport);
	}

	public aFollowUpReport getFollowUpReport() {
		if(followUpReport == null)
			followUpReport = new aFollowUpReport();
		return followUpReport;
	}

	public void setFollowUpReport(aFollowUpReport followUpReport) {
		this.followUpReport = followUpReport;
	}

}

