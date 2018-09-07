package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 *
 * <pre>项目名称：pinyougou-sellergoods-interface
 * 类名称：BrandService
 * 类描述：    品牌
 * 创建人：高强 yangzhichao150@126.com
 * 创建时间：2018年9月4日 下午3:49:11
 * 修改人：高强 yangzhichao150@126.com
 * 修改时间：2018年9月4日 下午3:49:11
 * 修改备注：
 * @version </pre>
 */
public interface BrandService {


	/**
	 * 品牌列表查询
	 * @return
	 */
	public List<TbBrand> findAll();

	/**
	 * 品牌分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageResult findPage(int page, int rows);

	/**
	 * 新增品牌
	 * @param tbBrand
	 */
	public void add(TbBrand tbBrand);

	/**
	 * 修改回显品牌
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);

	/**
	 * 修改品牌
	 * @param tbBrand
	 */
	public void update(TbBrand tbBrand);

	/**
	 *
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 *带条件的分页查询
	 * @param tbBrand
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageResult findPage(TbBrand tbBrand, int page, int rows);
}
