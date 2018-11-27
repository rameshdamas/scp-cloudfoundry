package com.dama.scpcf.guice;

import com.dama.scpcf.web.HelloWorldServlet;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.ServletModule;

public class GuiceFactory {

	private static final Injector injector = Guice.createInjector(new GuiceModule(), new ServletModule() {
		@Override
		protected void configureServlets() {
			this.serve("/hello").with(HelloWorldServlet.class);
		}
	});

	public static Injector getInjector() {
		return injector;
	}

}
