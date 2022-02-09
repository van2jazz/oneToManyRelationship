package com.dayo.demo.dao;

import com.dayo.demo.entity.Awards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardsDao extends JpaRepository<Awards, Long> {
}
