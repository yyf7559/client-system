package cn.system1.service;

import cn.system1.entity.PrescriptionAddPrice;
import cn.system1.mapper.AddPrice;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    @Resource
    AddPrice addPrice;
    @Override
    public int addPrice(PrescriptionAddPrice prescriptionAddPrice) {
        return addPrice.addPrice(prescriptionAddPrice);
    }
}
