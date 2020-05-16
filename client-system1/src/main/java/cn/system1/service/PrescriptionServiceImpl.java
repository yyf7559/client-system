package cn.system1.service;

import cn.system1.entity.Prescription;

import cn.system1.entity.PrescriptionDetail;
import cn.system1.mapper.PrescriptionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Resource
    PrescriptionMapper prescriptionMapper;
    @Override
    public int addPrescription(Prescription prescription) {
        return prescriptionMapper.addPrescription(prescription);
    }
    @Override
    public int addPreDetail(PrescriptionDetail prescriptionDetail) {
        return prescriptionMapper.addPreDetail(prescriptionDetail);
    }
}
