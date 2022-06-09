package com.techleap.conference.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techleap.conference.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
	public List<Session> findBySessionNameContains(String name);

	public List<Session> findBySessionLengthNot(Integer sessionLength);

	// Need to add '%' in passed argument
	public List<Session> findBySessionNameNotLike(String name);

	public List<Session> findBySessionNameEndingWith(String name);

	public List<Session> findBySessionLengthLessThanEqual(Integer sessionLength);

	@Query("select s from Session s where s.sessionName like %:sessionName")
	public Page<Session> getSessionsWithName(@Param("sessionName") String sessionName, Pageable pageable);
}
