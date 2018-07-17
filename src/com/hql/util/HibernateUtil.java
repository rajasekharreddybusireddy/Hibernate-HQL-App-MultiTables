package com.hql.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Logger logger = Logger.getLogger(HibernateUtil.class);

	// Don't remove
	private HibernateUtil() {
		logger.info("****************HibnerateUtil:Instantiation completed**********");
	}

	private static SessionFactory sf = null;

	/**
	 * This method is used to create only one session-factory obj
	 * 
	 * @return
	 */
	public static SessionFactory getSf() {
		logger.info("************SessionFactory creation started************");
		if (sf == null) {
			Configuration cfg = new Configuration();
			cfg.configure();
			sf = cfg.buildSessionFactory();
		}
		logger.info("************SessionFactory creation completed************");
		return sf;
	}

	/**
	 * This method is used to close the session-factory
	 */
	public static void closeSf() {
		if (sf != null) {
			sf.close();
		}
		logger.info("**************SessionFactory got closed************");
	}
}
