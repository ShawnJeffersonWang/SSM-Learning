package com.shawn.mapper;

import com.shawn.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     *
     * @return
     */
//    @Select("select count(*) from emp")
//    public Long count();

//    /**
//     * 分页查询获取列表数据
//     *
//     * @param start
//     * @param pageSize
//     * @return
//     */
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 员工信息查询
     *
     * @return
     */
    @Select("select * from emp")
    public List<Emp> list();
}
