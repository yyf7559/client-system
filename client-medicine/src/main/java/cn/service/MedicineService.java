package cn.service;

import cn.entity.Medicine;
import cn.entity.MedicineType;
import cn.common.entity.PrescriptionDetail;
import cn.entity.PrescriptionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicineService {

    public List<MedicineType> findMedicineType(Integer pid);
    public List<Medicine> findMedicine(Integer typeId,String code);
    public List<Medicine> findMedicineByPid(Integer pid);
    public List<PrescriptionType> findPrescriptionType();
    public int addPreDetail(PrescriptionDetail prescriptionDetail);//添加处方详情
}
