package cn.system1.mapper;


import cn.system1.entity.PrescriptionAddPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddPrice {
    public int addPrice(@Param("prescriptionAddPrice") PrescriptionAddPrice prescriptionAddPrice);
}
