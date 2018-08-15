package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class AgeAtOnsetCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7933013663596114413L;

	public AgeAtOnsetCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("< 6m");
		c1.setDisplay("< 6 months");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("6m1y");
		c2.setDisplay("6 months 1 year");
		
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("1-5y");
		c3.setDisplay("1-5 years");
	
		CodingDt  c4 = new CodingDt();
		c4.setCode("5-10y");
		c4.setDisplay("5-10 years");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("10-15y");
		c5.setDisplay("10-15 years");
		
		CodingDt  c6 = new CodingDt();
		c6.setCode("15-20y");
		c6.setDisplay("15-20 years");
		
		CodingDt  c7 = new CodingDt();
		c7.setCode("20-30y");
		c7.setDisplay("20-30 years");
		
		CodingDt  c8 = new CodingDt();
		c8.setCode("30-40y");
		c8.setDisplay("30-40 years");
		
		CodingDt  c9 = new CodingDt();
		c9.setCode("> 40y");
		c9.setDisplay("above 40 years");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		codes.add(c5);
		codes.add(c6);
		codes.add(c7);
		codes.add(c8);
		codes.add(c9);
		
		this.setCoding(codes);
		this.setText("ageAtOnset");
		this.setId("1");
	}
}
