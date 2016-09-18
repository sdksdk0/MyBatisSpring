package cn.tf.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tf.mybatis.dao.UserDao;
import cn.tf.mybatis.mapper.UserMapper;
import cn.tf.mybatis.po.User;

public class UserTest {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception{
		applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");

	}
	@Test
	public void test1() throws Exception{
		UserDao userDao=(UserDao) applicationContext.getBean("userDao");
		
		User user=userDao.findUserById(1);
		System.out.println(user);

	}
	
	
	@Test
	public void test2() throws Exception{
		UserMapper userMapper=(UserMapper) applicationContext.getBean("userMapper");
		User user=userMapper.findUserById(1);
		System.out.println(user);
	}
	
	
}
