package cn.service;


import cn.entity.Patient;
import cn.entity.Type;
import cn.mapper.PatientMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    @Resource
    PatientMapper patientMapper;
    @Override
    public List<Patient> findPatient() {
        return patientMapper.findPatient();
    }

    @Override
    public List<Type> findType() {
        return patientMapper.findType();
    }
}
