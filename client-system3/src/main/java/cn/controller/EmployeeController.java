package cn.controller;

import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import cn.entity.Department;
import cn.entity.Employee;
import cn.mapper.EmployeeMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/come/employee")
public class EmployeeController {
    @Resource
    EmployeeMapper employeeMapper;
    @GetMapping("/findEmployee")
    public Response findEmployee(Integer departmentId){
        List<Employee>list=employeeMapper.findEmployee(departmentId);
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("人员查询出错啦！");
    }
    @GetMapping("/findDepartment")
    public Response findDepartment(){
        List<Department>list=employeeMapper.findDepartment();
        if(list!=null){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(list);
        }
        return new Response(ResponseEnum.ERROR).setResponseBody("科室查询出错啦！");
    }
}
