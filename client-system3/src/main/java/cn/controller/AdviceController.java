package cn.controller;

import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.PrescriptionAdvice;
import cn.entity.Type;
import cn.service.AdviceService;
import org.bouncycastle.tsp.TSPUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/come/advice")
public class AdviceController {
    @Resource
    AdviceService adviceService;
    @GetMapping("/addAdvice")
    public Response addAdvice(PrescriptionAdvice prescriptionAdvice){
        System.out.println("1111="+prescriptionAdvice.getPrescriptionId());
        int n=adviceService.addAdvice(prescriptionAdvice);
        if(n>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("添加医嘱处方出错啦!");
    }
    @GetMapping("/type")
    public void addAdvice(Type type){
        System.out.println(type.getTypeName());
    }

}
