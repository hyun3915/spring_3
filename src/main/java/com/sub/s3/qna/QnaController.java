package com.sub.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sub.s3.notice.NoticeDTO;
import com.sub.s3.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaList")
	public ModelAndView qnaList(Pager pager) throws Exception{
		
		System.out.println("kind : "+pager.getKind());
		System.out.println("search : "+pager.getSearch());
		
		System.out.println("QnA List");
		ModelAndView mv = new ModelAndView();
		
		List<QnaDTO> ar = qnaService.qnaList(pager);
		
		mv.addObject("lists", ar);
		mv.addObject("pager", pager);
		mv.setViewName("qna/qnaList");
		
		return mv;
		
	}
	
	@RequestMapping(value = "qnaWrite")
	public void qnaWrite() {
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public String qnaWrite(QnaDTO qnaDTO) throws Exception{
			int result = qnaService.qnaWrite(qnaDTO);
			System.out.println("Result : "+result);
			
			return "redirect:./qnaList";
	}
	
	@RequestMapping(value = "qnaUpdate", method=RequestMethod.POST)
	public ModelAndView qnaUpdate(QnaDTO qnaDTO) throws Exception{
		System.out.println(qnaDTO.getTitle());
		
		int result = qnaService.qnaUpdate(qnaDTO);
		System.out.println("Result : "+result);
		ModelAndView mv = new ModelAndView();
		
		if(result>0) {
			mv.addObject("msg","Update Success");
		}else {
			mv.addObject("msg","Update Fail");
		}
		
		mv.addObject("path","./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate")
	public void qnaUpdate(QnaDTO qnaDTO, Model model) throws Exception{
		
		qnaDTO = qnaService.qnaSelect(qnaDTO.getNum());
		model.addAttribute("dto", qnaDTO);
		
	}
	
	@RequestMapping(value="qnaSelect")
	public void qnaSelect(long num, Model model) throws Exception{
		System.out.println("QnA Select");
		QnaDTO qnaDTO = qnaService.qnaSelect(num);
		model.addAttribute("dto", qnaDTO);
	}
	
	@RequestMapping(value = "qnaDelete")
	public ModelAndView qnaDelete(long num) throws Exception{
		System.out.println("QnA Delete");
		int result = qnaService.qnaDelete(num);
		
		String message = "Delete Fail";
		
		if(result>0) {
			message = "Delete Success";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("msg",message);
		mv.addObject("path", "./qnaList");
		
		return mv;
		
	}
	
	
}
