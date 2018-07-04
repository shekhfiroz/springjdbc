package com.qa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.qa.dao.CompanyDao;

public class QaTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/qa/common/application-context.xml");
		CompanyDao cdao = context.getBean("companydoa", CompanyDao.class);
		/*
		  int company_count = cdao.CountOfCompany();
		  System.out.println("Total No Of Company Count => " + company_count);
		  String returned_comapny_name=cdao.getCompanyName(3);
		  System.out.println(returned_comapny_name);
		 */
	}

}
