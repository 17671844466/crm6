package com.zhidisoft.common.copy;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 基于easyui和mybatis设计的分页javaBean
 * 包装了：page表示当前页码，rows表示当前一页行数，result表示结果、total表示总记录数，offset表示起始记录数
 * condition表示查询条件
 * @author lx
 *
 */
public class PageBean<E> {
	/** 当前页码 */
	@JsonIgnore
	private Integer page = 1;
	/** 每一页获取的最大记录数 */
	@JsonIgnore
	private Integer rows = 10;
	/** 总记录数 */
	private Integer total ;
	/** 起始记录索引 */
	@JsonIgnore
	private Integer offset;
	/** 分页查询的记录结果 */
	@JsonProperty("rows")
	private List<E> result;
	/** 查询条件 */
	@JsonIgnore
	private Map<String, Object> condition;
	
	public PageBean(){
		
	}
	
	public PageBean(Integer page,Integer rows){
		if(page<1){
			page = 1;
		}
		this.page = page;
		if(rows == null || rows < 1){
			rows = 10;
		}
		this.rows = rows;
		this.offset = (page-1) * rows;
		
	}
	
	public Integer getPage() {
		return page;
	}
	public Integer getRows() {
		return rows;
	}
	public Integer getTotal() {
		return total;
	}
	public List<E> getResult() {
		return result;
	}
	public Map<String, Object> getCondition() {
		return condition;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public void setResult(List<E> result) {
		this.result = result;
	}
	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	public Integer getOffset() {
		return ( page - 1 ) * rows;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", offset=" + offset + ", result="
				+ result + ", condition=" + condition + "]";
	}
	
	
	
}
