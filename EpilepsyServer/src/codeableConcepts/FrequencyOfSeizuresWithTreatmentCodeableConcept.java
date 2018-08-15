package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class FrequencyOfSeizuresWithTreatmentCodeableConcept extends CodeableConceptDt{

/**
	 * 
	 */
	private static final long serialVersionUID = -981724218388868315L;

public FrequencyOfSeizuresWithTreatmentCodeableConcept() {
		
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("MTPD");
		c1.setDisplay("Many times a day");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("OAD");
		c2.setDisplay("Once a day");
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("2-7d");
		c3.setDisplay("Once in 2-7 days");
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("8-15d");
		c4.setDisplay("Once in 8-15 days");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("15-30d");
		c5.setDisplay("Once in 15-30 days");
		
		CodingDt  c6 = new CodingDt();
		c6.setCode("1-3m");
		c6.setDisplay("1-3 months");
		
		CodingDt  c7 = new CodingDt();
		c7.setCode("3-6m");
		c7.setDisplay("3-6 months");
		
		CodingDt  c8 = new CodingDt();
		c8.setCode("6-12m");
		c8.setDisplay("6-12 months");
		
		CodingDt  c9 = new CodingDt();
		c9.setCode("1-2y");
		c9.setDisplay("1-2 years");
		
		CodingDt  c10 = new CodingDt();
		c10.setCode("NA");
		c10.setDisplay("Not applicable");
		
		
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
		this.setText("frequencyOfSeizuresWithTreatment");
		this.setId("9");
	}

}
