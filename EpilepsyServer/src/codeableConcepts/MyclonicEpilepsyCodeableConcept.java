package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class MyclonicEpilepsyCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8583222313433835191L;

	public MyclonicEpilepsyCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("WS");
		c1.setDisplay("West Syndrome");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("LGS");
		c2.setDisplay("Lennox-Gastuat Syndrome");
		
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("MEC");
		c3.setDisplay("Myoclonic epilepsy of childhood/adolesence");
		
		
		CodingDt  c4 = new CodingDt();
		c4.setCode("PM");
		c4.setDisplay("Photosensitive myclonus");
		
		CodingDt  c5 = new CodingDt();
		c5.setCode("OTHERS");
		c5.setDisplay("Others");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		codes.add(c4);
		codes.add(c5);
		
		this.setCoding(codes);
		this.setText("myoclonicEpilepsy");
		this.setId("3");
	}
}
