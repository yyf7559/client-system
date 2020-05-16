package cn.service;

import cn.entity.Check;
import cn.entity.CheckType;
import cn.common.entity.PrescriptionCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckService {
    public List<Check> findCheck();
    public List<CheckType> findCheckType();
    public List<Check> findCheckByTypeId(Integer checkTypeId,String checkCode);
    public int addPreCheck(PrescriptionCheck prescriptionCheck);
}
