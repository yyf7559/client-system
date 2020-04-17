package cn.mapper;

import cn.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModelMapper {
    public List<PrescriptionModel> findModel(@Param("typeId")Integer typeId,@Param("permissions")String permissions,@Param("number")String number);
    public List<Disease> findDisease();
    public List<Advice> findAdvice();
    public List<AddPrice> findAddPrice();
    public int addPrice(@Param("prescriptionAddPrice") PrescriptionAddPrice prescriptionAddPrice);
}
