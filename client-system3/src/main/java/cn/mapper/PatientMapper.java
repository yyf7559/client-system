package cn.mapper;

import cn.entity.Patient;
import cn.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {
    public List<Patient> findPatient();
    public List<Type> findType();
}
