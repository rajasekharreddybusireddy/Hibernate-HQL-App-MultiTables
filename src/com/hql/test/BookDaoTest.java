package com.hql.test;

import org.apache.log4j.BasicConfigurator;

import com.hql.dao.BookDao;
import com.hql.util.HibernateUtil;

public class BookDaoTest {

	public static void main(String[] args) {

		// Log4j Basic Configuration
		BasicConfigurator.configure();

		BookDao dao = new BookDao();
		// dao.findBookDetailsByBookId(202);
		// dao.findBookDetailsByAuthorId(101);
		// dao.findMaxPriceBook();
		dao.findSecondHighestPriceBook();

		// closing session-factory
		HibernateUtil.closeSf();
	}
}
