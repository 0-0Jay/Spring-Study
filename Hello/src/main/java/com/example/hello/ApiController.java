package com.example.hello;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import lombok.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
	private final MemberService memberService;
	
	@GetMapping("/members")
	public List<Member> getMembers(@RequestParam(name="name", required=false) String name) {
		if (name == null) return memberService.getMembers();
		return memberService.getMemberByName(name);
	}
	
	@GetMapping("/members/{id}")
	public Member getMemberById(@PathVariable("id") int id) {
		return memberService.getMemberById(id);
	}
}
