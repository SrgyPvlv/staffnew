package com.example.staff.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.staff.entity.RefreshToken;
import com.example.staff.entity.Users;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

	Optional<RefreshToken> findByToken(String token);

	int deleteByUser(Users user);
}
