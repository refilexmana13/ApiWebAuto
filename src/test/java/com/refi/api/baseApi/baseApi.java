package com.refi.api.baseApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class baseApi {
    private String TOKEN = "dd2c89e33e14d7327431e48bdca92dbe982bcbd9003593df47bf28246aab1d3f";
    private String URL = "https://gorest.co.in/public/v2/users";


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
