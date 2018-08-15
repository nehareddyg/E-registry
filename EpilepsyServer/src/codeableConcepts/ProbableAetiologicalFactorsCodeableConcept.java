package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class ProbableAetiologicalFactorsCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3211297299635529880L;

	public ProbableAetiologicalFactorsCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("EI");
		c1.setDisplay("Essential/Idiopathic");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("PBD");
		c2.setDisplay("Perinatal birth damage");
		
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("TBI");
		c3.setDisplay("Traumatic birth injury");
		
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("INF");
		c4.setDisplay("Inflammatory");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("MET");
		c5.setDisplay("Metabolic");
		
		CodingDt  c6 = new CodingDt();
		c6.setCode("VAS");
		c6.setDisplay("Vascular");
		
		CodingDt  c7 = new CodingDt();
		c7.setCode("BT");
		c7.setDisplay("Brain tumour");
		
		CodingDt  c8 = new CodingDt();
		c8.setCode("DEG/ATR");
		c8.setDisplay("Degenrative/Atrophic");
		
		CodingDt  c9 = new CodingDt();
		c9.setCode("OTHERS");
		c9.setDisplay("Others");
		
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
		this.setText("probableAetiologicalFactors");
		this.setId("14");
	}
}
