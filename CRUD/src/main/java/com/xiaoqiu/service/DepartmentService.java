package com.xiaoqiu.service;

import com.xiaoqiu.bean.Department;
import com.xiaoqiu.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小邱
 * @version 0.0.1
 * @description DepartmentService
 * @since 2021/10/21 20:55
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    public List<Department> getDepts() {
        return departmentMapper.selectByExample(null);
    }
}
