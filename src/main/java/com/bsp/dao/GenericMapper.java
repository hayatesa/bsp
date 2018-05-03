package com.bsp.dao;

import com.bsp.entity.BaseEntity;

/**
 * 泛型Mapper，所有Mapper的父接口，封装基本的CRUD操作
 * @author hayate
 *
 * @param <T> Entity类型，必须为BaseEntity的子类
 * @param <K> 主键（key属性）类型
 */
public interface GenericMapper <T extends BaseEntity, K> {
	/**
	 * 根据id删除对象
	 * @param id 主键（key属性）
	 * @return 受影响记录数
	 */
    int deleteByPrimaryKey(K id);
    
    /**
     * 增加一条记录
     * @param record 对象
     * @return 受影响记录数
     */
    int insert(T record);
    
    /**
     * 增加一条记录，忽略值为null的字段
     * @param record 对象
     * @return 受影响记录数
     */
    int insertSelective(T record);
    
    /**
     * 根据id查找一条记录
     * @param id 主键（key属性）
     * @return 匹配对象
     */
    T selectByPrimaryKey(K id);
    
    /**
     * 更新一条记录，忽略值为null的字段
     * @param record 对象
     * @return 受影响记录数
     */
    int updateByPrimaryKeySelective(T record);
    
    /**
     * 更新一条记录
     * @param record 对象
     * @return 受影响记录数
     */
    int updateByPrimaryKey(T record);
}
