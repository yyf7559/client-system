package cn.controller;

import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.PrescriptionDisease;
import cn.service.DiseaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/come/disease")
public class DiseaseController {
    @Resource
    DiseaseService diseaseService;
    @GetMapping("/addDisease")
    public Response addDisease(PrescriptionDisease prescriptionDisease){
        System.out.println(prescriptionDisease.getPrescriptionId()+","+prescriptionDisease.getDiseaseId());
        int n=diseaseService.addDisease(prescriptionDisease);
        if(n>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("添加疾病处方出错啦!");
    }
}
