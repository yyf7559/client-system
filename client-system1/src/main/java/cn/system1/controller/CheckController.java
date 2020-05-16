package cn.system1.controller;

import cn.system1.entity.PrescriptionCheck;
import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.system1.service.CheckService;
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
    CheckService checkService;
    @Resource
    HttpClientHelper httpClientHelper;
    String checkUrl="http://localhost:8084/come/check/";
    @GetMapping("/findCheck")
    @ApiOperation(value = "查询所有检查项目",notes = "")
    public Response findCheck(){
        return httpClientHelper.getForResponse(checkUrl+"findCheck");
    }
    @GetMapping("/findCheckType")
    @ApiOperation(value = "查询检查项目的类型",notes = "")
    public Response findCheckType(){
        return httpClientHelper.getForResponse(checkUrl+"findCheckType");
    }
    @GetMapping("/findCheckByTypeId")
    @ApiOperation(value = "根据typeID和名称或者拼音查询检查项目",notes = "")
    public Object findCheckByTypeId(Integer checkTypeId,String checkCode,Integer page,Integer limit){
        if(page==null||"".equals(page))page=1;
        if(limit==null||"".equals(limit))limit=3;
        if("".equals(checkCode))checkCode=null;
        if(checkTypeId!=null&&checkTypeId!=0){
            return httpClientHelper.getForResponse(checkUrl+"findCheckByTypeId?checkTypeId="+checkTypeId+"&checkCode="+checkCode+"&page="+page+"&limit="+limit).getResponseBody();
        }
        return httpClientHelper.getForResponse(checkUrl+"findCheckByTypeId?checkCode="+checkCode+"&page="+page+"&limit="+limit).getResponseBody();
    }
    @GetMapping("/addPreCheck")
    @ApiOperation(value = "新增处方检查项目",notes = "")
    public Response addPreCheck(PrescriptionCheck prescriptionCheck) {
        int n = checkService.addPreCheck(prescriptionCheck);
        if(n>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("新增处方检查项目出错啦");
    }
}
