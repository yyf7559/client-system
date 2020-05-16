package cn.service;

import cn.entity.Disease;
import cn.common.entity.PrescriptionDisease;

import java.util.List;

public interface DiseaseService {
    public int addDisease(PrescriptionDisease prescriptionDisease);//插入疾病处方表数据
    public List<Disease> findDisease();
}
