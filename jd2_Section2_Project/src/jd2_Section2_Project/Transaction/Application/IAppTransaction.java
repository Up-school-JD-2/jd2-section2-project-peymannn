package jd2_Section2_Project.Transaction.Application;

import java.util.List;
import java.util.Map;

import jd2_Section2_Project.Model.Application;
import jd2_Section2_Project.Model.User;
import jd2_Section2_Project.Transaction.ITransaction;

public interface IAppTransaction extends ITransaction<Application>{
	public List<Application> getAppsFilterBySize(double size);//5
	public List<Application> getAppsSortedByMemory();//6
	public Map<String, Double> getMemorySumGrupByAppVersion();//7
	public Application getApplicationByNameAndVersion(String name,String version);//4
	
}
