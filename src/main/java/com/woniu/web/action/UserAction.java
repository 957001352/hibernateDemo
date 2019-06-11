package com.woniu.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.woniu.web.entity.User;
import com.woniu.web.util.HibernateUtils;

public class UserAction {
	public String find() {
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
		ServletActionContext.getRequest().setAttribute("list",list);
		return "findUI";
	}
}
