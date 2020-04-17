package cn.mapper;

import cn.entity.Prescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PrescriptionMapper {
    public int addPrescription(@Param("prescription") Prescription prescription);
}
