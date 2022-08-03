package com.gym.model;


/*
 create table Batch (
  bid int primary key auto_increment,
  batchname varchar(100),
  preferredTime varchar(100), 
  slot varchar(5)
  );
  */

public class Batch {
	
	int bId;
	public String batchname;
	public String preferredTime;
	public String slot;
	
	
	public Batch() {};
	
	public Batch(int bId, String batchname, String preferredTime, String slot) {
		//super();
		this.bId = bId;
		this.batchname = batchname;
		this.preferredTime = preferredTime;
		this.slot = slot;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Batch [bId=" + bId + ", batchname=" + batchname + ", preferredTime=" + preferredTime + ", slot=" + slot
				+ "]";
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getBatchname() {
		return batchname;
	}

	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}

	public String getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(String preferredTime) {
		this.preferredTime = preferredTime;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}


	
	
	

}
