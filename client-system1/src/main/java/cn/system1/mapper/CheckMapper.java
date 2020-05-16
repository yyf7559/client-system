package cn.system1.mapper;

import cn.system1.entity.PrescriptionCheck;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckMapper {
    public int addPreCheck(@Param("prescriptionCheck") PrescriptionCheck prescriptionCheck);

}
