package cn.system1.mapper;


import cn.common.entity.PrescriptionAddPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModelMapper {
    public int addPrice(@Param("prescriptionAddPrice") PrescriptionAddPrice prescriptionAddPrice);
}
