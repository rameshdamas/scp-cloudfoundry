package com.dama.scpcf.services;

import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;

public interface IDestinationService {
	
	public Destination getDestination(String destinationName);

}
