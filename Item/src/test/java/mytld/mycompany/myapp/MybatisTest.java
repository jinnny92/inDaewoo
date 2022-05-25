package mytld.mycompany.myapp;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MybatisTest {
	
	@Autowired //@Inject 둘중하나 스프링컨테이너가 가지고 있는 
	private SqlSessionFactory ssFactory;
	
	@Test
	public void testSSFactory() {
		System.out.println(ssFactory);
		
		
		
	}

	@Test
	public void testSession() {
		SqlSession sSession = null;
		try {
			sSession = ssFactory.openSession();
			System.out.println(sSession);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sSession != null) {
				sSession.close();
			}
		}
	}
	
}
