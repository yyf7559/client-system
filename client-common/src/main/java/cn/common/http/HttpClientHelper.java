package cn.common.http;

import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
public class HttpClientHelper {
    private HttpServletRequest request;
    public HttpClientHelper(HttpServletRequest request){
        this.request=request;
    }

    public Response get(String uri){
        CloseableHttpClient httpClient=null;
        CloseableHttpResponse response=null;
        try {
            httpClient= HttpClientBuilder.create().build();
            String ssoCookies=(String)request.getAttribute("ssoCookies");
            System.out.println("ssoCookies"+ssoCookies);
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader("Cookie",ssoCookies);
            response=httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println("响应状态:"+response.getStatusLine());
            Header contextType=(Header)response.headerIterator("Content-Type").next();
          /*  if(contextType.getValue().startsWith("text/html")){ //请求授权页面
                System.out.println("111");
                return new Response(ResponseEnum.ERROR).setResponseBody("调用目标的授权已经失效！,请先重新获取授权<a href='"+uri+"'>授权</a>");
            }*/
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("响应结果:"+result);
            //根据http状态码判断是否成功
            if(response.getStatusLine().getStatusCode()==200){
                ObjectMapper om = new ObjectMapper();

                return  om.readValue(result,Response.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("出错啦");
    }
}
