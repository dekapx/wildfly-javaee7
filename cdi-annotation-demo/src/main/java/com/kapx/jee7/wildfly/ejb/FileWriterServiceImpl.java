package com.kapx.jee7.wildfly.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kapx.jee7.wildfly.annotations.TextWriter;
import com.kapx.jee7.wildfly.util.FileWriter;

@Stateless
@Local(FileWriterService.class)
public class FileWriterServiceImpl implements FileWriterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileWriterServiceImpl.class);

	@Inject
	@TextWriter
	private FileWriter textFileWriter;

	@Override
	public void writeToFile(final String contents) {
		LOGGER.info("delegating call :: writing contents {} to file...", contents);

		textFileWriter.write(contents);
	}
}
