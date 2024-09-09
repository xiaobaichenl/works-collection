package com.clproject.mapper;

import com.clproject.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理数据
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 修改部门信息
     * @return
     */
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    @Update("update dept set name = #{name},create_time = #{createTime},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
