package com.dama.scpcf.services;

import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;

public class DestinationService implements IDestinationService {

	@Override
	public Destination getDestination(String destinationName) {
		return DestinationAccessor.getDestination(destinationName);
	}

}
