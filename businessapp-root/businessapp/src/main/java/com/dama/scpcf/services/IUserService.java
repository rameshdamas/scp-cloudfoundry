package com.dama.scpcf.services;

import com.sap.cloud.sdk.cloudplatform.security.user.User;

public interface IUserService {

	public User getCurrentUser();

	String getCurrentUserName();

}
