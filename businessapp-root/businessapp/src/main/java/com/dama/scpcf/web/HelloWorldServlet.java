package com.dama.scpcf.web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.dama.scpcf.services.IDestinationService;
import com.dama.scpcf.services.IUserService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.logging.CloudLoggerFactory;
import com.sap.cloud.sdk.cloudplatform.security.user.User;

@Singleton
public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = CloudLoggerFactory.getLogger(HelloWorldServlet.class);

	@Inject
	IUserService userService;

	@Inject
	IDestinationService destinationService;

	@Inject
	public HelloWorldServlet() {

	}

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		logger.info("I am running!");
		String remoteUser = null;
		User currentUser = null;
		Destination destination = null;
		try {
			remoteUser = request.getRemoteUser();
			currentUser = userService.getCurrentUser();
			destination = destinationService.getDestination("scpDocument");
		} catch (Exception e) {
			logger.error("Error! while fetching loggedin user");
			e.printStackTrace();
		}
		response.setContentType("text/html");
		response.getWriter()
				.print("<p>Hello! This is my test application with XSUAA authentication</p>"
						+ "<p>Remote user from HttpServletRequest: " + remoteUser + "</p>"
						+ "<p>Current user from UserAccessor:" + currentUser + "</p>"
						+ "<p>Destination from DestinationAccessor:" + destination + "</p>");
	}

}
