package com.xiaoqiu.test;

/**
 * @author 小邱
 * @version 0.0.1
 * @description MapperTest
 * @since 2021/10/19 19:20
 */

import com.xiaoqiu.bean.Department;
import com.xiaoqiu.bean.Employee;
import com.xiaoqiu.dao.DepartmentMapper;
import com.xiaoqiu.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.UUID;

/**
 * 测试dao层的工作
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、直接autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;


    //测试DepartmentMapper
    @Test
    public void testDepartmentMapper() {
        //1、插入几个部门
        //departmentMapper.insertSelective(new Department(null, "包装部"));

        //2、生成员工数据，测试员工插入
        //employeeMapper.insertSelective(new Employee(null, "欧阳娜娜", "0", "nana@qq.com", 1003));

        //3、批量插入多个员工；批量，使用可以执行批量操作的sqlSession
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            int nextInt = random.nextInt(7) +1;
            Employee employee = new Employee(null, uid, new Integer(new Random().nextInt(2)).toString(), uid + "@qq.com", 1000 + nextInt);
            mapper.insertSelective(employee);
        }
    }

}
