/**
 * 
 */
package com.revolut.demo.controller;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 * @author geovanefilho
 *
 */
public class HelloWorldHandler implements HttpHandler {

	/* (non-Javadoc)
	 * @see io.undertow.server.HttpHandler#handleRequest(io.undertow.server.HttpServerExchange)
	 */
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello teste");
	}

}
