package cn.system1.mapper;


import cn.system1.entity.PrescriptionAdvice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdviceMapper {
    public int addAdvice(@Param("prescriptionAdvice") PrescriptionAdvice prescriptionAdvice);//插入医嘱处方表数据
}
