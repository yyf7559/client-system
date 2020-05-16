package cn.system1.controller;

import cn.common.entity.PrescriptionDetail;
import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
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
    String medicine = "http://localhost:8084/come/medicine/";
    @GetMapping("/findMedicineByPid")
    @ApiOperation(value = "根据处方ID查询药品",notes = "")
    public Object findMedicine(Integer pid){
        if(pid!=null){
            return httpClientHelper.getForResponse(medicine+"findMedicineByPid?pid="+pid);
        }
        return httpClientHelper.getForResponse(medicine+"findMedicineByPid");
    }

    @GetMapping("/findMedicine")
    @ApiOperation(value = "根据typeID和名称或者拼音查询药品信息",notes = "")
    public Object findMedicine(Integer typeId,String code,Integer page,Integer limit){
        if(page==null||"".equals(page))page=1;
        if(limit==null||"".equals(limit))limit=3;
        if("".equals(code)){
            code=null;
        }
        if(typeId!=null&&typeId!=0){
            return httpClientHelper.getForResponse(medicine+"findMedicine?typeId="+typeId+"&code="+code+"&page="+page+"&limit="+limit).getResponseBody();
        }
        return httpClientHelper.getForResponse(medicine+"findMedicine?code="+code+"&page="+page+"&limit="+limit).getResponseBody();
    }
    @GetMapping("/findMedicineType")
    @ApiOperation(value = "查询药品分类",notes = "")
    public Object findMedicineType(Integer pid){
        if(pid!=null){
            return httpClientHelper.getForResponse(medicine+"findMedicineType?pid="+pid);
        }
        return httpClientHelper.getForResponse(medicine+"findMedicineType?");
    }
    @GetMapping("/report")
    public void report(HttpServletResponse response) {
        CreateExcel report = new CreateExcel();
        List<String> headList = Arrays.asList("序号","单号","药品名称","数量","采购成本");
        List<List<String>> dataList = new ArrayList<>();
        Response response1=httpClientHelper.getForResponse(medicine+"findMedicineByPid");
        for (int i = 0; i < 10; i++) {
            dataList.add(Arrays.asList("" + i,"1000" + i,"药品" + i,"" +i, "2.55"));
        }
        report.createWorkBook(null, "a", headList, dataList, response, "报表测试.xls");
    }
}
