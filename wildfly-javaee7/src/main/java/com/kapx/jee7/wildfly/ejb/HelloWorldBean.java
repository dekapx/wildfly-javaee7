package com.kapx.jee7.wildfly.ejb;

import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Local(HelloWorldLocal.class)
@Remote(HelloWorldRemote.class)
public class HelloWorldBean implements HelloWorldLocal, HelloWorldRemote {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldBean.class);

	@PostConstruct
	public void setup() {
		LOGGER.info("HelloWorldBean initialized...");
	}

	@PreDestroy
	public void teardown() {
		LOGGER.info("HelloWorldBean destroyed...");
	}

	@Override
	public String sayHello(final String arg) {
		LOGGER.info("sayHello() method invoked with parameter \"{}\"", arg);
		return "Hello !!! " + arg;
	}

	@Override
	@Asynchronous
	public Future<String> sayHelloAsync(final String arg) {
		LOGGER.info("sayHelloAsync() method invoked with parameter \"{}\"", arg);
		return new AsyncResult<String>("Hello !!! " + arg);
	}

}
