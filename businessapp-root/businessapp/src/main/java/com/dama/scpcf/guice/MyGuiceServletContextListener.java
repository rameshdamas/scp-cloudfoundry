package com.dama.scpcf.guice;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sap.cloud.sdk.cloudplatform.logging.CloudLoggerFactory;

public class MyGuiceServletContextListener extends GuiceServletContextListener {

	private static final Logger logger = CloudLoggerFactory.getLogger(MyGuiceServletContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("ServletContext Destroyed.");
		super.contextDestroyed(sce);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("ServletContext Initialized.");
		super.contextInitialized(sce);
	}

	@Override
	protected Injector getInjector() {
		return GuiceFactory.getInjector();
	}

}
