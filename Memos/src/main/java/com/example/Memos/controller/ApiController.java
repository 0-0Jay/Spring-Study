package com.example.Memos.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Memos.dto.AddUserRequest;
import com.example.Memos.dto.AddUserResponse;
import com.example.Memos.dto.CreateAccessTokenRequest;
import com.example.Memos.dto.CreateAccessTokenResponse;
import com.example.Memos.dto.GetMemoResponse;
import com.example.Memos.service.MemoService;
import com.example.Memos.service.TokenService;
import com.example.Memos.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
	private final MemoService memoService;
	private final UserService userService;
	private final TokenService tokenService;

	@PostMapping("/join")
	public AddUserResponse postJoin(@RequestBody AddUserRequest request) {
		AddUserResponse response = userService.addUser(request);
		return response;
	}

	@PostMapping("/signin")
	public ResponseEntity<CreateAccessTokenResponse> postSignin(@RequestBody CreateAccessTokenRequest request) {
		try {
			CreateAccessTokenResponse response = tokenService.createAccessToken(request);
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(403).body(null);
		}
	}

	@PostMapping("/token")
	public ResponseEntity<CreateAccessTokenResponse> postToken(@RequestBody CreateAccessTokenRequest request) {
		try {
			CreateAccessTokenResponse response = tokenService.createAccessToken(request);
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(403).body(null);
		}
	}

	@GetMapping("/memos")
	public List<GetMemoResponse> getMemos(Principal user) {
		return memoService.getMemosByUser(user.getName());
	}
}