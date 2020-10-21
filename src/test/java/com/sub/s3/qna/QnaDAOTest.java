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
	@Test
	public void qnaReqlyTest() throws Exception{
		QnaDTO child = new QnaDTO();
		child.setTitle("test reply Title5");
		child.setWriter("test reply Writer5");
		child.setContents("test reply Contents5");
		
//		int result = qnaDAO.qnaReply(qnaDTO);
        //부모글 정보
        QnaDTO parent = qnaDAO.qnaSelect(257);
        
        //update
        qnaDAO.qnaUpdate(parent);
        
        //부모글의 정보로 답글에 정보를 입력
        
        //ref는 부모의 ref와 같게
        child.setRef(parent.getRef());
        child.setStep(parent.getStep()+1);
        child.setDepth(parent.getDepth()+1);
        
        int result = qnaDAO.qnaReply(child);
	}
		  
	
	
		      
}
