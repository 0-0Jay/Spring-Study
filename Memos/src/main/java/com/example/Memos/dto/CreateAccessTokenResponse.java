package com.example.Memos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateAccessTokenResponse {
	private String accessToken;
	private String refreshToken;
}
