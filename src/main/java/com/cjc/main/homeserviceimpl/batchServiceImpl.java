package com.cjc.main.homeserviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cjc.main.homerepository.batchRepository;
import com.cjc.main.homeservice.BatchService;
import com.cjc.main.model.Batch;

@Service
public class batchServiceImpl implements BatchService  {
	
	private static final Logger logger = LoggerFactory.getLogger(batchServiceImpl.class);
	
	@Autowired
	batchRepository batchrepository;

	@Override
	public Batch createBatch(Batch batch) {
		
		logger.info("Creating a new Batch"+batch);
		if(batch!=null) {
			Batch batch1=batchrepository.save(batch);
			return batch1;
		}else {
			return new Batch();
		}
	}

	@Override
	public List<Batch> getbatchdata() {
		
		List<Batch> lst=batchrepository.findAll();
	
		return lst;
	}

	@Override
	public boolean deletebatch(int id) {
		boolean deleteFlag=false;
		try {
			logger.info("in try block of delete batch servvice");
			batchrepository.deleteById(id);
			deleteFlag=true;
			return deleteFlag;
		}catch(Exception e) {
			logger.info("in catch block of delete batch"+e.getMessage());
			return deleteFlag;
		}
	}

	@Override
	public Batch upadatebatch(int id, Batch batch) {
		
		Batch batch1=batchrepository.save(batch);
		
		return batch1;
	}

	//This method is used to fetch the Batch Information using the batch Name
	@Override
	public Batch findBatchUsingBatchName(String batchName) {	
		return batchrepository.findAllByBatchname(batchName);
	}

}
