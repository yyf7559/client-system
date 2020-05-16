package cn.system1.service;

import cn.system1.entity.PrescriptionCheck;

import cn.system1.mapper.CheckMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {
    @Resource
    CheckMapper checkMapper;
    @Override
    public int addPreCheck(PrescriptionCheck prescriptionCheck) {
        return checkMapper.addPreCheck(prescriptionCheck);
    }
}
