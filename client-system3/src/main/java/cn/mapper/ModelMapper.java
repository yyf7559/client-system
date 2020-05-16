package cn.mapper;


import cn.common.entity.PrescriptionAddPrice;
import cn.config.MyKeyGenerator;

import cn.entity.AddPrice;
import cn.entity.PrescriptionModel;
import cn.entity.PrescriptionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@CacheConfig(cacheNames = "c1")
public interface ModelMapper {
    @Cacheable(key = "targetClass+':'+methodName+':'+ # typeId +':'+ # permissions +':'+ # number +':'+ # pageNum +':'+ # pageSize")
    public List<PrescriptionModel> findModel(@Param("typeId")Integer typeId, @Param("permissions")String permissions, @Param("number")String number, Integer pageNum, Integer pageSize);
    public List<AddPrice> findAddPrice();
    public List<PrescriptionType> findPrescriptionType();
}
