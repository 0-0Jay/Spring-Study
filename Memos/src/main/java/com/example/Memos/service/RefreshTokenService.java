package com.example.Memos.service;

import org.springframework.stereotype.Service;
import com.example.Memos.domain.RefreshToken;
import com.example.Memos.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
	private final RefreshTokenRepository repository;

	public RefreshToken findByRefreshToken(String refreshToken) {
		return repository.findByRefreshToken(refreshToken).orElseThrow(() -> new IllegalArgumentException());
	}

	public RefreshToken findByUsername(String username) {
		return repository.findByUsername(username).orElseGet(() -> new RefreshToken(null, username, null));
	}

	public RefreshToken save(RefreshToken refreshToken) {
		return repository.save(refreshToken);
	}
}