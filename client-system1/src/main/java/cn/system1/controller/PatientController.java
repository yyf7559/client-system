package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "患者测试接口")
@RequestMapping("/call/patient")
public class PatientController {
    @Resource
    HttpClientHelper httpClientHelper;
    String patientUrl="http://localhost:8083/come/patient/";
    @GetMapping("/findPatient")
    @ApiOperation(value = "查询所有患者",notes = "")
    public Response findCheckType(){
        return httpClientHelper.get(patientUrl+"findPatient");
    }
    @ApiOperation(value = "查询所有患者类型",notes = "")
    @GetMapping("/findType")
    public Response findType(){
        return httpClientHelper.get(patientUrl+"findType");
    }
}
