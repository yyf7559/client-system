package cn.mapper;

import cn.entity.Patient;
import cn.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PatientMapper {
    public List<Patient> findPatient(@Param("id") Integer id);
    public List<Type> findType();
}
