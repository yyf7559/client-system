package cn.service;

import cn.entity.AddPrice;
import cn.entity.Prescription;
import cn.entity.PrescriptionAddPrice;

import java.util.List;

public interface PrescriptionService {
    public int addPrescription(Prescription prescription);

    public List<AddPrice> findAddPrice();

}
