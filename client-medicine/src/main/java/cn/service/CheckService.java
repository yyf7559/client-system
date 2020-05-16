package cn.service;

import cn.common.entity.PrescriptionCheck;
import cn.entity.Check;
import cn.entity.CheckType;

import java.util.List;

public interface CheckService {
    public List<Check> findCheck();
    public List<CheckType> findCheckType();
    public List<Check> findCheckByTypeId(Integer checkTypeId, String checkCode);
}
