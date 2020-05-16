package cn.controller;

import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.Medicine;
import cn.entity.MedicineType;
import cn.excel.CreateExcel;
import cn.service.MedicineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/come/medicine")
public class MedicineController {
    @Resource
    MedicineService medicineService;
    @GetMapping("/findMedicineType")
    public Response findMedicineType(Integer pid){
        List<MedicineType> list = medicineService.findMedicineType(pid);
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询数据出错啦！");
    }
    @GetMapping("/findMedicine")
    public Response findMedicine(Integer typeId,String code,Integer page,Integer limit){
        List<Medicine> list = medicineService.findMedicine(typeId,code,page,limit);
        Map<String,Object> map=new HashMap<>();
        PageInfo<Medicine> pageInfo=null;
        if(page!=null&&limit!=null){
            PageHelper.startPage(page,limit);
            pageInfo = new PageInfo<>(list);
            map.put("data",pageInfo.getList());
            map.put("code","0");
            map.put("count",pageInfo.getTotal());
            return new Response(ResponseEnum.SUCCESS).setResponseBody(map);
        }else{
            map.put("data",list);
            map.put("code","0");
            map.put("count",list.size());
            return new Response(ResponseEnum.SUCCESS).setResponseBody(map);
        }
    }
    @GetMapping("/findMedicineByPid")
    public Response findMedicineByPid(Integer pid,Integer pageNo,Integer pageSize){
        List<Medicine> list = medicineService.findMedicineByPid(pid);
        Map<String,Object> map=new HashMap<>();
        PageInfo<Medicine> pageInfo=null;
        if(pageNo!=null&&pageSize!=null){
            PageHelper.startPage(pageNo,pageSize);
            pageInfo = new PageInfo<>(list);
            map.put("data",map);
            map.put("code","0");
            map.put("count",pageInfo.getTotal());
            return new Response(ResponseEnum.SUCCESS).setResponseBody(map);
        }else {
            map.put("data",list);
            map.put("code","0");
            map.put("count",list.size());
            return new Response(ResponseEnum.SUCCESS).setResponseBody(map);
        }
    }
    @GetMapping("/report")
    public void report(HttpServletResponse response) {
        List<Medicine> list = medicineService.findMedicine(null,null,null,null);
        CreateExcel report = new CreateExcel();
        List<String> headList = Arrays.asList("序号","单号","药品名称","数量","采购成本");
        List<List<String>> dataList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            dataList.add(Arrays.asList("" + i,"1000" + i,list.get(i).getMedicineName(),"" +list.get(i).getStock(), list.get(i).getPrice()+""));
        }
        report.createWorkBook(null, "a", headList, dataList, response, "报表测试.xls");
    }

}
