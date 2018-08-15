package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class PreviousTreatmentCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2751605010241941818L;

	public PreviousTreatmentCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("T");
		c1.setDisplay("Treated");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("NT");
		c2.setDisplay("Not treated");
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("NN");
		c3.setDisplay("Not known");
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("NA");
		c4.setDisplay("Not applicable");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		
		this.setCoding(codes);
		this.setText("previousTreatment");
		this.setId("16");
	}
}
