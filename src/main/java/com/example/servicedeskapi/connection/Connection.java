package com.example.servicedeskapi.connection;

import org.springframework.http.HttpMethod;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

public class Connection {
    private static final String BASE_URL = System.getenv("PP_SERVICE_DESK_BASE_URL");
    private static final String TECHNICIAN_KEY = System.getenv("PP_SERVICE_DESK_TECHNICIAN_KEY");
    private static final String INTEGRATION_KEY = System.getenv("PP_SERVICE_DESK_INTEGRATION_KEY");

    public static HttpsURLConnection getConnection(String endpointPath, HttpMethod method, KeyType keyType) throws IOException {
        URL url = new URL(BASE_URL + endpointPath);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(String.valueOf(method));

        if (keyType == KeyType.INTEGRATION_KEY) {
            connection.setRequestProperty("INTEGRATION_KEY", INTEGRATION_KEY);
        } else if (keyType == KeyType.TECHNICIAN_KEY) {
            connection.setRequestProperty("TECHNICIAN_KEY", TECHNICIAN_KEY);
        } else if (keyType == KeyType.AUTH_TOKEN) {
            connection.setRequestProperty("Authtoken", INTEGRATION_KEY);
        }

        return connection;
    }
}
