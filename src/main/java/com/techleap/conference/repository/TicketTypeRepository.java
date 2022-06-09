package com.techleap.conference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techleap.conference.model.TicketType;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, String> {
	public List<TicketType> findByIncludesWorkshopTrue();
}
