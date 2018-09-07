package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.sellergoods.service.SpecificationService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private TbSpecificationMapper specificationMapper;
    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    @Override
    public PageResult findAll(TbSpecification tbSpecification, int page, int rows) {
        PageHelper.startPage(page,rows);
        TbSpecificationExample example=new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();
        if(tbSpecification!=null){
            if(tbSpecification.getSpecName()!=null && tbSpecification.getSpecName().length()>0){
                criteria.andSpecNameLike("%"+tbSpecification.getSpecName()+"%");
            }
        }
        Page<TbSpecification> p = (Page<TbSpecification>) specificationMapper.selectByExample(example);
        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            specificationMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void add(TbSpecification specification) {
        specificationMapper.insert(specification);
        List<TbSpecificationOption> list=specification.getSpecList();
        for (TbSpecificationOption sp: list) {
            sp.setSpecId(specification.getId());
            specificationOptionMapper.insert(sp);
        }
    }

    @Override
    public TbSpecification selectById(Long id) {
        TbSpecification specification= specificationMapper.selectByPrimaryKey(id);
        List<TbSpecificationOption> list=specificationOptionMapper.selectBySpecId(id);
        specification.setSpecList(list);
        return specification;
    }

    @Override
    public void update(TbSpecification specification) {
        List<TbSpecificationOption> list=specification.getSpecList();
        specificationOptionMapper.deleteBySpecId(specification.getId());
        specificationMapper.updateByPrimaryKey(specification);
        for (TbSpecificationOption sp: list) {
            sp.setSpecId(specification.getId());
            specificationOptionMapper.insert(sp);
        }
    }
}
