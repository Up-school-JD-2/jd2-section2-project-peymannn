package jd2_Section2_Project.Transaction.Phone;

import java.util.List;
import java.util.Map;

import jd2_Section2_Project.Model.OperatingSystemEnum;
import jd2_Section2_Project.Model.Phone;
import jd2_Section2_Project.Transaction.ITransaction;

public interface IPhoneTransaction<Phone>{
	public Phone Create(String brand, String model, String serialNumber, double memory, OperatingSystemEnum operatingSystem);
}
