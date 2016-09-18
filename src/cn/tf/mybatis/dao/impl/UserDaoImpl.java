package cn.tf.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.tf.mybatis.dao.UserDao;
import cn.tf.mybatis.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport  implements  UserDao{

	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession  sqlSession=null;
		User user = null;
		try{
			sqlSession = this.getSqlSession();
			user = sqlSession.selectOne("test.findUserById", 1);

			System.out.println(user);

		} catch (Exception e) {
			
		}
		return user;
	}


	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession  sqlSession=null;
		List<User> list = null;
		try{
			sqlSession = this.getSqlSession();
			list = sqlSession.selectList("test.findUserByName", name);

			System.out.println(list);

		} catch (Exception e) {
			
		}
		return list;
	}


	@Override
	public void insertUser(User user) throws Exception {
		SqlSession  sqlSession=null;
		
		try{
			sqlSession = this.getSqlSession();
			
			 sqlSession.insert("test.insertUser", user);

			System.out.println(user.getId());
			sqlSession.commit();
		} catch (Exception e) {
			
		}
		

	}


	@Override
	public void updateUser(User user) throws Exception {
		
		SqlSession  sqlSession=null;
	
		try{
			sqlSession = this.getSqlSession();
			
			 sqlSession.update("test.updateUser", user);

			System.out.println(user.getId());
			sqlSession.commit();
		} catch (Exception e) {
			
		}
	}
	
	

}
