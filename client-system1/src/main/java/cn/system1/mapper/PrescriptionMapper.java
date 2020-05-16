package cn.system1.mapper;

import cn.system1.entity.Prescription;
import cn.system1.entity.PrescriptionDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface PrescriptionMapper {
    public int addPrescription(Prescription prescription);
    public int addPreDetail(@Param("prescriptionDetail") PrescriptionDetail prescriptionDetail);//添加处方详情
}
