package com.dama.scpcf.services;

import java.util.Map;

import com.google.inject.Inject;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;

public class DestinationService implements IDestinationService {

	@Inject
	public DestinationService() {

	}

	@Override
	public Map<String, Destination> getAllDestinations() {
		return DestinationAccessor.getDestinationsByName();
	}

}
