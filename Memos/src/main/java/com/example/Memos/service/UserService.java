package com.example.Memos.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Memos.domain.User;
import com.example.Memos.dto.AddUserRequest;
import com.example.Memos.dto.AddUserResponse;
import com.example.Memos.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;

	private User requestToEntity(AddUserRequest dto) {
		String password = bcryptPasswordEncoder.encode(dto.getPassword()); // 나중에 암호화 예정
		return new User(dto.getUsername(), password, "user");
	}

	private AddUserResponse entityToResponse(User user) {
		return new AddUserResponse(user.getUsername(), "ok");
	}

	public AddUserResponse addUser(AddUserRequest dto) {
		User result = userRepository.save(requestToEntity(dto));
		return entityToResponse(result);
	}
	
	public User findById(String id) {
		return userRepository.findById(id).orElseGet(null);
	}
}
