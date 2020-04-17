package cn.service;

import cn.entity.*;
import cn.mapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    @Resource
    ModelMapper modelMapper;

    @Override
    public List<PrescriptionModel> findModel(Integer typeId, String permissions, String number) {
        return modelMapper.findModel(typeId,permissions,number);
    }

    @Override
    public List<Disease> findDisease() {
        return modelMapper.findDisease();
    }

    @Override
    public List<Advice> findAdvice() {
        return modelMapper.findAdvice();
    }

    @Override
    public List<AddPrice> findAddPrice() {
        return modelMapper.findAddPrice();
    }

    @Override
    public int addPrice(PrescriptionAddPrice prescriptionAddPrice) {
        return modelMapper.addPrice(prescriptionAddPrice);
    }
}
