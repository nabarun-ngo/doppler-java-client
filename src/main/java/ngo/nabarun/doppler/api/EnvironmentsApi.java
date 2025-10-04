package ngo.nabarun.doppler.api;

import ngo.nabarun.doppler.model.Environment;

public class EnvironmentsApi extends BaseApi{
    public EnvironmentsApi(String project,String token) {
        super(project, token);
    }

    public Environment getEnvironment(String environment) throws Exception {
        String path = "/v3/environments/environment?project=" + project + "&environment=" + environment;
        return client.get(path, Environment.class);
    }

    public Environment[] listEnvironments() throws Exception {
        String path = "/v3/environments?project=" + project;
        return client.get(path, Environment[].class);
    }
}
