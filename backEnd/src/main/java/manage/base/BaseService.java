package manage.base;

import java.util.List;

import manage.util.PageInfo;

public interface BaseService<T> {
	
	
	int deleteByPrimaryKey(String username);

	String insert(T record);

	String insertSelective(T record);

	T selectByPrimaryKey(String username);

	String updateByPrimaryKeySelective(T record);

	String updateByPrimaryKey(T record);

	List<?> selectAll(PageInfo page);
}	

