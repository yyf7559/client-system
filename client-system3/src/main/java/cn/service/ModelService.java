package cn.service;


import cn.common.entity.PrescriptionAddPrice;
import cn.entity.AddPrice;
import cn.entity.PrescriptionModel;
import cn.entity.PrescriptionType;

import java.util.List;

public interface ModelService {
    public List<PrescriptionModel> findModel(Integer typeId, String permissions, String number, Integer pageNum, Integer pageSize);
    public List<AddPrice> findAddPrice();
    public List<PrescriptionType> findPrescriptionType();
}
