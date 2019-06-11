package com.woniu.web.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.woniu.web.entity.User;
import com.woniu.web.util.HibernateUtils;

public class AppTest {
	@Test
	public void testSave() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		User user = new User();
		user.setName("桂花");
		user.setBrithday(new java.sql.Date(new Date().getTime()));
		user.setMoney(3000d);
		user.setPhoto("photo");
		s.save(user);
		
		
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testDelete() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		User user = new User();
		user.setId(98);
		s.delete(user);
		
		
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testUpdate() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		User user = new User();
		user.setId(99);
		user.setName("王桂花");
		s.update(user);
		
		
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testFindOne() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		User user = (User) s.get(User.class,99);
		System.out.println(user);
		
		s.getTransaction().commit();
		s.close();
	}
	@Test
	public void testFindAll() throws Exception {
		Session s = HibernateUtils.openSession();
		s.beginTransaction();
		
		
		String hql = "FROM User";
		Query q = s.createQuery(hql);
		List<User> list = q.list();
		for (User user : list) {
			System.out.println(user);
		}
		
		s.getTransaction().commit();
		s.close();
	}
}
