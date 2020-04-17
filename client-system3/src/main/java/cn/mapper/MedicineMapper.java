package cn.mapper;

import cn.entity.Medicine;
import cn.entity.MedicineType;
import cn.entity.PrescriptionDetail;
import cn.entity.PrescriptionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MedicineMapper {
    public List<MedicineType> findMedicineType(@Param("pid")Integer pid);
    public List<Medicine> findMedicine(@Param("typeId")Integer typeId,@Param("code")String code);
    public List<Medicine> findMedicineByPid(@Param("pid")Integer pid);
    public List<PrescriptionType> findPrescriptionType();
    public int addPreDetail(@Param("prescriptionDetail")PrescriptionDetail prescriptionDetail);//添加处方详情
}
