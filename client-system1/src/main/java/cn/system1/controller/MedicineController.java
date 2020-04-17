package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.entity.PrescriptionDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "药品信息查询")
@RestController
@RequestMapping("/call/medicine")
public class MedicineController {
    @Resource
    HttpClientHelper httpClientHelper;
    @GetMapping("/findMedicineByPid")
    @ApiOperation(value = "根据处方ID查询药品",notes = "")
    public Object findMedicine(Integer pid){
        return httpClientHelper.get("http://localhost:8083/come/medicine/findMedicineByPid?pid="+pid);
    }
    @GetMapping("/findPrescriptionType")
    @ApiOperation(value = "查询处方类型",notes = "")
    public Object findPrescriptionType(){
        return httpClientHelper.get("http://localhost:8083/come/medicine/findPrescriptionType");
    }
    @GetMapping("/findMedicine")
    @ApiOperation(value = "根据typeID和名称或者拼音查询药品信息",notes = "")
    public Object findMedicine(Integer typeId,String code){
        return httpClientHelper.get("http://localhost:8083/come/medicine/findMedicine?typeId="+typeId+"&code="+code);
    }
    @GetMapping("/findMedicineType")
    @ApiOperation(value = "查询药品分类",notes = "")
    public Object findMedicineType(Integer pid){
        return httpClientHelper.get("http://localhost:8083/come/medicine/findMedicineType?pid="+pid);
    }
    @GetMapping("/addPreDetail")
    @ApiOperation(value = "新增处方详情",notes = "")
    public Response addPreDetail(PrescriptionDetail prescriptionDetail) {
        return httpClientHelper.get("http://localhost:8083/come/medicine/addPreDetail?id="+prescriptionDetail.getId()
                +"&count="+prescriptionDetail.getCount()
                +"&days="+prescriptionDetail.getDays()
                +"&methodId="+prescriptionDetail.getMethodId()
                +"&frequency="+prescriptionDetail.getFrequency()
                +"&medicineId="+prescriptionDetail.getMedicineId()
                +"&prescriptId="+prescriptionDetail.getPrescriptId()
                +"&useSize="+prescriptionDetail.getUseSize()
        );
    }
}
