package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class FollowUpFrequencyCodeableConcept extends CodeableConceptDt{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1168026312009617179L;

	public FollowUpFrequencyCodeableConcept() {
		
		List<CodingDt> codes = new ArrayList<CodingDt>();

		CodingDt  c1 = new CodingDt();
		c1.setCode("INR");
		c1.setDisplay("Increased");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("DCR");
		c2.setDisplay("Decreased");

		codes.add(c1);
		codes.add(c2);
		
		this.setCoding(codes);
		this.setText("frequency");
		this.setId("1");
	}
}
