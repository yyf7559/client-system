package cn.service;

import cn.entity.Advice;
import cn.common.entity.PrescriptionAdvice;
import cn.mapper.AdviceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdviceServiceImpl implements AdviceService {
    @Resource
    AdviceMapper adviceMapper;
    @Override
    public int addAdvice(PrescriptionAdvice prescriptionAdvice) {
        return adviceMapper.addAdvice(prescriptionAdvice);
    }
    @Override
    public List<Advice> findAdvice() {
        return adviceMapper.findAdvice();
    }

}
