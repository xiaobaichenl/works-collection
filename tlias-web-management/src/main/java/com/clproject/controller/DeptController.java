package com.clproject.controller;

import com.clproject.pojo.Dept;
import com.clproject.pojo.Result;
import com.clproject.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController // IoC控制反转
@RequestMapping("/depts")   // 所有部门操作共用的路径映射
// bean对象
public class DeptController {

    // private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;    // 注入依赖

    /**
     * 查询部门数据
     * @return
     */
    // @RequestMapping(value = "/depts",method = RequestMethod.GET)    // 指定请求方式为GET
    // @GetMapping("/depts")
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        // 调用service查询部门数据
        List<Dept>  deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门数据
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){     // @PathVariable获取路径参数
        log.info("根据id删除部门：{}",id);
        // 调用service删除部门数据
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门数据
     * @return
     */
    // @PostMapping("/depts")
    @PostMapping
    public Result add(@RequestBody Dept dept){      // @RequestBody接收JSON格式数据
        log.info("新增部门：{}",dept);
        // 调用service新增部门数据
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 修改部门信息
     * @return
     */
    // 数据回显
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id修改部门数据回显：{}",id);
        // 调用service回显数据
        Dept dept =  deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门：{}",dept.getId());
        // 调用service修改部门数据
        deptService.update(dept);
        return Result.success();
    }

}
