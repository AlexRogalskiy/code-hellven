package com.shadov.codehellven.common;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;

public class Check {
	public static boolean noBlanks(String... args) {
		return Arrays.stream(args).noneMatch(StringUtils::isBlank);
	}

	public static boolean anyBlank(String... args) {
		return Arrays.stream(args).anyMatch(StringUtils::isBlank);
	}

	public static boolean isNull(Object object) {
		return Objects.isNull(object);
	}

	public static boolean notNull(Object object) {
		return !Objects.isNull(object);
	}
}
