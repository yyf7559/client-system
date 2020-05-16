package cn.service;

import cn.entity.Disease;
import cn.common.entity.PrescriptionDisease;
import cn.mapper.DiseaseMapper;
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
    @Override
    public List<Disease> findDisease() {
        return diseaseMapper.findDisease();
    }

}
