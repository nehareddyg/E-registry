package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class GeneralIntelligenceCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -346061062216260783L;

	public GeneralIntelligenceCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("NORM");
		c1.setDisplay("Normal");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("MS");
		c2.setDisplay("Mild subnormality");
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("MS");
		c3.setDisplay("Moderate subnormality");
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("SS");
		c4.setDisplay("Severe subnormality");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("NA");
		c5.setDisplay("Not applicable");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		codes.add(c5);
		
		this.setCoding(codes);
		this.setText("generalIntelligence");
		this.setId("17");
	}
}
