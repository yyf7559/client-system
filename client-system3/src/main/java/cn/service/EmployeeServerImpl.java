package cn.service;

import cn.entity.Department;
import cn.entity.Employee;
import cn.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServerImpl implements EmployeeServer {
    @Resource
    EmployeeMapper employeeMapper;
    @Override
    public List<Department> findDepartment() {
        return employeeMapper.findDepartment();
    }

    @Override
    public List<Employee> findEmployee(Integer departmentId) {
        return employeeMapper.findEmployee(departmentId);
    }
}
