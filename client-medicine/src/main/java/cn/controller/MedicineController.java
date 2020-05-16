package cn.controller;

import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.Medicine;
import cn.entity.MedicineType;
import cn.common.entity.PrescriptionDetail;
import cn.entity.PrescriptionType;
import cn.service.MedicineService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    public Response findMedicine(Integer typeId,String code){
        List<Medicine> list = medicineService.findMedicine(typeId,code);
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询数据出错啦！");
    }
    @GetMapping("/findMedicineByPid")
    public Response findMedicineByPid(Integer pid){
        List<Medicine> list = medicineService.findMedicineByPid(pid);
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询数据出错啦！");
    }
    @GetMapping("/findPrescriptionType")
    public Response findPrescriptionType(){
        List<PrescriptionType> list = medicineService.findPrescriptionType();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询数据出错啦！");
    }
    @GetMapping("/addPreDetail")
    public Response addPreDetail(PrescriptionDetail prescriptionDetail){
        int n = medicineService.addPreDetail(prescriptionDetail);
        if(n>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("添加出错啦！");
    }
}
