package com.lxy.mapper;

import com.lxy.model.LxyRole;

public interface LxyRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxy_role
     *
     * @mbggenerated Sat Nov 29 12:08:38 CST 2014
     */
    int deleteByPrimaryKey(Long roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxy_role
     *
     * @mbggenerated Sat Nov 29 12:08:38 CST 2014
     */
    int insert(LxyRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxy_role
     *
     * @mbggenerated Sat Nov 29 12:08:38 CST 2014
     */
    int insertSelective(LxyRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxy_role
     *
     * @mbggenerated Sat Nov 29 12:08:38 CST 2014
     */
    LxyRole selectByPrimaryKey(Long roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxy_role
     *
     * @mbggenerated Sat Nov 29 12:08:38 CST 2014
     */
    int updateByPrimaryKeySelective(LxyRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lxy_role
     *
     * @mbggenerated Sat Nov 29 12:08:38 CST 2014
     */
    int updateByPrimaryKey(LxyRole record);
}