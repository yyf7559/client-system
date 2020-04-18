package cn.service;

import cn.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModelService {
    public List<PrescriptionModel> findModel(Integer typeId,String permissions,String number,Integer pageNum,Integer pageSize);
    public int addPrice(PrescriptionAddPrice prescriptionAddPrice);
}
