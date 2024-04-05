package com.example.hello;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class WebController {
	
	private final MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/members")
	public String getMembers(@RequestParam(name="name", required=false) String name, Model model) {
		if (name == null) model.addAttribute("members", memberService.getMembers());
		else model.addAttribute("members", memberService.getMemberByName(name));
		
		return "members";
	}
	
	@GetMapping("/member/{id}")
	public String getMemberById(@PathVariable("id") int id, Model model) {
		model.addAttribute("member", memberService.getMemberById(id));
		return "member";
	}
	
	@GetMapping("/form") 
		public String form() { 
		return "form"; 
	} 
	
	@PostMapping("/processForm")
	public String processForm(@RequestParam("id") int id, @RequestParam("name") String name, Model model) { 
		model.addAttribute("id", id); 
		model.addAttribute("name", name); 
		return "result"; 
	} 
}
