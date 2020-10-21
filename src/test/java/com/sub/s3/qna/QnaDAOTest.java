package com.sub.s3.qna;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sub.s3.MyTestCase;

public class QnaDAOTest extends MyTestCase{
	
	@Autowired
	private QnaDAO qnaDAO;

	//@Test
//	   public void qnaInsertTest() throws Exception {
//	      System.out.println("Insert");
//	      for(int i=73; i<253; i++) {
//	         QnaDTO qnaDTO = new QnaDTO();
//	         qnaDTO.setTitle("Title"+i);
//	         qnaDTO.setWriter("Writer"+i);
//	         qnaDTO.setContents("Contents"+i);
//	         int result = qnaDAO.qnaWrite(qnaDTO);
//	         
//	         if(i%10 == 0) {
//	            Thread.sleep(1000);
//	            
//	         }
//	      }
//	      
//	      
//	   }
	   
//	   @Test
//	   public void qnaInsertTest() throws Exception {
//		         QnaDTO qnaDTO = new QnaDTO();
//		         qnaDTO.setTitle("test Title");
//		         qnaDTO.setWriter("test Writer");
//		         qnaDTO.setContents("Contents");
//		         int result = qnaDAO.qnaWrite(qnaDTO);
//		         assertNotEquals(0, result);
//		 
//		      }
	//@Test
	public void qnaReplyTest() throws Exception {
	      
	      
	      //답글
	      QnaDTO child = new QnaDTO();
	      child.setTitle("Test Reply Title 2_2_1");
	      child.setWriter("Test Reply Writer 2_2_1");
	      child.setContents("Test Reply Contents 2_2_1");
	      
	      
	      //부모글 정보
	      QnaDTO parent = qnaDAO.qnaSelect(22);

	      
	      //update
	      
	      qnaDAO.qnaUpdate(parent);
	      
	      
	      //ref는 부모의 ref
	      child.setRef(parent.getRef());
	      child.setStep(parent.getStep()+1);
	      child.setDepth(parent.getDepth()+1);
	      
	      
	      int result = qnaDAO.qnaReply(child);
	      assertNotEquals(0, result);
	      //assertNotNull(parent);
	      
	   }
		  
	
	
		      
}
