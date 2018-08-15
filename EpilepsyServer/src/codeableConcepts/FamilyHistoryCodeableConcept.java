package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class FamilyHistoryCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5809767157804735121L;

	public FamilyHistoryCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("EPI");
		c1.setDisplay("Epilepsy");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("FC");
		c2.setDisplay("Febrile convulsions");
		
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("PSY");
		c3.setDisplay("Psychosis");
		
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("MR");
		c4.setDisplay("Mental retardation");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("OTHERS");
		c5.setDisplay("Others");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		codes.add(c5);
		
		this.setCoding(codes);
		this.setText("familyHistory");
		this.setId("13");
	}
}
