package com.kapx.jee7.wildfly.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.kapx.jee7.wildfly.annotations.FileWriter;
import com.kapx.jee7.wildfly.common.FileWriterTypes;

@ApplicationScoped
public class FileWriterFactory {

	@Produces
	@FileWriter(values = FileWriterTypes.CSV_WRITER)
	public com.kapx.jee7.wildfly.util.FileWriter getCsvFileWriter() {
		return new CsvFileWriter();
	}
}
