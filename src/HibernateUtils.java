

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 */
public class HibernateUtils {

    /** 
     * Location of hibernate.cfg.xml file.
     * Location should be on the classpath as Hibernate uses  
     * #resourceAsStream style lookup for its configuration file. 
     * The default classpath location of the hibernate config file is 
     * in the default package. Use #setConfigFile() to update 
     * the location of the configuration file for the current session.   
     */
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private  static Configuration configuration = new Configuration();    
    private static org.hibernate.SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;

	static {
    	try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
    }
    private HibernateUtils() {
    }
	
	/**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     *  @return Session
     *  @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}

        return session;
    }

	/**
     *  Rebuild hibernate session factory
     *
     */
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	/**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

	/**
     *  return session factory
     *
     */
	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
     *  return session factory
     *
     *	session factory will be rebuilded in the next call
     */
	public static void setConfigFile(String configFile) {
		HibernateUtils.configFile = configFile;
		sessionFactory = null;
	}

	/**
     *  return hibernate configuration
     *
     */
	public static Configuration getConfiguration() {
		return configuration;
	}
	/**
	 * 添加任何对象
	 */
	public static void add(Object obj){
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		try {
			if(obj!=null)
				session.save(obj);
		} catch (HibernateException e) {
			// TODO: handle exception
			tran.rollback();
			e.printStackTrace();
		}
		tran.commit();
		HibernateUtils.closeSession();
	}
/**
 * 更新对象
 */
	public static void update(Object obj){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			if(obj!=null)
				session.update(obj);
			
		} catch (HibernateException  e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}
		transaction.commit();
		HibernateUtils.closeSession();
	}
	/**
	 * 删除对象
	 */
	public static void delete(Object obj){
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		try {
			if (obj!=null) {
				session.delete(obj);
			}
		} catch (HibernateException e) {
			// TODO: handle exception
			trans.rollback();
			e.printStackTrace();
		}
		trans.commit();
		HibernateUtils.closeSession();
	}
	
	/**
	 * 根据id和class删除一条信息
	 * @param classs
	 * @param id
	 * @return
	 */
	public static Object getOneObject(Class<?> classs,Serializable id){
		Session session  = HibernateUtils.getSession();
		//Transaction transaction = session.beginTransaction();
		Object obj=session.get(classs,id);
		//transaction.commit();
		HibernateUtils.closeSession();
		if (obj!=null) {
			return obj;
		}else{
			return null;
		}
	}
	/**
	 * 得到一个表的全部信息
	 * @param classs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<?> getObjects(Class<?> classs){
		Session session = HibernateUtils.getSession();
		//Transaction trans = session.beginTransaction();
		Criteria criteria = session.createCriteria(classs);
		List<Class<?>> userlistList = criteria.list();
		HibernateUtils.closeSession();
		//System.out.println(userlistList.isEmpty());
		if(!userlistList.isEmpty()){
			return userlistList;
		}else {
			return null;
		}
		
	}
	
	
	
	/**
	 * 根据用户id判断一个用户是否存在，若存在返回用户对象，否则返回null
	 */
	/*public static Object get(Class classs,Serializable id){
		Session session = HibernateUtils.getSession();
		
	}*/
}
