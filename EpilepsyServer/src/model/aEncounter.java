package model;

import java.util.List;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.util.ElementUtil;

public class aEncounter extends Encounter{

	@Child(name = "practitioner")
	@Extension(url = "http://epilepsy.com/encounter#practitioner", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Practitioner involved in Encounter")
	private aPractitioner practitioner;
	
	@Child(name = "date")
	@Extension(url = "http://epilepsy.com/encounter#date", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Date of encounter")
	private DateDt date;
	
	@Child(name = "location")
	@Extension(url = "http://epilepsy.com/encounter#location", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Location of encounter")
	private ca.uhn.fhir.model.dstu2.resource.Location location;

	@Override
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil.isEmpty(practitioner,date,location);
	}


	public aPractitioner getPractitioner() {
		if (practitioner == null) {
			practitioner = new aPractitioner();
		}
		return practitioner;
	}


	public void setPractitioner(aPractitioner practitioner) {
		this.practitioner = practitioner;
	}


	public DateDt getDate() {
		if (date == null) {
			date = new DateDt();
		}
		return date;
	}


	public void setDate(DateDt date) {
		this.date = date;
	}

	public ca.uhn.fhir.model.dstu2.resource.Location getLoc() {
		if (location == null) {
			location = new ca.uhn.fhir.model.dstu2.resource.Location();
		}
		return location;
	}


	public void setLoc(ca.uhn.fhir.model.dstu2.resource.Location location) {
		this.location = location;
	}

}
