package com.example.Memos.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Memos.domain.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {

	Collection<Memo> findByUser_usernameOrderByCreatedAtDesc(String username);

}
