package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class ClusterAttacksCodeableConcept extends CodeableConceptDt{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6767191048648826601L;

	public ClusterAttacksCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("ABS");
		c1.setDisplay("Absent");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("PRE");
		c2.setDisplay("Present");
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("NA");
		c3.setDisplay("Not applicable");
		
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		
		this.setCoding(codes);
		this.setText("clusterAttacks");
		this.setId("9");
	}
}
