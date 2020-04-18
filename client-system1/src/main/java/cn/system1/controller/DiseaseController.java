package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.PrescriptionAdvice;
import cn.entity.PrescriptionDisease;
import cn.service.AdviceService;
import cn.service.DiseaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/call/disease")
@Api(tags = "疾病测试接口")
public class DiseaseController {
    @Resource
    HttpClientHelper httpClientHelper;
    String diseaseUrl="http://localhost:8083/come/disease/";
    @GetMapping("/addDisease")
    @ApiOperation(value = "新增疾病处方表",notes = "")
    public Response addDisease(PrescriptionDisease prescriptionDisease){
        return httpClientHelper.get(diseaseUrl+"addDisease?diseaseId="+prescriptionDisease.getDiseaseId()+
                "&id="+prescriptionDisease.getId()+"&prescriptionId="+prescriptionDisease.getPrescriptionId());
    }
    @GetMapping("/getDisease")
    @ApiOperation(value = "查询所有疾病",notes = "")
    public Response findDisease(){
        return httpClientHelper.get(diseaseUrl+"getDisease");
    }
}
