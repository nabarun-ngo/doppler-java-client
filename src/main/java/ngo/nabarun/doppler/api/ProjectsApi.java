package ngo.nabarun.doppler.api;

import ngo.nabarun.doppler.model.Project;

public class ProjectsApi extends BaseApi{
    public ProjectsApi(String token) {
        super(null, token);
    }

    public Project getProject(String project) throws Exception {
        String path = "/v3/projects/project?project=" + project;
        return client.get(path, Project.class);
    }

    public Project[] listProjects() throws Exception {
        String path = "/v3/projects?page=1&per_page=50";
        return client.get(path, Project[].class);
    }
}
