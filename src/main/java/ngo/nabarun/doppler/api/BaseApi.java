package ngo.nabarun.doppler.api;

public class BaseApi {
    protected final DopplerClient client;
    protected final String project;

    BaseApi(String project, String token) {
        this.client = new DopplerClient(token);
        this.project = project;
    }
}
