package com.gym.db;

import java.util.ArrayList;

import com.gym.model.Batch;
import com.gym.model.Participant;

public interface DAO {
	
	void createConnection();
	void closeConnection();

	//Declare methods for Batch
	ArrayList<Batch>  getBatch();
	
	//Declare methods for Participant

	ArrayList<Participant>  getParticipant();
	
	
}
