package model;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.util.ElementUtil;

public class aPractitioner extends Practitioner{
	
	@Child(name = "role")
	@Extension(url = "http://epilepsy.com/practitioner#role", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Role of Practitioner")
	private aPractitionerRoleEnum role;
	
	@Child(name = "username")
	@Extension(url = "http://epilepsy.com/practitioner#username", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Username of Practitioner")
	private StringDt username;
	
	@Child(name = "password")
	@Extension(url = "http://epilepsy.com/practitioner#password", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "Password of practitioner")
	private StringDt password;
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty() && ElementUtil.isEmpty(role,username,password);
	}
	
	public aPractitionerRoleEnum getRole() {
		if (role == null) {
			role = aPractitionerRoleEnum.specializedDoctor;
		}
		return role;
	}

	public StringDt getUsername() {
		if (username == null) {
			username = new StringDt();
		}
		return username;
	}

	public void setUsername(StringDt username) {
		this.username = username;
	}

	public StringDt getPassword() {
		if (password == null) {
			password = new StringDt();
		}
		return password;
	}

	public void setPassword(StringDt password) {
		this.password = password;
	}

	public void setRole(aPractitionerRoleEnum role) {
		this.role = role;
	}
	
}
