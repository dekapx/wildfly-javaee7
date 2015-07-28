package com.kapx.jee7.wildfly.util;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.kapx.jee7.wildfly.annotations.CsvWriter;
import com.kapx.jee7.wildfly.annotations.TextWriter;
import com.kapx.jee7.wildfly.annotations.XmlWriter;

@ApplicationScoped
public class FileWriterFactory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Produces
	@CsvWriter
	public FileWriter getCsvFileWriter() {
		return new CsvFileWriter();
	}

	@Produces
	@TextWriter
	public FileWriter getTextFileWriter() {
		return new TextFileWriter();
	}

	@Produces
	@XmlWriter
	public FileWriter getXmlFileWriter() {
		return new XmlFileWriter();
	}
}
