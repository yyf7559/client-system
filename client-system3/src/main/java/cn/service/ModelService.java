package cn.service;

import cn.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModelService {
    public List<PrescriptionModel> findModel(Integer typeId,String permissions,String number);
    public List<Disease> findDisease();
    public List<Advice> findAdvice();
    public List<AddPrice>findAddPrice();
    public int addPrice(PrescriptionAddPrice prescriptionAddPrice);
}
