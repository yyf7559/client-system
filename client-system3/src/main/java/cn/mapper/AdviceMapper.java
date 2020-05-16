package cn.mapper;


import cn.entity.Advice;
import cn.common.entity.PrescriptionAdvice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdviceMapper {
    public List<Advice> findAdvice();
}
