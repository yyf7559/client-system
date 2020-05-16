package cn.system1.controller;

import cn.system1.entity.PrescriptionAdvice;
import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.common.response.ResponseEnum;

import cn.system1.service.AdviceService;
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
    AdviceService adviceService;
    @Resource
    HttpClientHelper httpClientHelper;
    String adviceUrl="http://localhost:8083/come/advice/";
    @GetMapping("/addAdvice")
    @ApiOperation(value = "新增医嘱处方表")
    public Response addAdvice(PrescriptionAdvice prescriptionAdvice){
   /*  return httpClientHelper.getForResponse(adviceUrl+"addAdvice?adviceId="+prescriptionAdvice.getAdviceId()+
             "&prescriptionId="+prescriptionAdvice.getPrescriptionId());*/
            int n=adviceService.addAdvice(prescriptionAdvice);
            if(n>0){
                return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
            }
            return new Response(ResponseEnum.ERROR).setResponseBody("添加医嘱处方出错啦!");
    }
    @GetMapping("/getAdvice")
    @ApiOperation(value = "查询所有医嘱",notes = "")
    public Response getAdvice(){
        return httpClientHelper.getForResponse(adviceUrl+"getAdvice");
    }
}
