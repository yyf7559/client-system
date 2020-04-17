package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.PrescriptionAddPrice;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "模板信息查询")
@RestController
@RequestMapping("/call/model")
public class SystemController {

    @Autowired
    HttpClientHelper httpClientHelper;
    String modelUrl="http://localhost:8083/come/";
    @GetMapping("/getModel")
    @ApiOperation(value = "查询模板+详情信息",notes = "信息")
    public Object findModel(Integer typeId,String permissions,String number){
        return httpClientHelper.get(modelUrl+"getModel?&typeId="+typeId+"&permissions="+permissions+"&number="+number+"&pageNum=1");
    }
    @GetMapping("/getDisease")
    @ApiOperation(value = "查询所有疾病",notes = "")
    public Response findDisease(){
        return httpClientHelper.get(modelUrl+"getDisease");
    }
    @GetMapping("/getAdvice")
    @ApiOperation(value = "查询所有医嘱",notes = "")
    public Response getAdvice(){
        return httpClientHelper.get(modelUrl+"getAdvice");
    }
    @GetMapping("/getAddPrice")
    @ApiOperation(value = "查询附加费用",notes = "")
    public Response getAddPrice(){
        return httpClientHelper.get(modelUrl+"getAddPrice");
    }
    @GetMapping("/addPrice")
    @ApiOperation(value = "新增附加费用",notes = "")
    public Response addPrice(PrescriptionAddPrice prescriptionAddPrice){
     return httpClientHelper
             .get(modelUrl+"/addPrice?id="+
                     prescriptionAddPrice.getId()+
                     "&prescriptionId="+prescriptionAddPrice.getPrescriptionId()+
                     "&addPriceId="+prescriptionAddPrice.getAddPriceId()+
                     "&number="+prescriptionAddPrice.getNumber()+
                     "&price="+prescriptionAddPrice.getPrice());
    }
}
