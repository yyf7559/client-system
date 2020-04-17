package cn.service;

import cn.entity.PrescriptionDisease;
import cn.mapper.DiseaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DiseaseServiceImpl implements DiseaseService{
    @Resource
    DiseaseMapper diseaseMapper;
    @Override
    public int addDisease(PrescriptionDisease prescriptionDisease) {
        return diseaseMapper.addDisease(prescriptionDisease);
    }
}
