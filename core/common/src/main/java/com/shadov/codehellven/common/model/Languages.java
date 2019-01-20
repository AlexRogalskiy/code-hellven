package com.shadov.codehellven.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Languages {
	JAVA, SCALA;

	@JsonCreator
	public static Languages fromString(String key) {
		for (Languages type : Languages.values()) {
			if (type.name().equalsIgnoreCase(key))
				return type;
		}
		return null;
	}
}
