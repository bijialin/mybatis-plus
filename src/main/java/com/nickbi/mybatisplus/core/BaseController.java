package com.nickbi.mybatisplus.core;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通用Controller（增删改查）
 * 
 * @param <T>
 */
public abstract class BaseController<S extends IService<T>, T> {

	private static final Logger log = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected S service;

	/**
	 * 新增
	 * 
	 * @param t
	 * @return
	 */
	@PostMapping("/add")
	@ResponseBody
	public Result add(T t) {
		if (service.insert(t)) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("失败!");
		}
	}
	
	/**
	 * 新增
	 * 
	 * @param t
	 * @return
	 */
	@PostMapping("/insertOrUpdate")
	@ResponseBody
	public Result insertOrUpdate(T t) { 
		if (service.insertOrUpdate(t)) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("失败!");
		}
	}
	 

	/**
	 * 更新
	 * 
	 * @param t
	 * @return
	 */
	@PostMapping("/update")
	@ResponseBody
	public Result update(@RequestBody T t) {
		if (service.updateById(t)) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("失败!");
		}
	}

	/**
	 * 根据id获取实体对象
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/detail/{id}")
	@ResponseBody
	public Result getInfo(@PathVariable Long id) {
		T t = service.selectById(id);
		return ResultGenerator.genSuccessResult(t);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/delete/{id}")
	@ResponseBody
	public Result delete(@PathVariable Long id) {
		if (service.deleteById(id)) {
			return ResultGenerator.genSuccessResult();
		} else {
			log.debug("删除失败!");
			return ResultGenerator.genFailResult("失败!");
		}
	}

	/**
	 * 根据对象分页查询
	 * 
	 * @param spage
	 * @return
	 */
	@GetMapping("/list")
	@ResponseBody
	public CustomPage<T> selectPage(CustomPage<T> page,T t) {
		Wrapper<T> wrapper = new EntityWrapper<T>(t);
		Page<T> pages = service.selectPage(page.myPagePlus(), wrapper);
		return new CustomPage<T>(pages);
	}
}
