package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.spring.core.beans.User;

public class UserApp {

	public static void main(String[] args) {
	   ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
	   User user1 = context.getBean("user1",User.class);
	   System.out.println(user1);
	   System.out.println("-----------------------------------------------");
	   User user2 = context.getBean("user2",User.class);
	   System.out.println(user2);
	   System.out.println("-----------------------------------------------");
	   User user3 = context.getBean("user3",User.class);
	   System.out.println(user3);
	   System.out.println("-----------------------------------------------");
	   
	   ((ConfigurableApplicationContext)context).close();
	}

}
