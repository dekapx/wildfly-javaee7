package com.kapx.jee7.wildfly.ejb;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kapx.jee7.wildfly.util.CsvFileWriter;
import com.kapx.jee7.wildfly.util.FileWriter;
import com.kapx.jee7.wildfly.util.FileWriterFactory;
import com.kapx.jee7.wildfly.util.TextFileWriter;
import com.kapx.jee7.wildfly.util.XmlFileWriter;

@RunWith(Arquillian.class)
public class FileWriterServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(FileWriterServiceTest.class);

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(FileWriterService.class, FileWriterServiceImpl.class, FileWriter.class, CsvFileWriter.class, TextFileWriter.class,
						XmlFileWriter.class, FileWriterFactory.class).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@EJB
	private FileWriterService fileWriterService;

	@Test
	@InSequence(1)
	public void testWriteTextFileContents() throws Exception {
		fileWriterService.writeToFile("dummy contents...");
	}
}
