package cn.controller;

import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.AddPrice;
import cn.entity.Prescription;
import cn.service.PrescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/come/prescription")
public class PrescriptionController {
    @Resource
    PrescriptionService prescriptionService;
    @GetMapping("/addPrescription")
    public Response addPrescription(Prescription prescription){
        int n=prescriptionService.addPrescription(prescription);
        if(n>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("添加处方表数据出错啦");
    }
    @GetMapping("/getAddPrice")
    public Response getAddPrice(){
        List<AddPrice> list = prescriptionService.findAddPrice();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询附加费用出错啦!");
    }
}
