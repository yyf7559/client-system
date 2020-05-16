package cn.service;

import cn.entity.Check;
import cn.entity.CheckType;
import cn.common.entity.PrescriptionCheck;
import cn.mapper.CheckMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {
    @Resource
    CheckMapper checkMapper;

    @Override
    public List<Check> findCheck() {
        return checkMapper.findCheck();
    }

    @Override
    public List<CheckType> findCheckType() {
        return checkMapper.findCheckType();
    }

    @Override
    public List<Check> findCheckByTypeId(Integer checkTypeId, String checkCode) {
        return checkMapper.findCheckByTypeId(checkTypeId,checkCode);
    }

    @Override
    public int addPreCheck(PrescriptionCheck prescriptionCheck) {
        return checkMapper.addPreCheck(prescriptionCheck);
    }
}
