package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.Prescription;
import cn.entity.PrescriptionAdvice;
import cn.service.AdviceService;
import cn.service.PrescriptionService;
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
    HttpClientHelper httpClientHelper;
    String prescriptionUrl="http://localhost:8083/come/prescription/";
    @GetMapping("/addPrescription")
    @ApiOperation(value = "新增处方表数据",notes = "")
    public Response addPrescription(Prescription prescription){
        return httpClientHelper.get(prescriptionUrl+
                "addPrescription?employeeId="+prescription.getEmployeeId()+
                "&id="+prescription.getId()+"&kindId="+prescription.getKindId()+"&patientId="+prescription.getPatientId()+"+&pname="+prescription.getPname());
    }
    @GetMapping("/getAddPrice")
    @ApiOperation(value = "查询附加费用",notes = "")
    public Response getAddPrice(){
        return httpClientHelper.get(prescriptionUrl+"getAddPrice");
    }
}
