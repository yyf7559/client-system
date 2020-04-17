package cn.service;

import cn.entity.PrescriptionAdvice;
import org.springframework.stereotype.Service;


public interface AdviceService {
    public int addAdvice(PrescriptionAdvice prescriptionAdvice);//插入医嘱处方表数据
}
