package com.lxy.mapper;

import com.lxy.model.LxySystemParameter;

public interface LxySystemParameterMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lxy_system_parameter
	 * @mbggenerated  Thu Dec 04 16:19:17 CST 2014
	 */
	int deleteByPrimaryKey(Long paraId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lxy_system_parameter
	 * @mbggenerated  Thu Dec 04 16:19:17 CST 2014
	 */
	int insert(LxySystemParameter record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lxy_system_parameter
	 * @mbggenerated  Thu Dec 04 16:19:17 CST 2014
	 */
	int insertSelective(LxySystemParameter record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lxy_system_parameter
	 * @mbggenerated  Thu Dec 04 16:19:17 CST 2014
	 */
	LxySystemParameter selectByPrimaryKey(Long paraId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lxy_system_parameter
	 * @mbggenerated  Thu Dec 04 16:19:17 CST 2014
	 */
	int updateByPrimaryKeySelective(LxySystemParameter record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table lxy_system_parameter
	 * @mbggenerated  Thu Dec 04 16:19:17 CST 2014
	 */
	int updateByPrimaryKey(LxySystemParameter record);
}