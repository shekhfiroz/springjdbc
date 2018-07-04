package com.qa.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qa.bo.Companybo;
import com.qa.dao.CompanyDao;

public class QaTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/qa/common/application-context.xml");
		CompanyDao cdao = context.getBean("companydoa", CompanyDao.class);
		/*
		 * int company_count = cdao.CountOfCompany();
		 * System.out.println("Total No Of Company Count => " + company_count);
		 * 
		 * String returned_comapny_name=cdao.getCompanyName(3);
		 * System.out.println(returned_comapny_name);
		 * 
		 * Companybo complete_rowreturned=cdao.getCompanyRowObject(2);
		 * System.out.println(complete_rowreturned);
		 * 
		 * List <Companybo> allrecords =cdao.getAllCompanyRecords();
		 * System.out.println(allrecords);
		 * 
		 */
		    int recordinserted=cdao.insertrecords(4, "google internet", "internet company", "2001","california");
		    System.out.println("Nos of records inserted =>"+recordinserted);
		
		
	}

}
