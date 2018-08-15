package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class PastHistoryCodeableConcept extends CodeableConceptDt{


/**
	 * 
	 */
	private static final long serialVersionUID = -3514497629173979944L;

public PastHistoryCodeableConcept() {
		
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("NS");
		c1.setDisplay("None significant");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("FC");
		c2.setDisplay("Febrile convulsions");
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("HI");
		c3.setDisplay("Head injury");
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("CNS");
		c4.setDisplay("CNS infections");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("BT");
		c5.setDisplay("Birth trauma");
		
		CodingDt  c6 = new CodingDt();
		c6.setCode("NA");
		c6.setDisplay("Not applicable");
				
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		codes.add(c5);
		codes.add(c6);
		
		this.setCoding(codes);
		this.setText("pastHistory");
		this.setId("12");
	}

}
