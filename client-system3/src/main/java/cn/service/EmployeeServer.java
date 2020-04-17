package cn.service;

import cn.entity.Department;
import cn.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeServer {
    public List<Department> findDepartment();
    public List<Employee> findEmployee(Integer departmentId);
}
