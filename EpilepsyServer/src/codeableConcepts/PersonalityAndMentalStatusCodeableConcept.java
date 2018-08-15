package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class PersonalityAndMentalStatusCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7958702745231963829L;

	public PersonalityAndMentalStatusCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("NORM");
		c1.setDisplay("Normal");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("MR");
		c2.setDisplay("Mental retardation");
		
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("PSY");
		c3.setDisplay("Psychosis");
		
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("NEU");
		c4.setDisplay("Neurosis");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("BEH");
		c5.setDisplay("Behavioural problem");
		
		CodingDt  c6 = new CodingDt();
		c6.setCode("IRR");
		c6.setDisplay("Irritability");
		
		CodingDt  c7 = new CodingDt();
		c7.setCode("DM");
		c7.setDisplay("Deterioration of memory");
		
		CodingDt  c8 = new CodingDt();
		c8.setCode("MRBEH");
		c8.setDisplay("M R + Behaviour problem");
		
		CodingDt  c9 = new CodingDt();
		c9.setCode("MR");
		c9.setDisplay("M R + Psychosis");
		
		CodingDt  c10 = new CodingDt();
		c10.setCode("OTHERS");
		c10.setDisplay("Others");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		codes.add(c5);
		codes.add(c6);
		codes.add(c7);
		codes.add(c8);
		codes.add(c9);
		codes.add(c10);
		
		this.setCoding(codes);
		this.setText("personalityAndMentalStatus");
		this.setId("15");
	}
}
