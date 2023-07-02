package jd2_Section2_Project.Transaction.User;

import java.util.List;

import jd2_Section2_Project.Model.User;
import jd2_Section2_Project.Transaction.ITransaction;

public interface IUserTransaction extends ITransaction<User>{
	public User getUserByName(String name);
	public List<User> getUsersSortedByName();

}
