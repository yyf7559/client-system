package cn.controller;

import cn.common.entity.PrescriptionAddPrice;
import cn.common.response.Response;
import cn.common.response.ResponseEnum;

import cn.entity.AddPrice;
import cn.entity.PrescriptionModel;
import cn.entity.PrescriptionType;
import cn.mapper.ModelMapper;
import cn.service.ModelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/come")
public class ModelController {
    @Resource
    ModelService modelService;
    @GetMapping("/getModel")
    public Response findModel(Integer typeId,String permissions,String number,Integer pageNum,Integer pageSize){
        List<PrescriptionModel> list = modelService.findModel(typeId,permissions,number,pageNum,pageSize);
        PageInfo<PrescriptionModel> pageInfo=null;
        if(pageNum!=null&&pageSize!=null){
            PageHelper.startPage(pageNum,pageSize);
            pageInfo = new PageInfo<>(list);
            return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
        }
        return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
    }
    @GetMapping("/findAddPrice")
    public Response findAddPrice(){
        List<AddPrice> list= modelService.findAddPrice();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询附加费用出错啦!");
    }
    @GetMapping("/findPrescriptionType")
    public Response findPrescriptionType(){
        List<PrescriptionType> list= modelService.findPrescriptionType();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("查询处方类型出错啦!");
    }
    @RequestMapping(value = "/findBy",method = {RequestMethod.GET,RequestMethod.POST})
    public String testpost(String name,Integer typeId){
        return name+"="+typeId;
    }
}

