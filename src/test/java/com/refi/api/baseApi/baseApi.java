package com.refi.api.baseApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import io.github.cdimascio.dotenv.Dotenv;

public class baseApi {

// Disini masih Gagal
//    private static final Dotenv dotenv = Dotenv.load();
//    private String TOKEN = dotenv.get("TOKEN");
//
//    private String URL = "https://gorest.co.in/public/v2/users";

    private String TOKEN;
    private String URL;

    public baseApi() {

    Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    // ambil dari GitHub Actions env dulu
    TOKEN = System.getenv("TOKEN") != null
            ? System.getenv("TOKEN")
            : dotenv.get("TOKEN");

    URL = System.getenv("BASE_URL") != null
            ? System.getenv("BASE_URL")
            : "https://gorest.co.in/public/v2/users";
}

    public Response postCreateUser(String name, String email, String gender, String status) {
        JSONObject body = new JSONObject();
        body.put("name", name);
        body.put("email", email);
        body.put("gender", gender);
        body.put("status", status);

        return  RestAssured.given()
                .header("Authorization", "Bearer " + TOKEN)
                .header("Content-Type", "application/json")
                .body(body.toString())
                .post(URL);
    }

    public Response getUserById(int userId) {
        return RestAssured.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(URL + "/" + userId);
    }
}
