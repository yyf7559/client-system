package cn.service;
import cn.entity.Medicine;
import cn.entity.MedicineType;
import cn.mapper.MedicineMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = "MedicineServiceImpl")
public class MedicineServiceImpl implements MedicineService{
    @Resource
    MedicineMapper medicineMapper;
    @Override
    public List<MedicineType> findMedicineType(Integer pid) {
        return medicineMapper.findMedicineType(pid);
    }

    @Override
    @Cacheable(key = "targetClass+':'+methodName+':'+ # typeId +':'+ # code +':' +':'+ # pageNo +':'+ # pageSize")
    public List<Medicine> findMedicine(Integer typeId, String code,Integer pageNo,Integer pageSize) {
        return medicineMapper.findMedicine(typeId,code,pageNo,pageSize);
    }

    @Override
    public List<Medicine> findMedicineByPid(Integer pid) {
        return medicineMapper.findMedicineByPid(pid);
    }

}
