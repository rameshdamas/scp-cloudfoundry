package com.dama.scpcf.services;

import com.google.inject.Inject;
import com.sap.cloud.sdk.cloudplatform.security.user.User;
import com.sap.cloud.sdk.cloudplatform.security.user.UserAccessor;

public class UserService implements IUserService {

	@Inject
	public UserService() {

	}

	@Override
	public String getCurrentUserName() {
		User user = UserAccessor.getCurrentUser();
		return user.getName();
	}

}
