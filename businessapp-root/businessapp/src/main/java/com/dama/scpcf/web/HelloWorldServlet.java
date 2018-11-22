package com.dama.scpcf.web;

import java.io.IOException;
import java.util.Map;

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
		String currentUser = null;
		Map<String, Destination> map = null;
		try {
			remoteUser = request.getRemoteUser();
			currentUser = userService.getCurrentUserName();
			map = destinationService.getAllDestinations();
		} catch (Exception e) {
			logger.error("Error! while fetching loggedin user & destinations");
			e.printStackTrace();
		}
		response.setContentType("text/html");
		response.getWriter()
				.print("<p>Hello! This is my test application with authentication</p>"
						+ "<p>Remote user from HttpServletRequest: " + remoteUser + "</p>"
						+ "<p>Current user from UserAccessor:" + currentUser + "</p>"
						+ "<p> Destinations from DestinationAccessor: " + map + "</p>");
	}

}
