package jd2_Section2_Project.Model;

public class Phone  {
	public Phone(String brand, String model, String serialNumber, double memory, OperatingSystemEnum operatingSystem) {
		super();
		this.brand = brand;
		this.model = model;
		this.serialNumber = serialNumber;
		this.memory = memory;
		this.operatingSystem = operatingSystem;
	}
	private String brand;
	private String model;
	private String serialNumber;
	private double memory;
	private OperatingSystemEnum operatingSystem;
	
	public OperatingSystemEnum getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(OperatingSystemEnum operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", model=" + model + ", serialNumber=" + serialNumber + ", memory=" + memory
				+ ", operatingSystem=" + operatingSystem + "]";
	}
	public double getMemory() {
		return memory;
	}
}
