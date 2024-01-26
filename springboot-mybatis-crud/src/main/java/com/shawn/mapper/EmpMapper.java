package com.shawn.mapper;

import com.shawn.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    // 根据ID删除数据
    // 如果mapper接口方法形参只有一个普通类型的参数， #{}里面的属性名可以随便写
    // #{}会被"?"替代，生成预编译SQL
    /*
    预编译SQL：
    1.性能更高
    2.更安全(防止SQL注入)

    SQL语法解析检查->优化SQL->编译SQL->执行SQL
    为了提高效率，数据库会将优化编译后的SQL缓存起来，缓存就是一块内存区域

    SQL注入是通过操作输入的数据来修改事先定义好的SQL语句，以达到执行代码对服务器进行攻击的方法

    参数占位符：
    #{}：执行SQL时，会将#{}替换为?，生成预编译SQL，会自动设置参数值。使用时机：参数传递，都是用#{...}
    ${}：拼接SQL，直接将参数拼接在SQL语句中，存在SQL注入问题。使用时机：如果对表名，列表进行动态设置时使用
     */
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);
//    public int delete(Integer id);

    // 新增员工
    // 对象中的属性名，采用驼峰命名，下划线是字段名
    // 会自动将生成的主键值，赋值给emp对象的id属性
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " VALUES (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    // 更新员工
//    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image}," +
//            " job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
//    public void update(Emp emp);

    // 方案三：开启mybatis的驼峰命名自动映射开关 --- a_column -----> aColumn
    // 根据ID查询员工
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    // 方案一：给字段其别名，让别名与实体类属性一致
//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp getById(Integer id);

    // 方案二：通过@Results,@Result注解手动映射封装
//    @Results({
//            @Result(column = "dept_id",property="deptId"),
//            @Result(column = "create_time",property="createTime"),
//            @Result(column = "update_time",property="updateTime")
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp getById(Integer id);

    // 条件查询员工
    // 方式一
    // 性能低，不安全，存在SQL注入问题
//    @Select("select * from emp where name like '%${name}%' and gender=#{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc ")
//    public List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);

    // 方式二
//    @Select("select * from emp where name like concat('%',#{name},'%') and gender=#{gender} and " +
//            "entrydate between #{begin} and #{end} order by update_time desc ")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /*
    使用Mybatis的注解，主要是来完成一些简单的增删改查功能。如果需要实现复杂的SQL功能，建议使用XML来配置映射语句
     */
    // 动态条件查询
    // <if>: 用于判断条件是否成立。使用test属性进行条件判断，如果条件为true，则拼接SQL
    // <where>: where元素只会在子元素有内容的情况下才插入where子句。而且会自动去除子句的开头的AND或OR
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    // 动态更新员工
    void update2(Emp emp);

    // 批量删除
    void deleteByIds(List<Integer> ids);
}
