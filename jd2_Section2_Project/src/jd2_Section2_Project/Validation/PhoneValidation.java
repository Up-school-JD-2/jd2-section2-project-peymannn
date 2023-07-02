package jd2_Section2_Project.Validation;

import jd2_Section2_Project.Model.Phone;

public class PhoneValidation implements IValidation<Phone>{

	@Override
	public boolean IsValid(Phone phone) {
		if (phone.getSerialNumber().length() != 11) {
			return false;
		}
		for (char c : phone.getSerialNumber().toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

}
