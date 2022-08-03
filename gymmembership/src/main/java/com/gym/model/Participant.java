package com.gym.model;


/*
  create table Participant (
  pid int primary key auto_increment,
  name varchar(200),
  phone varchar(20), 
  email varchar(100),
  bid int)
    
 * 
 */



public class Participant<GenericBatch> {
	
	public int pId;
	public String name;
	public String phone;
	public String email;
	public int bId;

	public Participant() {}

	public Participant(int pId, String name, String phone, String email, int bId) {
		super();
		this.pId = pId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.bId = bId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	@Override
	public String toString() {
		return "Participant [pId=" + pId + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", bId=" + bId + "]";
	};
	
	public class GenericBatchId<T> {
		
		private T batchclass;
		public void setBatchId(T bc) {
			this.batchclass = bc;
		}
		
		public T getBatchId() {
			return this.batchclass;
		}
	}
	
	
}
