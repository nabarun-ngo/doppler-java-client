import ngo.nabarun.doppler.api.ConfigsApi;
import ngo.nabarun.doppler.model.Secret;

public class Test {
    public static void main(String[] args) {
        ConfigsApi api = new ConfigsApi("nabarun_test", "my_token");
        try {
            for(Secret config : api.getSecrets("stage")) {
                System.out.println(config.getKey()+": "+config.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
