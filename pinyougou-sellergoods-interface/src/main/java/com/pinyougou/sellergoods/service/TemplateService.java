package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface TemplateService {
    PageResult findAll(TbTypeTemplate tbTypeTemplate, int page, int rows);

    List<Map> findBrand();

    List<Map> findSpecification();

    void add(TbTypeTemplate template);

    TbTypeTemplate findOne(Long id);

    void update(TbTypeTemplate template);
}
