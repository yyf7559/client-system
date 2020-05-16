package cn.service;

import cn.entity.Medicine;
import cn.entity.MedicineType;

import java.util.List;

public interface MedicineService {

    public List<MedicineType> findMedicineType(Integer pid);
    public List<Medicine> findMedicine(Integer typeId, String code,Integer pageNo,Integer pageSize);
    public List<Medicine> findMedicineByPid(Integer pid);
}
