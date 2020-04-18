package cn.mapper;

import cn.entity.AddPrice;
import cn.entity.Prescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrescriptionMapper {
    public int addPrescription(@Param("prescription") Prescription prescription);
    public List<AddPrice> findAddPrice();//查询附加费用
}
