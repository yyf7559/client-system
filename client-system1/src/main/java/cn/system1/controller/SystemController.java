package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SystemController {
    @Autowired
    HttpClientHelper httpClientHelper;
/*    private String serverUrl="http://localhost:8080";
    private String callback="http://localhost:8082/login";
    private String clientId="client";
    private String client_secret="secret";
    @GetMapping("/tologin")
    public String tologin(){
        return "login";
    }
    @GetMapping("/oauth2/code")
    public void code(HttpServletResponse response){
        String params = "/oauth/authorize?response_type=code"
                +"&client_id="+clientId
                +"&redirect_uri="+callback
                +"&scope=app";
        try {
            response.sendRedirect(serverUrl+params);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("请求code发送成功");
    }
    @GetMapping("/login")
    public String callBack(String code,HttpServletResponse resp,Model model){
        CloseableHttpClient httpClient=null;
        CloseableHttpResponse response=null;
        try {
            httpClient=HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(serverUrl+"/oauth/token");
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("grant_type","authorization_code"));
            list.add(new BasicNameValuePair("code",code));
            list.add(new BasicNameValuePair("scope","app"));
            list.add(new BasicNameValuePair("client_id",clientId));
            list.add(new BasicNameValuePair("redirect_uri",callback));
            list.add(new BasicNameValuePair("client_secret",client_secret));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
            httpPost.setEntity(entity);
            httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64)" +
                    " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36");
            System.out.println("请求参数:"+list);
            response=httpClient.execute(httpPost);
            System.out.println("url:11111");
            HttpEntity entity1 = response.getEntity();
            System.out.println("响应状态:"+response.getStatusLine());
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("响应结果:"+result);
            //根据http状态码判断是否成功
            if(response.getStatusLine().getStatusCode()==200){
                Map<String,String> tokenObject = new HashMap<>();
                ObjectMapper om = new ObjectMapper();
                tokenObject = om.readValue(result,Map.class);
                System.out.println(tokenObject.toString());
                String access_token=tokenObject.get("access_token");
                model.addAttribute("token",tokenObject);
                return "redirect:/call_api?access_token="+access_token;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return "error";
    }
    @GetMapping("/call_api")
    public String getInfo(String access_token,HttpServletResponse resp,Model model){

        CloseableHttpClient httpClient=null;
        CloseableHttpResponse response=null;
        try {
            httpClient=HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet("http://localhost:8081/getInfo?id=1&access_token="+access_token);

           *//* httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64)" +
                    " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36");*//*
            response=httpClient.execute(httpGet);
            HttpEntity entity1 = response.getEntity();
            System.out.println("响应状态:"+response.getStatusLine());
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("响应结果:"+result);
            //根据http状态码判断是否成功
            if(response.getStatusLine().getStatusCode()==200){
               List<Map<String,String>>  tokenObject = new ArrayList<>();
                ObjectMapper om = new ObjectMapper();
                tokenObject = om.readValue(result,List.class);
                System.out.println(tokenObject.toString());
                model.addAttribute("data",tokenObject);
                return "index";
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return "error";
    }*/
    @GetMapping("/call/get")
    public Object get(HttpServletRequest request){
        return httpClientHelper.get("http://localhost:8083/come/index");
    }
    @GetMapping("/call/getusers")
    public Object getusers(HttpServletRequest request){
        return httpClientHelper.get("http://localhost:8083//come/clinet3/users");
    }

    @RequestMapping("/call/clinet2/users")
    public Authentication getUser(Authentication user){
        return user;
    }
}
