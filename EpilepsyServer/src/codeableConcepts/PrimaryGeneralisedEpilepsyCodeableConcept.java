package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class PrimaryGeneralisedEpilepsyCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7545806289576511831L;

	public PrimaryGeneralisedEpilepsyCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("TCE");
		c1.setDisplay("Tonic-Clonic epilepsy");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("TE");
		c2.setDisplay("Tonic epilepsy");
		
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("CE");
		c3.setDisplay("Clonic epilepsy");
		
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("FC");
		c4.setDisplay("Febrile convulsions");
				
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		
		this.setCoding(codes);
		this.setText("primaryGeneralisedEpilepsy");
		this.setId("4");
	}
}
