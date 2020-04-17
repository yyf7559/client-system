package cn.system1.controller;

import cn.common.http.HttpClientHelper;
import cn.common.response.Response;
import cn.common.response.ResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "员工查询")
@RequestMapping("/call/employee")
public class EmployeeController {
    @Resource
    HttpClientHelper httpClientHelper;
    String employeeUrl="http://localhost:8083/come/employee/";
    @GetMapping("/findEmployee")
    @ApiOperation(value = "根据科室查询员工信息",notes = "")
    public Response findEmployee(Integer departmentId){
        return httpClientHelper.get(employeeUrl+"findEmployee?departmentId="+departmentId);
    }
    @GetMapping("/findDepartment")
    @ApiOperation(value = "查询所有科室",notes = "")
    public Response findDepartment(){
        return httpClientHelper.get(employeeUrl+"findDepartment");
    }

}
