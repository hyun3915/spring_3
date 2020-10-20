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
	   public void qnaInsertTest() throws Exception {
	      System.out.println("Insert");
	      for(int i=73; i<253; i++) {
	         QnaDTO qnaDTO = new QnaDTO();
	         qnaDTO.setTitle("Title"+i);
	         qnaDTO.setWriter("Writer"+i);
	         qnaDTO.setContents("Contents"+i);
	         int result = qnaDAO.qnaWrite(qnaDTO);
	         
	         if(i%10 == 0) {
	            Thread.sleep(1000);
	            
	         }
	      }
	      
	      
	   }

}
