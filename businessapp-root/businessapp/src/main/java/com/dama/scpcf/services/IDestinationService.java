package com.dama.scpcf.services;

import java.util.Map;

import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;

public interface IDestinationService {
	
	Map<String, Destination> getAllDestinations();

}
