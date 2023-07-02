package jd2_Section2_Project.Model;

import java.util.EnumSet;

public enum OperatingSystemEnum {
	ANDROID, IOS;

	public static OperatingSystemEnum getOperatingSystem(String type) {
		var operatingSystems = EnumSet.allOf(OperatingSystemEnum.class);
		for (OperatingSystemEnum enumData : operatingSystems) {
			if (enumData.name().equalsIgnoreCase(type)) {
				return enumData;
			}
		}
		return null;
	}
}
