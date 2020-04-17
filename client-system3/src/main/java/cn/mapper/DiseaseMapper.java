package cn.mapper;

import cn.entity.PrescriptionDisease;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DiseaseMapper {
    public int addDisease(@Param("prescriptionDisease")PrescriptionDisease prescriptionDisease);//插入疾病处方表数据
}
