package com.shadov.codehellven.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Difficulty {
	STARTING(1), EASY(3), MEDIUM(5), HARD(10), GOD(50);

	private int reputation;

	Difficulty(int reputation) {
		this.reputation = reputation;
	}

	public int reputation() {
		return reputation;
	}

	@JsonCreator
	public static Difficulty fromString(String key) {
		for (Difficulty type : Difficulty.values()) {
			if (type.name().equalsIgnoreCase(key))
				return type;
		}
		return null;
	}
}
