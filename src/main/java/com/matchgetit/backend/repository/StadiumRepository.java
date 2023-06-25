package com.matchgetit.backend.repository;

import com.matchgetit.backend.entity.StadiumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<StadiumEntity,Integer> {
}
