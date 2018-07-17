package com.hql.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.hql.entity.Book;
import com.hql.util.HibernateUtil;

public class BookDao {

	private static Logger logger = Logger.getLogger(BookDao.class);
	
	public BookDao() {
		logger.info("*****************BookDao:Constructor*************************");
	}

	/**
	 * This method is used to get BookName,BookPrice and AuthorName using given
	 * BookId
	 * 
	 * @param bookId
	 */
	public void findBookDetailsByBookId(Integer bookId) {

		logger.info("*******Execution started*********");

		Session hs = HibernateUtil.getSf().openSession();
		StringBuffer hql = new StringBuffer();
		hql.append("select b.bookName,");
		hql.append("  b.bookPrice, ");
		hql.append("  a.authorName ");
		hql.append("FROM Book b , ");
		hql.append("  Author a ");
		hql.append("WHERE a.authorId=b.authorId ");
		hql.append("AND b.bookId    =:bid");

		Query query = hs.createQuery(hql.toString());
		query.setParameter("bid", bookId);

		List<Object[]> list = query.getResultList();
		if (!list.isEmpty()) {
			for (Object[] objArr : list) {
				System.out.println(objArr[0] + "--" + objArr[1] + "--"
						+ objArr[2]);
			}
		}
		hs.close();
		logger.info("*******Execution completed*********");
	}

	/**
	 * This method is used to get BookName,BookPrice and authorName using given
	 * AuthorId
	 * 
	 * @param authorId
	 */
	public void findBookDetailsByAuthorId(Integer authorId) {
		logger.info("*******Execution started*********");
		Session hs = HibernateUtil.getSf().openSession();

		StringBuffer hql = new StringBuffer();
		hql.append("select b.bookName,");
		hql.append("  b.bookPrice, ");
		hql.append("  a.authorName ");
		hql.append("FROM Book b , ");
		hql.append("  Author a ");
		hql.append("WHERE a.authorId=b.authorId ");
		hql.append("AND a.authorId=:aid");

		Query query = hs.createQuery(hql.toString());
		query.setParameter("aid", authorId);

		List<Object[]> list = query.getResultList();
		if (!list.isEmpty()) {
			logger.info("*******Returned records : " + list.size()
					+ "*********");
			for (Object[] objArr : list) {
				System.out.println(objArr[0] + "--" + objArr[1] + "--"
						+ objArr[2]);
			}
		}
		hs.close();
		logger.info("*******Execution started*********");
	}

	/**
	 * This method is used to get Highest Price Book record
	 */
	public void findMaxPriceBook() {
		logger.info("*******Execution started*********");
		Session hs = HibernateUtil.getSf().openSession();

		StringBuffer hql = new StringBuffer();
		hql.append("from Book where bookPrice in (select max(bookPrice) from Book) ");

		Query query = hs.createQuery(hql.toString());

		List<Book> list = query.getResultList();
		if (!list.isEmpty()) {
			for (Book b : list) {
				System.out.println(b);
			}
		}
		hs.close();
		logger.info("*******Execution started*********");
	}

	/**
	 * This method is used to get Highest Price Book record
	 */
	public void findSecondHighestPriceBook() {
		logger.info("*******Execution started*********");
		Session hs = HibernateUtil.getSf().openSession();
		StringBuffer hql = new StringBuffer();
		hql.append("from Book where bookPrice in (select max(bookPrice) from Book where bookPrice not in (select max(bookPrice) from Book)) ");
		Query query = hs.createQuery(hql.toString());
		List<Book> list = query.getResultList();
		if (!list.isEmpty()) {
			for (Book b : list) {
				System.out.println(b);
			}
		}
		hs.close();
		logger.info("*******Execution started*********");
	}

}
