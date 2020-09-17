package com.softserve.edu.greencity.api;
import com.jayway.restassured.response.Response;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.body.MultipartBody;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.sun.deploy.util.URLUtil;
import org.apache.http.HttpResponse;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static org.hamcrest.CoreMatchers.equalTo;


public class ApiTest {

    ;

    @Test
    public void signIn() {
        Response response = given().header("Accept", "application/json, text/plain, */*")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36")
                .header("Content-Type", "application/json")
                .body("{\"email\":\"greencitypavel+32343567786@gmail.com\",\"password\":\"Temp#001\"}")
                .when()
                .post("https://greencity.azurewebsites.net/ownSecurity/signIn/");
        response.then()
                .statusCode(200)
                .assertThat()
                .body("userId",equalTo(6066));
        LOGGER.info(response.getBody().asString().replaceAll(",",",\n") );
    }

    @Test
    public void addPost() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary6Jrhdd8B5GFgpnmW");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("addEcoNewsDtoRequest", "{\"tags\":[\"news\"],\"text\":\"It's API so healthy, fun and cool to bring eco habits in everyday life \\n\",\"title\":\"Be eco! Be cool!\\n\",\"source\":\"https://ita-social-projects.github.io/GreenCityClient/#/news/3079\",\"image\":null}")
                .build();
        Request request = new Request.Builder()
                .url("https://greencity.azurewebsites.net/econews")
                .method("POST", body)
                .addHeader("Accept", "application/json, text/plain, */*")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJncmVlbmNpdHlwYXZlbCszMjM0MzU2Nzc4NkBnbWFpbC5jb20iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjAwMzA5MjE2LCJleHAiOjE2MDAzMTY0MTZ9.Yz4Ejs3b_VBh7n5Mb7NCXhQtejjipBgh94xjoVUGL8s")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36")
                .addHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary6Jrhdd8B5GFgpnmW")
                .build();
        Response response = client.newCall(request).execute();

    }
}
