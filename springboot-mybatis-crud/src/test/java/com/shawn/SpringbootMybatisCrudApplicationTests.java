package com.shawn;

import com.shawn.mapper.EmpMapper;
import com.shawn.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
可以在application.properties中，打开mybatis的日志，并指定输出到控制台
 */
@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete() {
//        int delete = empMapper.delete(16);
//        System.out.println(delete);
        empMapper.delete(16);
    }

    @Test
    public void testInsert() {
        // 构造员工对象
        Emp emp = new Emp();
        emp.setUsername("Tom2");
        emp.setName("Tom2");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        // 执行新增员工信息操作
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate() {
        // 构造员工对象
        Emp emp = new Emp();
        emp.setId(16);
        emp.setUsername("Tom2");
        emp.setName("Tom2");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        // 执行更新员工操作
        empMapper.update(emp);
    }

    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(15);
        System.out.println(emp);
    }

    // 根据条件查询员工
    @Test
    public void testList() {
        List<Emp> empList = empMapper.list("张", (short) 1, LocalDate.of(2010, 1, 1),
                LocalDate.of(2020, 1, 1));
        System.out.println(empList);
    }
}
