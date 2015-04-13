package com.kapx.jee7.wildfly.ejb;

import java.util.concurrent.Future;

public interface HelloWorldRemote {
	String sayHello(String arg);

	Future<String> sayHelloAsync(String arg);
}
