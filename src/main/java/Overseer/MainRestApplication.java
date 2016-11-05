package Overseer;

import org.glassfish.jersey.server.ResourceConfig;

import Overseer.Task.TaskResource;

public class MainRestApplication extends ResourceConfig {

	public MainRestApplication() {
		register(TaskResource.class);
	}

}
