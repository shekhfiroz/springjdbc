package com.classicapproch.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.classicapproch.bo.Companybo;
import com.classicapproch.dao.CompanyDao;

public class ClassicApprochTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/classicapproch/common/application-context.xml");
		CompanyDao cdao = context.getBean("companydao", CompanyDao.class);
		List<Companybo> companyname_returned = cdao.findCompnyByName("durgasoft");
		for (Companybo companybo : companyname_returned) {
			System.out.println(companybo);
		}
		((AbstractApplicationContext) context).close();
	}

}
