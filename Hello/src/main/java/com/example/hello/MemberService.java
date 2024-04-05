package com.example.hello;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.*;
import com.example.hello.*;

@Service
public class MemberService {
	private List<Member> members;

	public MemberService() {
		members = new ArrayList<Member>();
		for (int i = 1; i <= 4; i++) members.add(new Member(i, "member" + i));
	}
	
	public List<Member> getMembers() {
		return members;
	}
	
	public Member getMemberById(int id) {
		return members.stream().filter(member -> member.getId() == id).findFirst().get();
	}
	
	public List<Member> getMemberByName(String name) {
		return members.stream().filter(member -> member.getName().contains(name)).collect(Collectors.toList());
	}
}
