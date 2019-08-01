package com.caozy.czyapp;

import com.caozy.net.BaseBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 我们将在此类中定义相关网络请求的接口
 */
public interface Api {

    /** 添加评论 */
    String PORT_ADD_COMMENT = "discoverbazaar/addComment";

    @POST(PORT_ADD_COMMENT)
    @FormUrlEncoded
    Observable<BaseBean<User>> comment(@Field("code") String code, @Field("text") String text, @Field("commentType") String commentType,
                                 @Field("userCode") String userCod, @Field("timestamp") String timestamp, @Field("sign") String sign);

}
