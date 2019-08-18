package com.web.dao;

import com.web.entity.User;
import com.web.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
	/**
	 * 根据用户名和密码登录查询
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public User login(@Param("userName") String userName,@Param("userPassword") String userPassword);
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
    List<User> queryPositionAndDepartmentByCondition(User user);
    
    

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}