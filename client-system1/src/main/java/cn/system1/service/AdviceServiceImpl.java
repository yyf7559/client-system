package cn.system1.service;

import cn.system1.entity.PrescriptionAdvice;
import cn.system1.mapper.AdviceMapper;
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

}
