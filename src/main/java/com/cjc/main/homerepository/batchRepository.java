package com.cjc.main.homerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Batch;

@Repository
public interface batchRepository extends JpaRepository<Batch, Integer> {

	public Batch findAllByBatchname(String batchName);
}
