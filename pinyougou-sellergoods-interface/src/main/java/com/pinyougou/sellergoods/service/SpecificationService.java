package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import entity.PageResult;

public interface SpecificationService {

    PageResult findAll(TbSpecification tbSpecification, int page, int rows);

    void delete(Long[] id);

    void add(TbSpecification specification);

    TbSpecification selectById(Long id);

    void update(TbSpecification specification);
}
