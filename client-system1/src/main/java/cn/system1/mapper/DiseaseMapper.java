package cn.system1.mapper;

import cn.system1.entity.PrescriptionDisease;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiseaseMapper {
    public int addDisease(@Param("prescriptionDisease") PrescriptionDisease prescriptionDisease);//插入疾病处方表数据

}
