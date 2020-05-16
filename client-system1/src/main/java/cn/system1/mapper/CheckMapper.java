package cn.mapper;

import cn.entity.Check;
import cn.entity.CheckType;
import cn.common.entity.PrescriptionCheck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CheckMapper {
    public List<Check> findCheck();//查询所以检查项目
    public List<CheckType> findCheckType();//查询检查项目类型
    public List<Check> findCheckByTypeId(@Param("checkKindId") Integer checkKindId,@Param("checkCode") String checkCode);//根据类型和名称或拼音查询
    public int addPreCheck(@Param("prescriptionCheck") PrescriptionCheck prescriptionCheck);

}
