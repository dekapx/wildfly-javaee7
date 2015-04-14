package com.kapx.jee7.wildfly.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileWriterServiceImpl implements FileWriterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileWriterServiceImpl.class);

	@Override
	public void writeToFile(final String contents) {
		LOGGER.info("writing contents {} to file...", contents);
	}
}
