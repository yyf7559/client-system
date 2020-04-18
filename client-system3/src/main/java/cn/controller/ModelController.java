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
    @GetMapping("/addPrice")
    public Response addPrice(PrescriptionAddPrice prescriptionAddPrice){
        int n = modelService.addPrice(prescriptionAddPrice);
        if(n>=0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(n);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("添加附加费用出错啦!");
    }
}

