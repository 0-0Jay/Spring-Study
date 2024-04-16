package com.example.Memos.service;

import java.time.Duration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Memos.config.JwtProperties;
import com.example.Memos.domain.RefreshToken;
import com.example.Memos.domain.User;
import com.example.Memos.dto.CreateAccessTokenRequest;
import com.example.Memos.dto.CreateAccessTokenResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TokenService {
	private final JWTokenProvider tokenProvider;
	private final RefreshTokenService refreshTokenService;
	private final UserService userService;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	private final JwtProperties jwtProperties;

	public CreateAccessTokenResponse createAccessToken(CreateAccessTokenRequest request) {
// Create Access Token and refresh token by username and password
		if (request.getUsername() != null && request.getPassword() != null) {
			User user = userService.findById(request.getUsername());
			if (bcryptPasswordEncoder.matches(request.getPassword(), user.getPassword())) {
				return new CreateAccessTokenResponse(
						tokenProvider.createToken(user, Duration.ofMinutes(jwtProperties.getDuration())),
						createRefreshToken(user));
			}
		}
// Create Access token by refresh token
		else if (request.getRefreshToken() != null) {
			if (tokenProvider.isValidToken(request.getRefreshToken())) {
				String username = refreshTokenService.findByRefreshToken(request.getRefreshToken()).getUsername();
				User user = userService.findById(username);
				return new CreateAccessTokenResponse(
						tokenProvider.createToken(user, Duration.ofMinutes(jwtProperties.getDuration())), null);
			}
		}
		throw new IllegalArgumentException("Invalid password");
	}

	public String createRefreshToken(User user) throws IllegalArgumentException {
		String token = tokenProvider.createToken(user, Duration.ofHours(jwtProperties.getRefreshDuration()));
		RefreshToken refreshToken = refreshTokenService.findByUsername(user.getUsername());
		refreshToken.setRefreshToken(token);
		refreshTokenService.save(refreshToken); // save refresh token
		return token;
	}
}