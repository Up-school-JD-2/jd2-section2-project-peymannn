package jd2_Section2_Project.Validation;

import jd2_Section2_Project.Model.User;

public class UserValidation implements IValidation<User>{

	@Override
	public boolean IsValid(User user) {
		if (user.getEmail().contains("@") && user.getEmail().endsWith(".com")) {
			return true;
		}
		return false;
	}

}
