package cn.mapper;


import cn.entity.Advice;
import cn.entity.PrescriptionAdvice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdviceMapper {
    public int addAdvice(@Param("prescriptionAdvice")PrescriptionAdvice prescriptionAdvice);//插入医嘱处方表数据
}
