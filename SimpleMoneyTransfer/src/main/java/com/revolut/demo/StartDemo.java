/**
 * 
 */
package com.revolut.demo;

import javax.servlet.ServletException;

import com.revolut.demo.controller.AccountController;
import com.revolut.demo.controller.FindUserController;
import com.revolut.demo.controller.IndexController;
import com.revolut.demo.controller.TransferController;
import com.revolut.demo.controller.UserController;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

/**
 * @author geovanefilho
 *
 */
public class StartDemo {

	/**
	 * @param args
	 * @throws ServletException 
	 */
	public static void main(String[] args) throws ServletException {
        DeploymentInfo servletBuilder = Servlets.deployment()
                .setClassLoader(IndexController.class.getClassLoader())
                .setContextPath("/SimpleMoneyTransfer")
                .setDeploymentName("test.war")
                .addServlets(
                        Servlets.servlet("UserServlet", UserController.class)
                                .addMapping("/User"),
                        Servlets.servlet("IndexServlet", IndexController.class)
                                .addMapping("/Index"),
                        Servlets.servlet("FindUserServlet", FindUserController.class)
                                .addMapping("/FindUser"),
                        Servlets.servlet("TransferServlet", TransferController.class)
                                .addMapping("/Transfer"),
                        Servlets.servlet("AccountServlet", AccountController.class)
                                .addMapping("/Account")
                        );

        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();
        PathHandler path = Handlers.path(Handlers.redirect("/SimpleMoneyTransfer/Index"))
                .addPrefixPath("/SimpleMoneyTransfer", manager.start());

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(path)
                .build();
        server.start();
	}

}
