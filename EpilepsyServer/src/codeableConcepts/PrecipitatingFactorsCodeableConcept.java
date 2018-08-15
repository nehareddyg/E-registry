package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class PrecipitatingFactorsCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -299079972695787994L;

	public PrecipitatingFactorsCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("SLEEP");
		c1.setDisplay("Sleep");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("LOS");
		c2.setDisplay("Lack of sleep");
		
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("EF");
		c3.setDisplay("Emotional factors");
		
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("HUNGER");
		c4.setDisplay("Hunger");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("OA");
		c5.setDisplay("Omission of anticonvulsants");
		
		CodingDt  c6 = new CodingDt();
		c6.setCode("HWB");
		c6.setDisplay("Hot water bath");
		
		CodingDt  c7 = new CodingDt();
		c7.setCode("FEVER");
		c7.setDisplay("Fever");
		
		CodingDt  c8 = new CodingDt();
		c8.setCode("OTHERS");
		c8.setDisplay("Others");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		codes.add(c5);
		codes.add(c6);
		codes.add(c7);
		codes.add(c8);
		
		this.setCoding(codes);
		this.setText("precipitatingFactors");
		this.setId("11");
	}
}
