package com.web.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.biz.UserBiz;
import com.web.dao.UserDao;
import com.web.entity.User;
import com.web.entity.UserExample;
import com.web.util.MyBatisUtil;

public class UserBizImpl implements UserBiz {

	SqlSession sqlSession =MyBatisUtil.openSession();
	UserDao ud=sqlSession.getMapper(UserDao.class);
	
	@Override
	public long countByExample(UserExample example) {
		long t=ud.countByExample(example);
		sqlSession.close();
		return t;
	}

	@Override
	public int deleteByExample(UserExample example) {
		int t=ud.deleteByExample(example);
		sqlSession.close();
		return t;
	}

	@Override
	public int deleteByPrimaryKey(Integer userId) {
		return ud.deleteByPrimaryKey(userId);
	}

	@Override
	public int insert(User record) {
		try {
			int r=ud.insert(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		//return ud.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		try {
			int r=ud.insertSelective(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		List<User> t=ud.selectByExample(example);
		sqlSession.close();
		return t;
	}

	@Override
	public User selectByPrimaryKey(Integer userId) {
		User t=ud.selectByPrimaryKey(userId);
		sqlSession.close();
		return t;
	}

	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		try {
			int r=ud.updateByExampleSelective(record, example);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	@Override
	public int updateByExample(User record, UserExample example) {
		try {
			int r=ud.updateByExample(record, example);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		try {
			int r=ud.updateByPrimaryKeySelective(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int updateByPrimaryKey(User record) {
		try {
			int r=ud.updateByPrimaryKey(record);
			
			sqlSession.commit();//提交
			sqlSession.close();
			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<User> queryPositionAndDepartmentByCondition(User user) {
		List<User> t=ud.queryPositionAndDepartmentByCondition(user);
		sqlSession.close();
		return t;
	}

	@Override
	public User login(String userName, String userPwd) {
		User u =ud.login(userName, userPwd);
		sqlSession.close();
			return u;
	}

}
