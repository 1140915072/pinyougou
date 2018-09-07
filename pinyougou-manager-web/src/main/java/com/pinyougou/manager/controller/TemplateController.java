package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TemplateService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/template")
public class TemplateController {
    @Reference
    private TemplateService templateService;
    @RequestMapping("/findAll")
    public PageResult findAll(@RequestBody TbTypeTemplate tbTypeTemplate, int page, int rows){
        return templateService.findAll(tbTypeTemplate,page,rows);
    }
    @RequestMapping("/findBrand")
    public List<Map> findBrand(){
        return templateService.findBrand();
    }
    @RequestMapping("/findSpecification")
    public List<Map> findSpecification(){
        return templateService.findSpecification();
    }
    @RequestMapping("/add")
    public Result add(@RequestBody TbTypeTemplate template){
       try {
           templateService.add(template);
            return new Result(true, "新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增失败！");
        }
    }
    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(Long id){
        return templateService.findOne(id);
    }
    @RequestMapping("/update")
    public Result update(@RequestBody TbTypeTemplate template){
        try {
            templateService.update(template);
            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败！");
        }
    }
}
