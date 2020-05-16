package cn.mapper;
import cn.entity.Medicine;
import cn.entity.MedicineType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
@CacheConfig(cacheNames = "c1")
public interface MedicineMapper {
    public List<MedicineType> findMedicineType(@Param("pid") Integer pid);
    @Cacheable(key = "targetClass+':'+methodName+':'+ # typeId +':'+ # code +':'+ # pageNo +':'+ # pageSize")
    public List<Medicine> findMedicine(@Param("typeId") Integer typeId, @Param("code") String code,Integer pageNo,Integer pageSize);
    public List<Medicine> findMedicineByPid(@Param("pids") Integer pids);
}
