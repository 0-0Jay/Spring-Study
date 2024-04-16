package com.example.Memos.controller;

import java.security.Principal;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Memos.dto.AddMemoRequest;
import com.example.Memos.dto.AddUserRequest;
import com.example.Memos.dto.AddUserResponse;
import com.example.Memos.dto.FileResponse;
import com.example.Memos.service.FileService;
import com.example.Memos.service.MemoService;
import com.example.Memos.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class WebController {
	private final UserService userService;
	private final MemoService memoService;
	private final FileService fileService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String signIn(@RequestParam(name = "message", required = false) String message, Model model) {
		model.addAttribute("message", message);
		
		return "signin";
	}
	
	@PostMapping("/signin")
	public String logIn() {
		return "memos";
	}

	@GetMapping("/join")
	public String join() {
		return "join";
	}

	@PostMapping("/join")
	public String postJoin(@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes ra) {
		AddUserResponse result = userService.addUser(new AddUserRequest(username, password));
		ra.addAttribute("message", "User Added. Please Sign in.");
		return "redirect:/signin";
	}

	@GetMapping("/memos")
	public String memos(Model model, Principal user) {
		model.addAttribute("memos", memoService.getMemosByUser(user.getName()));
		return "memos";
	}
	
	@PostMapping("/memos")
	public String addMemo(@RequestParam("body") String body, @RequestParam("file") MultipartFile file, Principal user) {
		String savedName = fileService.uploadFile(file);
		
		memoService.addMemo(new AddMemoRequest(body, user.getName(), savedName));
		return "redirect:/memos";
	}
	
	@PostMapping("/memos/delete/{id}")
	public String deleteMemo(@PathVariable("id") Long id) {
		memoService.deleteMemo(id);
		return "redirect:/memos";
	}
	
	@GetMapping("/uploads/{name}")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(@PathVariable("name") String fileName) {
		FileResponse res = fileService.getFile(fileName);
		if (res.getContentType() != null) {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", res.getContentType());
			return new ResponseEntity<>(res.getBytes(), header, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/profile")
	public ResponseEntity<byte[]> getProfile(@PathVariable("name") String fileName) {
		FileResponse res = fileService.getFile(fileName);
		if (res.getContentType() != null) {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", res.getContentType());
			return new ResponseEntity<>(res.getBytes(), header, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}