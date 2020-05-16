package cn.service;

import cn.entity.Medicine;
import cn.entity.MedicineType;
import cn.common.entity.PrescriptionDetail;
import cn.entity.PrescriptionType;
import cn.mapper.MedicineMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService{
    @Resource
    MedicineMapper medicineMapper;
    @Override
    public List<MedicineType> findMedicineType(Integer pid) {
        return medicineMapper.findMedicineType(pid);
    }

    @Override
    public List<Medicine> findMedicine(Integer typeId, String code) {
        return medicineMapper.findMedicine(typeId,code);
    }

    @Override
    public List<Medicine> findMedicineByPid(Integer pid) {
        return medicineMapper.findMedicineByPid(pid);
    }

    @Override
    public List<PrescriptionType> findPrescriptionType() {
        return medicineMapper.findPrescriptionType();
    }

    @Override
    public int addPreDetail(PrescriptionDetail prescriptionDetail) {
        return medicineMapper.addPreDetail(prescriptionDetail);
    }
}
