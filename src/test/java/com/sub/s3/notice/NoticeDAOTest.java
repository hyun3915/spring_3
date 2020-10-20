package com.sub.s3.notice;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NoInitialContextException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sub.s3.notice.NoticeDAO;
import com.sub.s3.notice.NoticeDTO;
import com.sub.s3.util.Pager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})

public class NoticeDAOTest {
   
   
   
   @Autowired
   private NoticeDAO noticeDAO;
   
   
   @BeforeClass
   public static void before() {
      System.out.println("before Class");      
   }
   
   @AfterClass
   public static void after() {
      System.out.println("after Class");      
   }
   
   
   
   //@Before
   public void beforeTest() {
      
      System.out.println("Before Method");
      
   }
   
  //@After
   public void afterTest() {
      
      System.out.println("After Method");
      
   }
   
   
   //noticeDelete
   //@Test
   public void noticeDeleteTest() throws Exception {
      System.out.println("Delete");
      int result = noticeDAO.noticeDelete(3);
     
      assertNotEquals(0, result);
      
   }
   
   
   
   //noticeInsertTest
   //@Test
   public void noticeInsertTest() throws Exception {
      System.out.println("Insert");
      for(int i=0; i<100; i++) {
         NoticeDTO noticeDTO = new NoticeDTO();
         noticeDTO.setTitle("Title"+i);
         noticeDTO.setContents("Contents"+i);
         noticeDTO.setWriter("Writer"+i);
         int result = noticeDAO.noticeWrite(noticeDTO);
         
         if(i%10 == 0) {
            Thread.sleep(1000);
            
         }
      }
      
      
   }
   
   
   
  // @Test
   public void noticeSelectTest() throws Exception {
     System.out.println("Select");
      NoticeDTO noticeDTO = noticeDAO.noticeSelect(4);
      System.out.println(noticeDTO.getTitle());
      
      //단정문
      
   }
   
   //@Test
   public void noticeListTest() throws Exception {
      Pager pager = new Pager();
      
      
      pager.setStartRow(11);
      pager.setLastRow(20);
      List<NoticeDTO> ar = noticeDAO.noticeList(pager);
      assertEquals(10, ar.size());

      noticeDAO.noticeList(pager);
      
   }
   
   //@Test
//   public void noticeCountTest() throws Exception{
//	  long num= noticeDAO.noticeCount();
//	  System.out.println(num);
//   }
   
   
}