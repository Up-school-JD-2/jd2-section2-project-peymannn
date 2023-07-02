package jd2_Section2_Project.Model;

public class Application extends Data{
	
	private String version;
	private double size;
	public Application( String id,String name, String version, double size) {
		super(name, id);
		this.version = version;
		this.size = size;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Application [version=" + version + ", size=" + size + ", getName()=" + getName() + "]";
	}
	
}
