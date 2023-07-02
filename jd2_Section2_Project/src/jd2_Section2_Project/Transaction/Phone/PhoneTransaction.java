package jd2_Section2_Project.Transaction.Phone;

import jd2_Section2_Project.Model.OperatingSystemEnum;
import jd2_Section2_Project.Model.Phone;

public class PhoneTransaction implements IPhoneTransaction<Phone> {

	@Override
	public Phone Create(String brand, String model, String serialNumber, double memory, OperatingSystemEnum operatingSystem) {
		Phone phoneInfo = new Phone(brand, model, serialNumber, memory, operatingSystem);
		return phoneInfo;
	}
}
