package jd2_Section2_Project.Transaction;

public interface ITransaction<T> {
	
	public void add(T data);

	public T update(T data);

	public boolean remove(String id);
}
