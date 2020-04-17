package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.entity.PrescriptionCheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "检查项目测试接口")
@RequestMapping("/call/check")
public class CheckController {
    @Resource
    HttpClientHelper httpClientHelper;
    String checkUrl="http://localhost:8083/come/check/";
    @GetMapping("/findCheck")
    @ApiOperation(value = "查询所有检查项目",notes = "")
    public Response findCheck(){
        return httpClientHelper.get(checkUrl+"findCheck");
    }
    @GetMapping("/findCheckType")
    @ApiOperation(value = "查询检查项目的类型",notes = "")
    public Response findCheckType(){
        return httpClientHelper.get(checkUrl+"findCheckType");
    }
    @GetMapping("/findCheckByTypeId")
    @ApiOperation(value = "根据typeID和名称或者拼音查询检查项目",notes = "")
    public Response findCheckByTypeId(Integer checkTypeId,String checkCode){
        return httpClientHelper.get(checkUrl+"findCheckByTypeId?checkTypeId="+checkTypeId+"&checkCode="+checkCode);
    }
    @GetMapping("/addPreCheck")
    @ApiOperation(value = "新增处方检查项目",notes = "")
    public Response addPreCheck(PrescriptionCheck prescriptionCheck) {
        return httpClientHelper.get(checkUrl+"addPreCheck?id="+prescriptionCheck.getId()+
                "&prescriptionId="+prescriptionCheck.getPrescriptionId()+
                "&checkId="+prescriptionCheck.getCheckId()+
                "&number="+prescriptionCheck.getNumber()+
                "&count="+prescriptionCheck.getCount()+
                "&pmark="+prescriptionCheck.getPmark());

    }
}
