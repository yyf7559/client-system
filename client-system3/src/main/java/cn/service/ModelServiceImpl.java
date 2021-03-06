package cn.service;


import cn.common.entity.PrescriptionAddPrice;
import cn.entity.AddPrice;
import cn.entity.PrescriptionModel;
import cn.entity.PrescriptionType;
import cn.mapper.ModelMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = "ModelServiceImpl")
public class ModelServiceImpl implements ModelService {
    @Resource
    ModelMapper modelMapper;

    @Override
    @Cacheable(key = "targetClass+':'+methodName+':'+ # typeId +':'+ # permissions +':'+ # number +':'+ # pageNum +':'+ # pageSize")
    public List<PrescriptionModel> findModel(Integer typeId, String permissions, String number, Integer pageNum, Integer pageSize) {
        System.out.println(permissions);
        System.out.println(permissions==null);
        return modelMapper.findModel(typeId,permissions,number,pageNum,pageSize);
    }

    @Override
    public List<AddPrice> findAddPrice() {
        return modelMapper.findAddPrice();
    }

    @Override
    public List<PrescriptionType> findPrescriptionType() {
        return modelMapper.findPrescriptionType();
    }
}
