package ngo.nabarun.doppler.api;

import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class DopplerClient {
    private final String baseUrl;
    private final String token;
    private final OkHttpClient httpClient;
    private final ObjectMapper mapper;

    DopplerClient(String token) {
        this("https://api.doppler.com", token);
    }

    DopplerClient(String baseUrl, String token) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.httpClient = new OkHttpClient();
        this.mapper = new ObjectMapper();
    }

    <T> T get(String path, Class<T> clazz) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl + path)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Accept", "application/json")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("HTTP error: " + response.code() + " - " + response.message()+" - "+response.body().string());
            }
            assert response.body() != null;
            return mapper.readValue(response.body().string(), clazz);
        }
    }

    <T> T post(String path, Object body, Class<T> clazz) throws IOException {
        RequestBody requestBody = RequestBody.create(
                mapper.writeValueAsString(body), MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url(baseUrl + path)
                .addHeader("Authorization", "Bearer " + token)
                .post(requestBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("HTTP error: " + response.code() + " - " + response.message());
            }
            assert response.body() != null;
            return mapper.readValue(response.body().string(), clazz);
        }
    }
}
