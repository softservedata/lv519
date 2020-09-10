package com.softserve.edu;

import java.lang.reflect.Type;
import java.util.List;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RestTest {

    @Test
    public void checkLoginGreenCity() throws Exception {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody;
        Request request;
        Response response;
        String textBody;
        //
        Gson gson = new Gson();
        LoginEntity loginEntity;
        List<UserGoalsEntity> userGoalsEntities;
        //
        //
        // login
        formBody = RequestBody.create(MediaType.parse("application/json"),
                "{\"email\":\"xdknxusqvjeovowpfk@awdrt.com\", \"password\":\"Temp#001\"}");
//      formBody = new FormBody.Builder()
//              .add("email", "xdknxusqvjeovowpfk@awdrt.com")
//              .add("password", "Temp#001")
//              .build();
        request = new Request.Builder()
                .url("https://greencity.azurewebsites.net/ownSecurity/signIn")
                .header("accept", "*/*")
                // .addHeader("Content-Type", "application/json")
                .post(formBody)
                .build();
        response = client.newCall(request).execute();
        textBody = response.body().string();
        //
        System.out.println("Http Code: " + response.code());
        System.out.println("JSON = " + textBody);
        // loginEntity = gson.fromJson(textBody, LoginEntity.class);
        loginEntity = gson.fromJson(textBody, LoginEntity.class);
                //new TypeToken<LoginEntity>(){}.getType());
        System.out.println(loginEntity);
        //
        //
        // Get goals of current user.
        request = new Request.Builder()
                .url("https://greencity.azurewebsites.net/user/" + loginEntity.getUserId() + "/goals?language=en")
                .header("accept", "*/ *")
                .header("Authorization", "Bearer " + loginEntity.getAccessToken())
                .get()
                .build();
        response = client.newCall(request).execute();
        textBody = response.body().string();
        //
        System.out.println("Http Code: " + response.code());
        System.out.println("JSON = " + textBody);
        //
        Type type = new TypeToken<List<UserGoalsEntity>>(){}.getType();
        //Type type = new GenericConverter<List<UserGoalsEntity>>(){}.getGenericType();
        String typeStr = type.toString();
        System.out.println("+++typeStr=" + typeStr);
        // Type type2 = Class.forName(typeStr, false,
        // ClassLoader.getSystemClassLoader()); // Error
        // String typeStr2 = type.toString();
        // System.out.println("+++typeStr2=" + typeStr2);
        // @SuppressWarnings("unchecked")
        // Class<List<UserGoalsEntity>> cls =
        // (Class<List<UserGoalsEntity>>)(Object)List.class;
        // Class<List<UserGoalsEntity>> cls = (Class<List<UserGoalsEntity>>) new
        // ArrayList<UserGoalsEntity>().getClass();
        // System.out.println("+++cls=" + ((Type) cls).toString());
        //
        // userGoalsEntities = gson.fromJson(textBody, new
        // TypeToken<List<UserGoalsEntity>>(){}.getType());
        userGoalsEntities = gson.fromJson(textBody, type);
        // userGoalsEntities = gson.fromJson(textBody, (Type) Class.forName(typeStr));
        System.out.println(userGoalsEntities);
        //
    }

}
