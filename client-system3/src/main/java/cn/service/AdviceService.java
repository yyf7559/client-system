package cn.service;

import cn.entity.Advice;
import cn.common.entity.PrescriptionAdvice;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdviceService {
    public List<Advice> findAdvice();
}
