package com.github.mtlibano.repository;

import com.github.mtlibano.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {

}