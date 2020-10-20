package com.sub.s3.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sub.s3.util.Pager;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberList")
	public ModelAndView memberList(Pager pager) throws Exception{
		
		System.out.println("kind : "+pager.getKind());
		System.out.println("search : "+pager.getSearch());
		
		ModelAndView mv = new ModelAndView();
		
		List<MemberDTO> ar = memberService.memberList(pager);
		
		
		mv.addObject("lists", ar);
		mv.addObject("pager", pager);
		mv.setViewName("member/memberList");
		
		return mv;
	}
	
	@RequestMapping(value = "memberSelect")
	public void memberSelect(long num, Model model) throws Exception{
		System.out.println("Member Select");
		MemberDTO memberDTO = memberService.memberSelect(num);
		model.addAttribute("dto", memberDTO);
	}
	
	@RequestMapping(value="memberJoin")
	public void memberJoin() {
		
	}
	
	@RequestMapping(value="memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO) throws Exception{
		int result = memberService.memberJoin(memberDTO);
		System.out.println("Result : "+result);
		
		return "redirect:./memberList";
		
		}
	
	@RequestMapping(value = "memberUpdate")
	public void memberUpdate(MemberDTO memberDTO, Model model) throws Exception{
		memberDTO = memberService.memberSelect(memberDTO.getNum());
		model.addAttribute("dto", memberDTO);
		
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView memberUpdate(MemberDTO memberDTO) throws Exception{
		int result = memberService.memberUpdate(memberDTO);
		System.out.println("Result : "+result);
		ModelAndView mv = new ModelAndView();
		if(result>0) {
			mv.addObject("msg","Update Success");
		}else {
			mv.addObject("msg","Update Fail");
		}
		
		mv.addObject("path","./memberList");
		mv.setViewName("common/result");
		return mv;
		
	}
	
	@RequestMapping(value = "memberDelete")
	public ModelAndView memberDelete(long num) throws Exception{
		System.out.println("Member Delete");
		int result = memberService.memberDelete(num);
		String message = "Delete Fail!";
		
		if(result>0) {
			message = "Delete Success!";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("msg",message);
		mv.addObject("path", "./memberList");
		
		return mv;
		}
	}
