package cn.mapper;

import cn.entity.Department;
import cn.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    public List<Department> findDepartment();
    public List<Employee> findEmployee(@Param("departmentId")Integer departmentId);
}
