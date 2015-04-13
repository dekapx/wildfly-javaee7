package com.kapx.jee7.wildfly.ejb;

import java.util.concurrent.Future;

public interface HelloWorldLocal {
	String sayHello(String arg);

	Future<String> sayHelloAsync(String arg);
}
