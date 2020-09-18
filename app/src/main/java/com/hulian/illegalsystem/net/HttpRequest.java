package com.hulian.illegalsystem.net;

import java.io.File;
import java.util.List;

/**
 * 作者：zb.
 * <p>
 * 时间：On 2019-05-05.
 * <p>
 * 描述：所有的请求接口
 */
public class HttpRequest {

 /**
     * 报销统计详情
     * @param params
     * @param callback
     */
    public static void getCar_illegal(RequestParams params, ResponseCallback callback) {
        RequestMode.postRequest(Urls.commUrls + "illegal/query", params, callback, null);
    }





}
