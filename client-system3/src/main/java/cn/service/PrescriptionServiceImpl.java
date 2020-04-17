package cn.service;

import cn.entity.Prescription;
import cn.mapper.PrescriptionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Resource
    PrescriptionMapper prescriptionMapper;
    @Override
    public int addPrescription(Prescription prescription) {
        return prescriptionMapper.addPrescription(prescription);
    }
}