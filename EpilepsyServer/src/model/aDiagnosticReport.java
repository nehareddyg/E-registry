package model;

import java.util.ArrayList;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.resource.TestScript.Teardown;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.util.ElementUtil;
import codeableConcepts.FrequencyOfSeizuresBeforeTreatmentCodeableConcept;

public class aDiagnosticReport extends DiagnosticReport{
	/*
	@Child(name = "ageAtOnset")
	@Extension(url = "http://epilepsy.com/followUpReport#ageAtOnset", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "ageAtOnset")
	private StringDt ageAtOnset;
	
	@Child(name = "typeOfSeizures")
	@Extension(url = "http://epilepsy.com/followUpReport#typeOfSeizures", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "typeOfSeizures")
	private StringDt typeOfSeizures;
	
	@Child(name = "subtypeOfSeizures")
	@Extension(url = "http://epilepsy.com/followUpReport#subtypeOfSeizures", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "subtypeOfSeizures")
	private StringDt subtypeOfSeizures;
	
	@Child(name = "durationOfSeizures")
	@Extension(url = "http://epilepsy.com/followUpReport#durationOfSeizures", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "durationOfSeizures")
	private StringDt durationOfSeizures;
	
	@Child(name = "frequencyOfSeizuresBeforeTreatment")
	@Extension(url = "http://epilepsy.com/followUpReport#frequencyOfSeizuresBeforeTreatment", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "frequencyOfSeizuresBeforeTreatment")
	private StringDt frequencyOfSeizuresBeforeTreatment;
	
	@Child(name = "frequencyOfSeizuresWithTreatment")
	@Extension(url = "http://epilepsy.com/followUpReport#frequencyOfSeizuresWithTreatment", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "frequencyOfSeizuresWithTreatment")
	private StringDt frequencyOfSeizuresWithTreatment;
	
	@Child(name = "clusterAttacks")
	@Extension(url = "http://epilepsy.com/followUpReport#clusterAttacks", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "clusterAttacks")
	private StringDt clusterAttacks;
	
	@Child(name = "statusEpilepticus")
	@Extension(url = "http://epilepsy.com/followUpReport#statusEpilepticus", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "statusEpilepticus")
	private StringDt statusEpilepticus;
	
	@Child(name = "precipitatingFactors")
	@Extension(url = "http://epilepsy.com/followUpReport#precipitatingFactors", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "precipitatingFactors")
	private ArrayList<StringDt> precipitatingFactors;
	
	@Child(name = "pastHistory")
	@Extension(url = "http://epilepsy.com/followUpReport#pastHistory", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "pastHistory")
	private StringDt pastHistory;
	
	@Child(name = "familyHistory")
	@Extension(url = "http://epilepsy.com/followUpReport#familyHistory", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "familyHistory")
	private ArrayList<StringDt> familyHistory;
	
	@Child(name = "probableAetiologicalFactors")
	@Extension(url = "http://epilepsy.com/followUpReport#probableAetiologicalFactors", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "probableAetiologicalFactors")
	private StringDt probableAetiologicalFactors;
	
	@Child(name = "personalityAndMentalStatus")
	@Extension(url = "http://epilepsy.com/followUpReport#personalityAndMentalStatus", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "personalityAndMentalStatus")
	private StringDt personalityAndMentalStatus;
*/
	@Child(name = "descriptionOfClinicalSeizures")
	@Extension(url = "http://epilepsy.com/followUpReport#descriptionOfClinicalSeizures", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Description Of ClinicalSeizures")
	private StringDt descriptionOfClinicalSeizures;
	/*
	@Child(name = "previousTreatment")
	@Extension(url = "http://epilepsy.com/followUpReport#previousTreatment", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "previousTreatment")
	private StringDt previousTreatment;
	
	@Child(name = "generalIntelligence")
	@Extension(url = "http://epilepsy.com/followUpReport#generalIntelligence", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "generalIntelligence")
	private StringDt generalIntelligence;

	@Child(name = "neurologicalExamination")
	@Extension(url = "http://epilepsy.com/followUpReport#neurologicalExamination", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "neurologicalExamination")
	private StringDt neurologicalExamination;
*/
	@Child(name = "treatmentAdvised")
	@Extension(url = "http://epilepsy.com/followUpReport#treatmentAdvised", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Treatment Advised")
	private StringDt treatmentAdvised;
	
	@Child(name = "mtest")
	@Extension(url = "http://epilepsy.com/followUpReport#mtest", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "mtest")
	private StringDt mtest;
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil.isEmpty(descriptionOfClinicalSeizures,treatmentAdvised,mtest);
	}
	/*
	public StringDt getAgeAtOnset() {
		if(ageAtOnset == null)
			ageAtOnset = new StringDt();
		return ageAtOnset;
	}

	public void setAgeAtOnset(StringDt ageAtOnset) {
		this.ageAtOnset = ageAtOnset;
	}

	public StringDt getTypeOfSeizures() {
		if(typeOfSeizures == null)
			typeOfSeizures = new StringDt();
		return typeOfSeizures;
	}

	public void setTypeOfSeizures(StringDt typeOfSeizures) {
		this.typeOfSeizures = typeOfSeizures;
	}

	public StringDt getSubtypeOfSeizures() {
		if(subtypeOfSeizures == null)
			subtypeOfSeizures = new StringDt();
		return subtypeOfSeizures;
	}

	public void setSubtypeOfSeizures(StringDt subtypeOfSeizures) {
		this.subtypeOfSeizures = subtypeOfSeizures;
	}

	public StringDt getDurationOfSeizures() {
		if(durationOfSeizures == null)
			durationOfSeizures = new StringDt();
		return durationOfSeizures;
	}

	public void setDurationOfSeizures(StringDt durationOfSeizures) {
		this.durationOfSeizures = durationOfSeizures;
	}

	public StringDt getFrequencyOfSeizuresBeforeTreatment() {
		if(frequencyOfSeizuresBeforeTreatment == null)
			frequencyOfSeizuresBeforeTreatment = new StringDt();
		return frequencyOfSeizuresBeforeTreatment;
	}

	public void setFrequencyOfSeizuresBeforeTreatment(StringDt frequencyOfSeizuresBeforeTreatment) {
		this.frequencyOfSeizuresBeforeTreatment = frequencyOfSeizuresBeforeTreatment;
	}

	public StringDt getFrequencyOfSeizuresWithTreatment() {
		if(frequencyOfSeizuresWithTreatment == null)
			frequencyOfSeizuresWithTreatment = new StringDt();
		return frequencyOfSeizuresWithTreatment;
	}

	public void setFrequencyOfSeizuresWithTreatment(StringDt frequencyOfSeizuresWithTreatment) {
		this.frequencyOfSeizuresWithTreatment = frequencyOfSeizuresWithTreatment;
	}

	public StringDt getClusterAttacks() {
		if(clusterAttacks == null)
			clusterAttacks = new StringDt();
		return clusterAttacks;
	}

	public void setClusterAttacks(StringDt clusterAttacks) {
		this.clusterAttacks = clusterAttacks;
	}

	public StringDt getStatusEpilepticus() {
		if(statusEpilepticus == null)
			statusEpilepticus = new StringDt();
		return statusEpilepticus;
	}

	public void setStatusEpilepticus(StringDt statusEpilepticus) {
		this.statusEpilepticus = statusEpilepticus;
	}

	public ArrayList<StringDt> getPrecipitatingFactors() {
		if(precipitatingFactors == null)
			precipitatingFactors = new ArrayList<StringDt>();
		return precipitatingFactors;
	}

	public void setPrecipitatingFactors(ArrayList<StringDt> precipitatingFactors) {
		this.precipitatingFactors = precipitatingFactors;
	}

	public StringDt getPastHistory() {
		if(pastHistory == null)
			pastHistory = new StringDt();
		return pastHistory;
	}

	public void setPastHistory(StringDt pastHistory) {
		this.pastHistory = pastHistory;
	}

	public ArrayList<StringDt> getFamilyHistory() {
		if(familyHistory == null)
			familyHistory = new ArrayList<StringDt>();
		return familyHistory;
	}

	public void setFamilyHistory(ArrayList<StringDt> familyHistory) {
		this.familyHistory = familyHistory;
	}

	public StringDt getProbableAetiologicalFactors() {
		if(probableAetiologicalFactors == null)
			probableAetiologicalFactors = new StringDt();
		return probableAetiologicalFactors;
	}

	public void setProbableAetiologicalFactors(StringDt probableAetiologicalFactors) {
		this.probableAetiologicalFactors = probableAetiologicalFactors;
	}

	public StringDt getPersonalityAndMentalStatus() {
		if(personalityAndMentalStatus == null)
			personalityAndMentalStatus = new StringDt();
		return personalityAndMentalStatus;
	}

	public void setPersonalityAndMentalStatus(StringDt personalityAndMentalStatus) {
		this.personalityAndMentalStatus = personalityAndMentalStatus;
	}
*/
	public StringDt getDescriptionOfClinicalSeizures() {
		if(descriptionOfClinicalSeizures == null)
			descriptionOfClinicalSeizures = new StringDt();
		return descriptionOfClinicalSeizures;
	}

	public void setDescriptionOfClinicalSeizures(StringDt descriptionOfClinicalSeizures) {
		this.descriptionOfClinicalSeizures = descriptionOfClinicalSeizures;
	}
/*
	public StringDt getPreviousTreatment() {
		if(previousTreatment == null)
			previousTreatment = new StringDt();
		return previousTreatment;
	}

	public void setPreviousTreatment(StringDt previousTreatment) {
		this.previousTreatment = previousTreatment;
	}

	public StringDt getGeneralIntelligence() {
		if(generalIntelligence == null)
			generalIntelligence = new StringDt();
		return generalIntelligence;
	}

	public void setGeneralIntelligence(StringDt generalIntelligence) {
		this.generalIntelligence = generalIntelligence;
	}

	public StringDt getNeurologicalExamination() {
		if(neurologicalExamination == null)
			neurologicalExamination = new StringDt();
		return neurologicalExamination;
	}

	public void setNeurologicalExamination(StringDt neurologicalExamination) {
		this.neurologicalExamination = neurologicalExamination;
	}
*/
	public StringDt getTreatmentAdvised() {
		if(treatmentAdvised == null)
			treatmentAdvised = new StringDt();
		return treatmentAdvised;
	}

	public void setTreatmentAdvised(StringDt treatmentAdvised) {
		this.treatmentAdvised = treatmentAdvised;
	}
	
	public StringDt getMtest() {
		if(mtest == null)
			mtest = new StringDt();
		return mtest;
	}
	public void setMtest(StringDt mtest) {
		this.mtest = mtest;
	}
}
