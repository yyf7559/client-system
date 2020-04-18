package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.entity.PrescriptionDetail;
import cn.system1.excel.CreateExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Api(tags = "药品信息查询")
@RestController
@RequestMapping("/call/medicine")
public class MedicineController {
    @Resource
    HttpClientHelper httpClientHelper;
    String medicine = "http://localhost:8083/come/medicine/";
    @GetMapping("/findMedicineByPid")
    @ApiOperation(value = "根据处方ID查询药品",notes = "")
    public Object findMedicine(Integer pid){
        if(pid!=null){
            return httpClientHelper.get(medicine+"findMedicineByPid?pid="+pid);
        }
        return httpClientHelper.get(medicine+"findMedicineByPid");
    }
    @GetMapping("/findPrescriptionType")
    @ApiOperation(value = "查询处方类型",notes = "")
    public Object findPrescriptionType(){
        return httpClientHelper.get("http://localhost:8083/come/medicine/findPrescriptionType");
    }
    @GetMapping("/findMedicine")
    @ApiOperation(value = "根据typeID和名称或者拼音查询药品信息",notes = "")
    public Object findMedicine(Integer typeId,String code){
        if(typeId!=null){
            return httpClientHelper.get(medicine+"findMedicine?typeId="+typeId+"&code="+code);
        }
        return httpClientHelper.get(medicine+"findMedicine?code="+code);
    }
    @GetMapping("/findMedicineType")
    @ApiOperation(value = "查询药品分类",notes = "")
    public Object findMedicineType(Integer pid){
        if(pid!=null){
            return httpClientHelper.get(medicine+"findMedicineType?pid="+pid);
        }
        return httpClientHelper.get(medicine+"findMedicineType?");
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
    @GetMapping("/report")
    public void report(HttpServletResponse response) {
        CreateExcel report = new CreateExcel();
        List<String> headList = Arrays.asList("序号","单号","药品名称","数量","采购成本");
        List<List<String>> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add(Arrays.asList("" + i,"1000" + i,"药品" + i,"" +i, "2.55"));
        }
        report.createWorkBook(null, "a", headList, dataList, response, "报表测试.xls");
    }
}
