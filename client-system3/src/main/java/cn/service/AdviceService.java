package cn.service;

import cn.entity.Advice;
import cn.entity.PrescriptionAdvice;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdviceService {
    public int addAdvice(PrescriptionAdvice prescriptionAdvice);//插入医嘱处方表数据
    public List<Advice> findAdvice();
}
