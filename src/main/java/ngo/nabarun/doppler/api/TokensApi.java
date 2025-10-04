package ngo.nabarun.doppler.api;

import ngo.nabarun.doppler.model.Token;

public class TokensApi extends BaseApi{
    public TokensApi(String project,String token) {
        super(project, token);
    }

    public Token[] listTokens(String config) throws Exception {
        String path = String.format("/v3/configs/config/tokens?project=%s&config=%s", project, config);
        return client.get(path, Token[].class);
    }
}
