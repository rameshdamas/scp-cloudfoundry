package com.dama.scpcf.guice;

import com.dama.scpcf.services.DestinationService;
import com.dama.scpcf.services.IDestinationService;
import com.dama.scpcf.services.IUserService;
import com.dama.scpcf.services.UserService;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IUserService.class).to(UserService.class);
		bind(IDestinationService.class).to(DestinationService.class);
	}

}
