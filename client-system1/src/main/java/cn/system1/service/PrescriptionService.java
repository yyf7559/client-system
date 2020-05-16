package cn.system1.service;

import cn.system1.entity.Prescription;
import cn.system1.entity.PrescriptionDetail;


import java.util.List;

public interface PrescriptionService {
    public int addPrescription(Prescription prescription);//添加处方(诊断表)
    public int addPreDetail(PrescriptionDetail prescriptionDetail);//添加处方详情

}
