package cn.controller;

import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.*;
import cn.mapper.ModelMapper;
import cn.service.ModelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/come")
public class ModelController {
    @Resource
    ModelService modelService;
    @GetMapping("/getModel")
    public Response findModel(Integer typeId,String permissions,String number,Integer pageNum){
        List<PrescriptionModel> list = modelService.findModel(typeId,permissions,number);
        System.out.println(list.toString());
        PageHelper.startPage(pageNum,2);
        PageInfo<PrescriptionModel> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
    @GetMapping("/getDisease")
    public Response getDisease(){
        List<Disease> list = modelService.findDisease();
     if(list!=null){
         return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
     }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询疾病出错啦!");
    }
    @GetMapping("/getAdvice")
    public Response getAdvice(){
        List<Advice> list = modelService.findAdvice();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询医嘱出错啦!");
    }
    @GetMapping("/getAddPrice")
    public Response getAddPrice(){
        List<AddPrice> list = modelService.findAddPrice();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询附加费用出错啦!");
    }
    @GetMapping("/addPrice")
    public Response addPrice(PrescriptionAddPrice prescriptionAddPrice){
        int n = modelService.addPrice(prescriptionAddPrice);
        if(n>=0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("新增附加费用出错啦!");
    }
}

