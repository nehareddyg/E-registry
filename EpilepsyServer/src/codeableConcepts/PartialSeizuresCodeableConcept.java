package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class PartialSeizuresCodeableConcept extends CodeableConceptDt{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5416185470778435947L;

	public PartialSeizuresCodeableConcept() {
		
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("SPS");
		c1.setDisplay("Simple partial seizures");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("CPS");
		c2.setDisplay("Complex partial seizures");
		
		codes.add(c1);
		codes.add(c2);
		
		this.setCoding(codes);
		this.setText("partialSeizures");
		this.setId("5");
	}
	
}
