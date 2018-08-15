package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class AbsenceCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7903634881005860046L;

	public AbsenceCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("SA");
		c1.setDisplay("Simple absence");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("CA");
		c2.setDisplay("Complex absence");
		
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("AA");
		c3.setDisplay("Atonic absence");
		
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("MA");
		c4.setDisplay("Myoclonic absence");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("OTHERS");
		c5.setDisplay("Others");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		codes.add(c5);
		
		this.setCoding(codes);
		this.setText("absence");
		this.setId("2");
	}
}
