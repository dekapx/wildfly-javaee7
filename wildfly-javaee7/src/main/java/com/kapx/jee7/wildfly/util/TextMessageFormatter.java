package com.kapx.jee7.wildfly.util;

import javax.enterprise.inject.Default;

@Default
public class TextMessageFormatter {
	public String format(final String text) {
		return "Hello !!! " + text;
	}
}
