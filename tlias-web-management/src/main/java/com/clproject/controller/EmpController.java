package com.clproject.controller;

import com.clproject.pojo.Emp;
import com.clproject.pojo.PageBean;
import com.clproject.pojo.Result;
import com.clproject.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
                            // if(page == null || page < 1){page = 1;} //设置默认页码为1
                            // if(pageSize == null || pageSize < 1){pageSize = 10;} //设置默认页面列表数据量
        log.info("分页查找，参数：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        // 调用service分页查找
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作，ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工，emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }



    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable Integer id){
        log.info("根据ID查询员工信息，id：{}",id);
        Emp emp = empService.getEmpById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("根据ID修改员工信息{}",emp.getId());
        empService.update(emp);
        return Result.success();
    }

}
