package com.revolut.demo.controller;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class AbstractController<RQ, RS> implements HttpHandler {
	
	private final HttpString header;
    private final String value;
    private final HttpHandler next;

    public AbstractController(final HttpHandler next, final String header, final String value) {
        this.next = next;
        this.value = value;
        this.header = new HttpString(header);
    }

    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(header, value);
        next.handleRequest(exchange);
    }
   
}
