package com.sub.s3.notice;

import java.lang.ProcessBuilder.Redirect;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sub.s3.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "noticeUpdate", method=RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		System.out.println(noticeDTO.getTitle());
		System.out.println(noticeDTO.getContents());
		int result = noticeService.noticeUpdate(noticeDTO);
		System.out.println("Result : "+result);
		ModelAndView mv = new ModelAndView();
		if(result>0) {
			mv.addObject("msg","Update Success");
		}else {
			mv.addObject("msg","Update Fail");
		}
		
		mv.addObject("path","./noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate")
	public void noticeUpdate(NoticeDTO noticeDTO, Model model) throws Exception {
		//글번호 출력
		
		//글제목, 글 내용 출력
		noticeDTO = noticeService.noticeSelect(noticeDTO.getNum());
		model.addAttribute("dto",noticeDTO);
	}
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView noticeDelete(long num) throws Exception{
		System.out.println("Notice Delete");
		int result = noticeService.noticeDelete(num);
		String message = "Delete Fail";
		
		if(result>0) {
			message = "Delete Success";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("msg",message);
		mv.addObject("path", "./noticeList");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeSelect")
	public void noticeSelect(long num, Model model) throws Exception {
		System.out.println("noticeSelect");
		NoticeDTO noticeDTO = noticeService.noticeSelect(num);
		model.addAttribute("dto", noticeDTO);
	}
	
	
	@RequestMapping(value = "noticeWrite")
	public void noticeWrite() {

	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO) throws Exception{
			int result = noticeService.noticeWrite(noticeDTO);
			System.out.println("Result : "+result);
			
			return "redirect:./noticeList";
	}
	
	@RequestMapping(value = "noticeList")
	public ModelAndView noticeList(Pager pager) throws Exception {
		
		System.out.println("kind : "+pager.getKind());
		System.out.println("search : "+pager.getSearch());
		
		System.out.println("notice List");
		ModelAndView mv = new ModelAndView();
		
		//pager.makeRow();
		//pager.setLastRow(curPage*10);
		//pager.setStartRow((curPage-1)*10+1);
		
		List<NoticeDTO> ar = noticeService.noticeList(pager);
		
		//******페이징 계산******
//		System.out.println("total count : "+ pager.getTotalCount());
//		
//		//1. 전체 글의 갯수 조회
//		long totalCount = pager.getTotalCount();
//		
//		//2. 전체 페이지의 갯수
//		long totalPage = totalCount/10;
//		if(totalCount%10 != 0) {
//			totalPage++;
//		}
//		
//		//3. 전체 블럭의 갯수 구하기
//		long totalBlock = totalPage/5;
//		if(totalPage%5 != 0) {
//			totalBlock++;
//		}
//		
//		//4. curPage를 이용해서 현재 블럭번호 찾기
//		long curBlock = curPage/5;
//		if(curPage%5 !=0) {
//			curBlock++;
//		}
//		
//		//5. 현재블럭번호로 시작번호 끝 번호 계산
//		long startNum = (curBlock-1)*5+1;
//		long lastNum = curBlock*5;
//		
//		//6. 현재블럭번호와 전체 블럭번호가 같은지 결정
//		boolean nextCheck=true;
//		if(curBlock == totalBlock) {
//			nextCheck = !nextCheck;
//			lastNum = totalPage;
//		}
//		
//		boolean beforeCheck = true;
//		if(curBlock ==1 ) {
//			beforeCheck =!beforeCheck;
//		}
				
		//******************************************
		mv.addObject("lists",ar);
		mv.addObject("pager", pager);
//		mv.addObject("startNum", startNum);
//		mv.addObject("lastNum", lastNum);
//		mv.addObject("beforeCheck", beforeCheck);
//		mv.addObject("nextCheck", nextCheck);
		mv.setViewName("notice/noticeList");
		
		return mv;
	}

}
