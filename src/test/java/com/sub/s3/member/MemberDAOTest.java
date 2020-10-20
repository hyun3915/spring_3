package com.sub.s3.member;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sub.s3.MyTestCase;

public class MemberDAOTest extends MyTestCase{
	
	@Autowired
	private MemberDAO memberDAO;

	//@Test
	public void memberSelectTest() throws Exception{
		MemberDTO memberDTO = memberDAO.memberSelect(6);
		System.out.println(memberDTO.getName());
		
		assertNotNull(memberDTO);
	}
	
	//@Test
	   public void memberInsertTest() throws Exception {
	      System.out.println("Insert");
	      for(int i=61; i<100; i++) {
	         MemberDTO memberDTO = new MemberDTO();
	         memberDTO.setId("Id"+i);
	         memberDTO.setPw("Pw"+i);;
	         memberDTO.setName("Name"+i);
	         memberDTO.setEmail("Email"+i);
	         int result = memberDAO.memberJoin(memberDTO);
	         
	         if(i%10 == 0) {
	            Thread.sleep(1000);
	            
	         }
	      }
	      
	      
	   }

}
