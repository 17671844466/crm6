package com.zhidisoft.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhidisoft.system.entity.Function;

/**
 * 通用的Dao接口
 * @author Lu jianliang
 *
 * @param <E>
 */
public interface BaseDao<E> {
	
	/**
	 * 总记录数
	 * @param condition
	 * @return
	 */
	int count(@Param("condition")Map<String, Object> condition);
	
	/**
	 * 通用的分页查询方法
	 * @param offset -起始索引
	 * @param pageSize -每一页最多记录数
	 * @param condition -查询条件
	 * @return
	 */
	List<E> findByPage(@Param("offset") int offset,@Param("pageSize")int pageSize,@Param("condition")Map<String,Object> condition);
	
	/**
	 * 通用的删除操作方法
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 通用插入实体对象到数据库的方法
     * @param record
     * @return
     */
    int insert(E record);

    /**
     * 通过查询单实体对象的方法
     * @param id
     * @return
     */
    E selectByPrimaryKey(Integer id);

   /**
    * 通用的获取所有实体对象的方法
    * @return
    */
    List<E> selectAll();

    /**
     * 通过更新方法
     * @param record
     * @return
     */
    int updateByPrimaryKey(E record);

}
