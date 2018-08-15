package codeableConcepts;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;

public class NeurologicalExaminationCodeableConcept extends CodeableConceptDt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6856907005536993358L;

	public NeurologicalExaminationCodeableConcept() {
		List<CodingDt> codes = new ArrayList<CodingDt>();
		
		CodingDt  c1 = new CodingDt();
		c1.setCode("NORM");
		c1.setDisplay("Normal");
		
		CodingDt  c2 = new CodingDt();
		c2.setCode("ABNORM");
		c2.setDisplay("Abnormal");
		
		CodingDt  c3 = new CodingDt();
		c3.setCode("NDNP");
		c3.setDisplay("Not done/Not possible");
		
		codes.add(c1);
		codes.add(c2);
		codes.add(c3);
		
		this.setCoding(codes);
		this.setText("neurologicalExamination");
		this.setId("18");
	}
}
