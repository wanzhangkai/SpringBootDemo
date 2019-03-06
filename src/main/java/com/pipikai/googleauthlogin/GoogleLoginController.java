package com.pipikai.googleauthlogin;

import com.alibaba.fastjson.JSONObject;
import com.pipikai.utils.HttpUtils;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Google授权登录demo
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2019/3/5 14:50
 */
@Controller
public class GoogleLoginController {

    private static String client_id = "780991077615-r2gtat158ovdvmv5sb7l11l3ed26o8r0.apps.googleusercontent.com";
    private static String client_secret = "UYg-rcEIJmJyyPCjL7FAtqAR";
    private static String scope = "https://www.googleapis.com/auth/drive.metadata.readonly";
    private static String redirect_url = "http://wanzhangkai.imwork.net/GoogleUserInfo";
    private static String code_url = "https://accounts.google.com/o/oauth2/v2/auth";
    private static String token_url = "https://www.googleapis.com/oauth2/v4/token";
    private static String user_url = "https://www.googleapis.com/oauth2/v2/userinfo";
    private static String verify_url = "https://www.googleapis.com/oauth2/v3/tokeninfo";

    public static void main(String[] args) throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("str", "wanzhangkai");
        JSONObject responseResult = HttpUtils.doPost("http://wanzhangkai.imwork.net/hello", params);
        System.out.println("getGoogleAccessToken responseResult: " + responseResult);
    }

    //第一步：跳转到登录页面
    @RequestMapping(value = "/login")
    public String toIndex() {
        return "google";
    }

    @GetMapping(value = "/google5ca0720e9806c462.html")
    public String to2Index() {
        return "google5ca0720e9806c462";
    }

    /**
     * @return Object
     * @throws
     * @Title: Login
     * @Description: google登录验证后会重定向到此地址，并附带访问授权码，不能为公开的ip地址
     * @author 此方法是用带回的code换取accessToken，然后用accessToken换取用户信息，这个地址就是在创建应用时定义的重定向地址
     * @date Mar 23, 2017 10:37:38 AM
     */
    @RequestMapping(value = "/GoogleUserInfo")
    @ResponseBody
    public static Object Login(HttpServletRequest request) {
        String code = request.getParameter("code");
        System.out.println("GoogleUserInfo: " + code);

//		String idToken = getGoogleAccessToken(code);
//		System.out.println(idToken);
//		JSONObject verifyToken = verifyToken(idToken);
//		System.out.println(verifyToken);

        String accessToken = getGoogleAccessToken(code);
        System.out.println(accessToken);
        JSONObject userInfo = getUserInfo(accessToken);
        System.out.println(userInfo);
        return userInfo;
    }

    /**
     * @return String
     * @throws Exception
     * @throws
     * @throws
     * @Title: sendRedirect
     * @Description:发送授权请求
     * @author 第二步，在google.jsp中用户登录成功以后回跳转到这个路径，发送请求让用户授权，授权成功后重定向到/GoogleUserInfo，也就是创建应用时定义的重定向地址
     * @date Mar 24, 2017 3:11:36 PM
     */
    @GetMapping(value = "/sendRedirect")
    public void sendRedirect(HttpServletResponse response) throws Exception {
        System.out.println("sendRedirect-------------");
        // 随机字符串，防止csrf攻击
        String state = UUID.randomUUID() + "";
        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", client_id);
        params.put("redirect_uri", redirect_url);
        params.put("response_type", "code");
        params.put("scope", scope);
        params.put("access_type", "offline");
        params.put("state", state);
        params.put("include_granted_scopes", "true");
//        String url = HttpClientUtil.getUrl(code_url, params);
        StringBuilder sb = new StringBuilder();
        for (String s : params.keySet()) {
            sb.append(s).append("=").append(params.get(s)).append("&");
        }
        String sb2 = sb.toString();
        String url = code_url + "?" + sb2.substring(0, sb2.length() - 1);
        System.out.println(url);
        response.sendRedirect(url);
    }

    /**
     * @return String
     * @throws
     * @Title: getGoogleAccessToken
     * @Description: 获取accessToken
     * @author 第三步，用重定向带回来的code换取accessToken
     * @date Mar 25, 2017 10:25:00 AM
     */
    public static String getGoogleAccessToken(String code) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("client_id", client_id);
        params.put("redirect_uri", redirect_url);
        params.put("client_secret", client_secret);
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        JSONObject responseResult = null;
        String accessToken = null;
        String idToken = null;
        try {
//            responseResult = HttpClientUtil.getStringByPost(token_url, params, null);
            responseResult = HttpUtils.doPost(token_url, params);
            System.out.println("getGoogleAccessToken responseResult: " + responseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if (null != responseResult && responseResult[0].equals("200")) {
//            String result = responseResult[1];
//            JSONObject jsonObject = JSONObject.fromObject(result);
//            accessToken = jsonObject.getString("access_token");
//            idToken=jsonObject.getString("id_token");
//        }
        accessToken = responseResult.getString("access_token");
        return accessToken;
//		return idToken;
    }

    /**
     * @return String
     * @throws
     * @Title: getUserInfo
     * @Description: 获取用户信息
     * @author第四步，用accessToken获取用户信息
     * @date Mar 25, 2017 11:50:23 AM
     */
    public static JSONObject getUserInfo(String accessToken) {
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", accessToken);
        JSONObject responseResult = null;
        JSONObject userInfo = null;
        try {
//            responseResult = HttpClientUtil.getStringByGet(user_url, params);
            responseResult = HttpUtils.doPost(user_url, params);
            System.out.println("getUserInfo responseResult: " + responseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if (null != responseResult && responseResult[0].equals("200")) {
//            String result = responseResult[1];
//            userInfo =  JSONObject.fromObject(result);
//        }
        userInfo = responseResult;
        return userInfo;
    }

    /**
     * @return String
     * @throws
     * @Title: verifyToken
     * @Description:验证用户token是否是来自本应用的请求，校验aud和clientID是否相同
     * @author第五步，验证用户是否来自你的应用，防刷，根据需要加到逻辑里
     * @date Mar 25, 2017 7:36:33 PM
     */
    public static JSONObject verifyToken(String idToken) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id_token", idToken);
        JSONObject responseResult = null;
        JSONObject verifyInfo = null;
        try {
//            responseResult = HttpClientUtil.getStringByGet(verify_url, params);
            responseResult = HttpUtils.doPost(user_url, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if (null != responseResult && responseResult[0].equals("200")) {
//            String result = responseResult[1];
//            verifyInfo =  JSONObject.fromObject(result);
//        }
        verifyInfo = responseResult;
        return verifyInfo;
    }
}
