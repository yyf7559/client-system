package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.PrescriptionAdvice;
import cn.service.AdviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "医嘱测试接口")
@RequestMapping("/call/advice")
public class AdviceController {
    @Resource
    HttpClientHelper httpClientHelper;
    String adviceUrl="http://localhost:8083/come/advice/";
    @GetMapping("/addAdvice")
    @ApiOperation(value = "新增医嘱处方表")
    public Response addAdvice(PrescriptionAdvice prescriptionAdvice){
     return httpClientHelper.get(adviceUrl+"/addAdvice?adviceId="+prescriptionAdvice.getAdviceId()+
             "&id="+prescriptionAdvice.getId()+"&prescriptionId="+prescriptionAdvice.getPrescriptionId());
    }

}
