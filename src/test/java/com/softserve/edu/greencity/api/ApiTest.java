package com.softserve.edu.greencity.api;

import static com.jayway.restassured.RestAssured.given;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import com.jayway.restassured.builder.MultiPartSpecBuilder;
import com.jayway.restassured.response.Response;

//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;


public class ApiTest {

    //
    //@Test
    public void signIn() {
        Response response = given()
                .header("Accept", "application/json, text/plain, */*")
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
    //
    
    /*-
    @Test
    public void addNews() {
        Response response = given()
                .header("Accept", "application/json, text/plain, *_/*")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGtueHVzcXZqZW92b3dwZmtAYXdkcnQuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYwMDMyODYzNCwiZXhwIjoxNjAwMzM1ODM0fQ.5bIGMUOSQn7zp69DevHdnObXPe0dhGNbR1jduXtW_xs")
                .header("Content-Type", "multipart/form-data")
                //.multiPart()
                .formParam("addEcoNewsDtoRequest", "{\"tags\":[\"news\"],\"text\":\"It's API444 so healthy, fun and cool to bring eco habits in everyday life \\n\",\"title\":\"Be eco! Be cool!\\n\",\"source\":\"https://ita-social-projects.github.io/GreenCityClient/#/news/3079\",\"image\":null}")
                .when()
                .post("https://greencity.azurewebsites.net/econews/");
//        response.then()
//                .statusCode(201);
    }
    */

    /*-
    //@Test
    public void addPost() throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        //MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary6Jrhdd8B5GFgpnmW");
        RequestBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("addEcoNewsDtoRequest", "{\"tags\":[\"news\"],\"text\":\"It's API333 so healthy, fun and cool to bring eco habits in everyday life \\n\",\"title\":\"Be eco! Be cool!\\n\",\"source\":\"https://ita-social-projects.github.io/GreenCityClient/#/news/3079\",\"image\":null}")
                .build();
        Request request = new Request.Builder()
                .url("https://greencity.azurewebsites.net/econews")
                .method("POST", body)
                .addHeader("Accept", "application/json, text/plain, * / *")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGtueHVzcXZqZW92b3dwZmtAYXdkcnQuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTYwMDMyODYzNCwiZXhwIjoxNjAwMzM1ODM0fQ.5bIGMUOSQn7zp69DevHdnObXPe0dhGNbR1jduXtW_xs")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36")
                .addHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary6Jrhdd8B5GFgpnmW")
                .build();
        Response response = client.newCall(request).execute();
        String textBody = response.body().string();
        //
        System.out.println("Http Code: " + response.code());
        System.out.println("textBody = " + textBody);
    }
    */
}
