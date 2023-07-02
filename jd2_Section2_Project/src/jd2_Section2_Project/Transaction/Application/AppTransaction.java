package jd2_Section2_Project.Transaction.Application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import jd2_Section2_Project.Model.Application;

public class AppTransaction implements IAppTransaction {

	private List<Application> applications;

	public AppTransaction() {
		setApplications(new ArrayList<Application>());
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	private Application getAppById(String id) {
		Predicate<Application> equalId = app -> app.getId().equals(id);

		var data = (Application) applications.stream().filter(equalId).toList().get(0);

		if (data != null) {
			return data;
		} else {
			System.out.println("User not found");
			return null;
		}
	}

	@Override
	public void add(Application data) {
		applications.add(data);
	}

	@Override
	public Application update(Application data) {
		Application app = getAppById(data.getId());
		if (app != null) {
			applications.set(applications.indexOf(app), data);
			return data;
		}
		return null;
	}

	@Override
	public boolean remove(String id) {
		Application app = getAppById(id);
		if (app != null) {
			applications.remove(applications.indexOf(app));
			return true;
		}
		return false;
	}

	@Override
	public List<Application> getAppsFilterBySize(double size) {
		Predicate<Application> lessThenEqualApplications = app -> app.getSize() <= size;
		return applications.stream().filter(lessThenEqualApplications).toList();
	}

	@Override
	public List<Application> getAppsSortedByMemory() {

		Comparator<Application> comparator = Comparator.comparingDouble(Application::getSize);
		return applications.stream().sorted(comparator).toList();
	}

	@Override
	public Map<String, Double> getMemorySumGrupByAppVersion() {
		return applications.stream().collect(
				Collectors.groupingBy(Application::getVersion, Collectors.summingDouble(app -> app.getSize())));
	}

	@Override
	public Application getApplicationByNameAndVersion(String name, String version) {
		Predicate<Application> equalNameAndVersion = app -> app.getName().equals(name)
				&& app.getVersion().equals(version);

		var data = applications.stream().filter(equalNameAndVersion).toList();

		if (data != null && data.size() > 1) {
			return data.get(0);
		}
		return null;
	}

	public DoubleSummaryStatistics getAppsSizeSummaryStatistics() {
		return applications.stream().mapToDouble((x) -> x.getSize()).summaryStatistics();
	}

}
