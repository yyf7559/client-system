package cn.system1.controller;

import cn.system1.entity.PrescriptionDetail;
import cn.system1.entity.Prescription;
import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.common.response.ResponseEnum;

import cn.system1.service.PrescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/call/prescription")
@Api(tags = "处方测试接口")
public class PrescriptionController {
    @Resource
    PrescriptionService prescriptionService;
    @Resource
    HttpClientHelper httpClientHelper;
    String prescriptionUrl="http://localhost:8083/come/prescription/";
    @GetMapping("/addPrescription")
    @ApiOperation(value = "新增处方表数据",notes = "")
    public Response addPrescription(Prescription prescription){
        prescriptionService.addPrescription(prescription);
        if(prescription.getId()>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(prescription.getId());
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("添加处方表数据出错啦");
    }
    @GetMapping("/addPreDetail")
    @ApiOperation(value = "新增处方详情",notes = "")
    public Response addPreDetail(PrescriptionDetail prescriptionDetail) {
        int n = prescriptionService.addPreDetail(prescriptionDetail);
        if(n>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("添加出错啦！");
    }
    @GetMapping("/findPrescriptionType")
    @ApiOperation(value = "查询处方类型",notes = "")
    public Object findPrescriptionType(){
        return httpClientHelper.getForResponse("http://localhost:8083/come/findPrescriptionType");
    }

    @GetMapping("/getAddPrice")
    @ApiOperation(value = "查询附加费用",notes = "")
    public Response getAddPrice(){
        return httpClientHelper.getForResponse("http://localhost:8083/come/findAddPrice");
    }
}
