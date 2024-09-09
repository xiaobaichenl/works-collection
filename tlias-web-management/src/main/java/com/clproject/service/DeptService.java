package com.clproject.service;

import com.clproject.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     */
    void add(Dept dept);

    /**
     * 修改部门
     *
     * @param id
     * @return
     */
    Dept getById(Integer id);
    void update(Dept dept);
}
