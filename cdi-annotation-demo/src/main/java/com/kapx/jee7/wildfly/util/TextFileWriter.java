package com.kapx.jee7.wildfly.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextFileWriter implements FileWriter {

	private static final Logger LOGGER = LoggerFactory.getLogger(TextFileWriter.class);

	@Override
	public void write(final String contents) {
		LOGGER.info("writing contents {} to Text file...", contents);
	}

}
