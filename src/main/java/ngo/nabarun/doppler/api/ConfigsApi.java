package ngo.nabarun.doppler.api;


import com.fasterxml.jackson.databind.JsonNode;

import ngo.nabarun.doppler.model.Config;
import ngo.nabarun.doppler.model.Secret;

import java.util.*;

public class ConfigsApi extends BaseApi{

    public ConfigsApi(String project,String token) {
        super(project, token);
    }

    public Config[] listConfigs() throws Exception {
        String path = "/v3/configs?project=" + project;
        return client.get(path, Config[].class);
    }

    private JsonNode getSecretsRaw(String config) throws Exception {
        String path = String.format("/v3/configs/config/secrets?project=%s&config=%s", project, config);
        return client.get(path, JsonNode.class);
    }

    public List<Secret> getSecrets(String config) throws Exception {
        JsonNode root = getSecretsRaw(config);
        List<Secret> secrets = new ArrayList<>();
        if (root.has("secrets")) {
            JsonNode secretsNode = root.get("secrets");
            Iterator<String> fieldNames = secretsNode.fieldNames();
            while (fieldNames.hasNext()) {
                Secret secret = new Secret();
                String key = fieldNames.next();
                secret.setKey(key);
                JsonNode valueNode = secretsNode.get(key);
                String visibility = valueNode.get("computedVisibility").asText();
                secret.setSensitive(!visibility.equalsIgnoreCase("unmasked"));
                if (valueNode.has("computed")) {
                    secret.setValue(valueNode.get("computed").asText());
                } else if (valueNode.has("raw")) {
                    secret.setValue(valueNode.get("raw").asText());
                } else {
                    secret.setValue(valueNode.toString());
                }
                secrets.add(secret);
            }
        }
        return secrets;
    }
}
