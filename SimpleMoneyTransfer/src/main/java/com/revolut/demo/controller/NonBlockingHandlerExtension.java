/**
 * 
 */
package com.revolut.demo.controller;

import javax.servlet.ServletContext;

import io.undertow.Handlers;
import io.undertow.server.HandlerWrapper;
import io.undertow.server.HttpHandler;
import io.undertow.servlet.ServletExtension;
import io.undertow.servlet.api.DeploymentInfo;

/**
 * @author geovanefilho
 *
 */
public class NonBlockingHandlerExtension implements ServletExtension {

	public void handleDeployment(DeploymentInfo deploymentInfo, ServletContext arg1) {
		deploymentInfo.addInitialHandlerChainWrapper(new HandlerWrapper() {
			
            public HttpHandler wrap(final HttpHandler handler) {
                return Handlers.path()
                        .addPrefixPath("/", handler)
                        .addPrefixPath("/hello", new HelloWorldHandler());
            }
        });
	}
}
