package com.kapx.wildfly.javaee7.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Local(HelloWorldLocal.class)
public class HelloWorldBean implements HelloWorldLocal {
	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldBean.class);

	@PostConstruct
	public void init() {
		LOG.info("HelloWorldBean initialized...");
	}

	@PreDestroy
	public void destroy() {
		LOG.info("HelloWorldBean destroyed...");
	}

	@Override
	public String sayHello(String arg) {
		LOG.info("sayHello invoked with parameter {}", arg);
		return "Hello !!! " + arg;
	}
}
