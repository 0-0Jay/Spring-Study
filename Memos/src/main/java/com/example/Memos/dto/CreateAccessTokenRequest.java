package com.example.Memos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccessTokenRequest {
	private String username;
	private String password;
	private String refreshToken;
}
