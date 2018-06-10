/**
 * 
 */
package com.revolut.demo;

import com.revolut.demo.controller.HelloWorldHandler;

import io.undertow.Undertow;

/**
 * @author geovanefilho
 *
 */
public class StartDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(new HelloWorldHandler()).build();
        server.start();
	}

}
