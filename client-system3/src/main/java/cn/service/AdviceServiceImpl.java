package cn.service;

import cn.entity.PrescriptionAdvice;
import cn.mapper.AdviceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AdviceServiceImpl implements AdviceService {
    @Resource
    AdviceMapper adviceMapper;
    @Override
    public int addAdvice(PrescriptionAdvice prescriptionAdvice) {
        return adviceMapper.addAdvice(prescriptionAdvice);
    }
}
