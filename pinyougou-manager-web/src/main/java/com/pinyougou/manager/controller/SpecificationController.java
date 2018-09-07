package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.sellergoods.service.SpecificationService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Reference
    private SpecificationService specificationService;
    @RequestMapping("/findAll")
    public PageResult findAll(@RequestBody TbSpecification tbSpecification, int page, int rows){

        return specificationService.findAll(tbSpecification,page,rows);
    }
    @RequestMapping("/delete")
    public Result delete(Long[] id){
        try {
            specificationService.delete(id);
            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败！");
        }
    }
    @RequestMapping("/add")
    public Result add(@RequestBody TbSpecification specification){
        try {
            specificationService.add(specification);
            return new Result(true, "新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增失败！");
        }
    }
    @RequestMapping("/selectById")
    public TbSpecification selectById(Long id){

        return specificationService.selectById(id);
    }
    @RequestMapping("/update")
    public Result update(@RequestBody TbSpecification specification){
        try {
            specificationService.update(specification);
            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败！");
        }
    }
}
