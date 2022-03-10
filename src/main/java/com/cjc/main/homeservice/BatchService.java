package com.cjc.main.homeservice;

import java.util.List;

import com.cjc.main.model.Batch;

public interface BatchService {

	Batch createBatch(Batch batch);

	List<Batch> getbatchdata();

	boolean deletebatch(int id);

	Batch upadatebatch(int id, Batch batch);
	
	public Batch findBatchUsingBatchName(String batchName); 

}
