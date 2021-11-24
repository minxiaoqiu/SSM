package com.xiaoqiu.controller;

import com.xiaoqiu.bean.Department;
import com.xiaoqiu.bean.MSG;
import com.xiaoqiu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 小邱
 * @version 0.0.1
 * @description DeptController
 * @since 2021/10/21 20:54
 */
@Controller
public class DeptController {

    @Autowired
    private DepartmentService departmentService;

    //返回所有的部门信息
    @RequestMapping("/depts")
    @ResponseBody
    public MSG getDepts(){
        //查出的所有部门信息
        return MSG.success().add("depts", departmentService.getDepts());
    }


}
