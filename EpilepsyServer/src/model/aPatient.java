package model;

import java.util.ArrayList;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.util.ElementUtil;

public class aPatient extends Patient {

	@Child(name = "age")
	@Extension(url = "http://epilepsy.com/patient#age", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Age of patient")
	private IntegerDt age;

	@Child(name = "sex")
	@Extension(url = "http://epilepsy.com/patient#sex", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Gender of patient")
	private StringDt sex;

	@Child(name = "siNo")
	@Extension(url = "http://epilepsy.com/patient#siNo", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "SI Number of patient")
	private StringDt siNo;

	@Child(name = "fatherName")
	@Extension(url = "http://epilepsy.com/patient#fatherName", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Name of patient's father")
	private StringDt fatherName;

	@Child(name = "village")
	@Extension(url = "http://epilepsy.com/patient#village", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Name of patient's village")
	private StringDt village;
	
	@Child(name = "newEncounter")
	@Extension(url = "http://epilepsy.com/patient#newEncounter", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "New encounter of patient")
	private NewEncounter newEncounter;

	
	@Child(name = "followupEncounters")
	@Extension(url = "http://epilepsy.com/patient#followUpEncounter", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "FollowUp encounters of patient")
	private ArrayList<FollowUpEncounter> followUpEncounters;
	
	@Child(name = "isCaseFormFilled")
	@Extension(url = "http://epilepsy.com/patient#isCaseFormFilled", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "True if patient's case form is filled")
	private BooleanDt isCaseFormFilled;
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil.isEmpty(age, sex, siNo, fatherName, village, newEncounter, followUpEncounters,isCaseFormFilled);
	}

	public IntegerDt getAge() {
		if (age == null) {
			age = new IntegerDt();
		}
		return age;
	}

	public void setAge(IntegerDt age) {
		this.age = age;
	}

	public NewEncounter getNewEncounter() {
		return newEncounter;
	}

	public void setNewEncounter(NewEncounter newEncounter) {
		this.newEncounter = newEncounter;
	}

	public ArrayList<FollowUpEncounter> getFollowUpEncounters() {
		return followUpEncounters;
	}

	public void setFollowUpEncounters(ArrayList<FollowUpEncounter> followUpEncounters) {
		this.followUpEncounters = followUpEncounters;
	}


	public StringDt getSex() {
		if (sex == null) {
			sex = new StringDt();
		}
		return sex;
	}

	public void setSex(StringDt sex) {
		this.sex = sex;
	}
	
	public StringDt getSiNo() {
		if (siNo == null) {
			siNo = new StringDt();
		}
		return siNo;
	}

	public void setSiNo(StringDt siNo) {
		this.siNo = siNo;
	}
	
	public StringDt getFatherName() {
		if (fatherName == null) {
			fatherName = new StringDt();
		}
		return fatherName;
	}

	public void setfatherName(StringDt fatherName) {
		this.fatherName = fatherName;
	}
	
	public StringDt getVillage() {
		if (village == null) {
			village = new StringDt();
		}
		return village;
	}

	public void setVillage(StringDt village) {
		this.village = village;
	}
	
	public BooleanDt getIsCaseFormFilled() {
		if (isCaseFormFilled == null) {
			isCaseFormFilled = new BooleanDt();
		}
		return isCaseFormFilled;
	}

	public void setIsCaseFormFilled(BooleanDt isCaseFormFilled) {
		this.isCaseFormFilled = isCaseFormFilled;
	}
}
