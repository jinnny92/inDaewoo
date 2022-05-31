package kr.co.dw.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.dw.service.reply.ReplyService;

@Component
@Aspect 
public class TestAdvice {
//	@Autowired
//		private ReplyService rService;
//	
//	@Around("execution(* kr.co.dw.service.board.BoardService*.delete*(..))")
//	public Object deleteReply(ProceedingJoinPoint pjp) throws Throwable {
//	
//		  Object[] arr =  pjp.getArgs();
//	      int bno = (int)arr[0];{
//	         
//	      
//	      rService.deleteByBno(bno);
//	      }
//	      Object obj = pjp.proceed();
//	      
//	      return obj;
//	}

	
	
	@Before("execution(* kr.co.dw.service.test.TestService*.*(..))")
	public void strat(JoinPoint jp) { 
		System.out.println("^^^^^^^^^");
		
		Object[] arr = jp.getArgs();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

	
	@Around("execution(* kr.co.dw.service.test.TestService*.*(..))")
	public Object testTime(ProceedingJoinPoint pjp) throws Throwable {
		//@Around는 반환형이 반드시 Object가 되어야 한다
		//무조건 매개변수를 집어 넣어야 한다 ProceedingJoinPoint -> 어떤게 앞에 진행되는지 어떤게 뒤에 진행되는지 구분해줌
		//Proceeding 뭔가 진행중이라는 뜻
		
		long before = System.currentTimeMillis();
		
		Object obj = pjp.proceed(); //얘는 throws씀 Throwable 얘가 입셉션보다 더 위에 있음
		
		long after = System.currentTimeMillis();
		
		System.out.println(after - before);
		
		return obj;
		}
	
	
	
	}
	
