package cn.service;

import cn.entity.AddPrice;
import cn.common.entity.Prescription;


import java.util.List;

public interface PrescriptionService {
    public int addPrescription(Prescription prescription);

    public List<AddPrice> findAddPrice();

}
