package jd2_Section2_Project.Transaction.User;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import jd2_Section2_Project.Model.Application;
import jd2_Section2_Project.Model.User;

public class UserTransaction implements IUserTransaction {
	private Map<String, User> users;

	public UserTransaction() {
		users = new HashMap<>();
	}
	public List<User> getUsers() {
		return users.values().stream().toList();
	}
	@Override
	public void add(User data) {
		users.put(data.getId(), data);
	}
	
	public User getUserById(String id) {
		return users.get(id);
	}
	
	@Override
	public User getUserByName(String name) {
		Predicate<User> equalName = user->user.getName().equals(name);
		
		var data= (User) getUsers().stream().filter(equalName).toArray()[0];
		
		if (data != null) {
			System.out.println(data.toString());
		} else {
			System.out.println("User not found");
			return null;
		}
		return data;
	}
	@Override
	public User update(User data) {
		User user = getUserById(data.getId());
		if (user != null) {
			users.replace(data.getId(), data);
			System.out.println("User updated successfully");
		} else {
			System.out.println("User not found");
			return null;
		}
		return data;
	}

	@Override
	public boolean remove(String id) {
		User user = getUserById(id);
		if (user != null) {
			users.remove(id);
			System.out.println("User remove successfully");
			return true;
		} else {
			System.out.println("User not found");			
		}
		return false;
	}
	@Override
	public List<User> getUsersSortedByName() {

		Comparator<User> comparator = Comparator.comparing(User::getName);
		return users.values().stream().sorted(comparator).toList();
	}
}
