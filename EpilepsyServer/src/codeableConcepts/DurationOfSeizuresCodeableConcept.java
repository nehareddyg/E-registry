package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class DurationOfSeizuresCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2282431166975916530L;

	public DurationOfSeizuresCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("< 1m");
		c1.setDisplay("< 1 month");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("1-2m");
		c2.setDisplay("1-2 months");
		
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("2-3m");
		c3.setDisplay("2-3 months");
		
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("3-6m");
		c4.setDisplay("3-6 months");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("6-12m");
		c5.setDisplay("6-12 months");
		
		CodingDt  c6 = new CodingDt();
		c6.setCode("1-2y");
		c6.setDisplay("1-2 years");
		
		CodingDt  c7 = new CodingDt();
		c7.setCode("2-5y");
		c7.setDisplay("2-5 years");
		
		CodingDt  c8 = new CodingDt();
		c8.setCode("> 5y");
		c8.setDisplay("5 years and above");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		codes.add(c5);
		codes.add(c6);
		codes.add(c7);
		codes.add(c8);
		
		this.setCoding(codes);
		this.setText("durationOfSeizures");
		this.setId("7");
	}
}
