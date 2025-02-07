package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.AvatarEntity;

@Repository
public interface AvatarRepository extends JpaRepository<AvatarEntity, Long> {

	AvatarEntity findByEmployeeId(Long id);
	
	//void deleteByEmployeeId(Long id); //почему-то не заработал такой запрос
	
	//@Modifying(clearAutomatically = true)
	//@Query(value="delete from avatars where employee_id=(:avatarId)",nativeQuery=true)
	//public void deleteAvatarByEmployeeId(@Param("avatarId") Long avatarId); //этот запрос вроде один раз сработал и потом тоже нет. Не понял в чем проблема.
	
}
