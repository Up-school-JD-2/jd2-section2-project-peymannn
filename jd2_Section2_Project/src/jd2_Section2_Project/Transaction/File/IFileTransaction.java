package jd2_Section2_Project.Transaction.File;

import java.util.List;

import jd2_Section2_Project.Model.Phone;
import jd2_Section2_Project.Model.User;

public interface IFileTransaction {
	public void write (Phone phone, List<User> userList);
	public void read ();
}
