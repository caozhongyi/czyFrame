package com.caozy.net;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        if ("GET".equalsIgnoreCase(request.method())) {
            request = dealGet(request);
        }

        if ("POST".equalsIgnoreCase(request.method())) {
            request = dealPost(request);
        }

        //重新发送请求
        return chain.proceed(request);
    }

    /**
     * 改写此方法处理GET请求的参数等
     *
     * @param oldRequest
     * @return
     */
    private Request dealGet(Request oldRequest) {
        String oldUrl = oldRequest.url().toString();
        //重新构建请求体
        Request request = new Request.Builder()
                .url(oldUrl)
                .build();
        return request;
    }

    /**
     * 改写此方法处理post请求的参数等
     * @param oldRequest
     * @return
     */
    private Request dealPost(Request oldRequest) {
        FormBody formBody = (FormBody) oldRequest.body();

        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < formBody.size(); i++) {
            try {
                jsonObject.put(formBody.name(i), formBody.value(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        RequestBody requestBody = RequestBody.create(JSON, jsonObject.toString());

        HttpUrl.Builder builder = oldRequest.url()
                .newBuilder();

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), requestBody)
                .url(builder.build())
                .build();

        return newRequest;
    }
}
