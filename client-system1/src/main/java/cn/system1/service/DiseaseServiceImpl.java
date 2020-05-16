package cn.system1.service;

import cn.system1.entity.PrescriptionDisease;

import cn.system1.mapper.DiseaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService{
    @Resource
    DiseaseMapper diseaseMapper;
    @Override
    public int addDisease(PrescriptionDisease prescriptionDisease) {
        return diseaseMapper.addDisease(prescriptionDisease);
    }

}
