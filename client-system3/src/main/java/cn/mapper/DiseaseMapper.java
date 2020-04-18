package cn.mapper;

import cn.entity.Disease;
import cn.entity.PrescriptionDisease;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiseaseMapper {
    public int addDisease(@Param("prescriptionDisease")PrescriptionDisease prescriptionDisease);//插入疾病处方表数据
    public List<Disease> findDisease();
}
