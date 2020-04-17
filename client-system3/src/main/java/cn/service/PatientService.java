package cn.service;

import cn.entity.Patient;
import cn.entity.Type;

import java.util.List;

public interface PatientService {
    public List<Patient> findPatient();
    public List<Type> findType();
}
