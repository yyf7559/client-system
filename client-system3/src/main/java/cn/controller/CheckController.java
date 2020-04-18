package cn.controller;

import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.Check;
import cn.entity.CheckType;
import cn.entity.PrescriptionCheck;
import cn.service.CheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/come/check")
public class CheckController {
    @Resource
    CheckService checkService;
    @GetMapping("/findCheckByTypeId")
    public Response findCheckByTypeId(Integer checkTypeId,String checkCode){
        List<Check> list = checkService.findCheckByTypeId(checkTypeId,checkCode);
        System.out.println("prescriptionId="+checkTypeId);
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("根据分类查询检查项目出错啦");
    }
    @GetMapping("/findCheck")
    public Response findCheck(){
        List<Check> list = checkService.findCheck();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("根据检查项目出错啦");
    }
    @GetMapping("/findCheckType")
    public Response findCheckType(){
        List<CheckType> list = checkService.findCheckType();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("根据检查项目类型出错啦");
    }
    @GetMapping("/addPreCheck")
    public Response addPreCheck(PrescriptionCheck prescriptionCheck){
        int n = checkService.addPreCheck(prescriptionCheck);
        if(n>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("新增处方检查项目出错啦");
    }
}
