package com.shawn;

import com.shawn.mapper.EmploMapper;
import com.shawn.pojo.Emplo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/*
可以在application.properties中，打开mybatis的日志，并指定输出到控制台
 */
@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmploMapper empMapper;

    @Test
    public void testDelete() {
//        int delete = empMapper.delete(16);
//        System.out.println(delete);
        empMapper.delete(16);
    }

    @Test
    public void testInsert() {
        // 构造员工对象
        Emplo emp = new Emplo();
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
        Emplo emp = new Emplo();
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
//        empMapper.update(emp);
    }

    @Test
    public void testUpdate2(){
        // 构造员工对象
        Emplo emp = new Emplo();
        emp.setId(18);
        emp.setUsername("Tom222333");
//        emp.setName("Tom222");
//        emp.setGender((short) 1);
//        emp.setUpdateTime(LocalDateTime.now());

        // 执行更新员工操作
        empMapper.update2(emp);
    }

    @Test
    public void testGetById() {
        Emplo emp = empMapper.getById(15);
        System.out.println(emp);
    }

    /*
    动态SQL：随着用户的输入或外部条件的变化而变化的SQL语句，我们称为动态SQL
     */
    // 根据条件查询员工
    @Test
    public void testList() {
        List<Emplo> empList = empMapper.list("张", (short) 1, LocalDate.of(2010, 1, 1),
                LocalDate.of(2020, 1, 1));
        List<Emplo> empList1 = empMapper.list("张", null, null, null);
        List<Emplo> empList2 = empMapper.list("张", (short) 1, null, null);
        List<Emplo> empList3 = empMapper.list(null, (short) 1, null, null);
        List<Emplo> empList4 = empMapper.list(null, null, null, null);
//        System.out.println(empList);
//        System.out.println(empList1);
//        System.out.println(empList2);
//        System.out.println(empList3);
        System.out.println(empList4);
    }

    // 批量删除员工
    @Test
    public void testDeletedByIds(){
        List<Integer> ids= Arrays.asList(13,14,15);
        empMapper.deleteByIds(ids);
    }
}
