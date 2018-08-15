package model;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.util.ElementUtil;

public class NewEncounter extends aEncounter{
	
	@Child(name = "diagnosticReport")
	@Extension(url = "http://epilepsy.com/newEncounter#diagnosticReport", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Diagnostic report of encounter")
	private aDiagnosticReport diagnosticReport;
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil.isEmpty(diagnosticReport);
	}

	public aDiagnosticReport getDiagnosticReport() {
		if(diagnosticReport == null)
			diagnosticReport = new aDiagnosticReport();
		return diagnosticReport;
	}

	public void setDiagnosticReport(aDiagnosticReport diagnosticReport) {
		this.diagnosticReport = diagnosticReport;
	}

}
