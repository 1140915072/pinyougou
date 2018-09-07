package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbAddressExample;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.pojo.TbTypeTemplateExample;
import com.pinyougou.sellergoods.service.TemplateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TbTypeTemplateMapper templateMapper;


    @Override
    public PageResult findAll(TbTypeTemplate tbTypeTemplate, int page, int rows) {
        PageHelper.startPage(page,rows);
        TbTypeTemplateExample templateExample=new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = templateExample.createCriteria();
        if(tbTypeTemplate!=null){
            if(tbTypeTemplate.getName()!=null && tbTypeTemplate.getName().length()>0){
                criteria.andNameLike("%"+tbTypeTemplate.getName()+"%");
            }
        }
        Page<TbTypeTemplate> p= (Page<TbTypeTemplate>) templateMapper.selectByExample(templateExample);
        return new PageResult(p.getTotal(),p.getResult());
    }

    @Override
    public List<Map> findBrand() {
        return templateMapper.findBrand();
    }

    @Override
    public List<Map> findSpecification() {
        return templateMapper.findSpecification();
    }

    @Override
    public void add(TbTypeTemplate template) {
        templateMapper.insert(template);
    }

    @Override
    public TbTypeTemplate findOne(Long id) {
        return templateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbTypeTemplate template) {
        templateMapper.updateByPrimaryKey(template);
    }
}
