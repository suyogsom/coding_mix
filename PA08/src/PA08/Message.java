package PA08;

//add the class template

import java.io.Serializable;
import java.sql.Date;


public class Message implements Serializable {
	
	private int id;
	private String lastName, firstName, mi;
	private String address, city, state; 	
	private int mPhoneNo, hPhoneNo;
	private String mPhoneCarrier, hPhoneCarrier;
	private int opType;
	
	
	public Message(int id, String lastName, String firstFName, String mi, String address, String city, String state,
			int mPhoneNo, int hPhoneNo, String mPhoneCarrier, String hPhoneCarrier, int opType) {
		
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstFName;
		this.mi = mi;
		this.address = address;
		this.city = city;
		this.state = state;
		this.mPhoneNo = mPhoneNo;
		this.hPhoneNo = hPhoneNo;
		this.mPhoneCarrier = mPhoneCarrier;
		this.hPhoneCarrier = hPhoneCarrier;
		this.opType = opType;
	}

	public Message(int id) {
		this.id = id;
	}
	
	// provide the getter and setter methods

	public int getOpType() {
		return opType;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstFName) {
		this.firstName = firstFName;
	}


	public String getMi() {
		return mi;
	}


	public void setMi(String mi) {
		this.mi = mi;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getmPhoneNo() {
		return mPhoneNo;
	}


	public void setmPhoneNo(int mPhoneNo) {
		this.mPhoneNo = mPhoneNo;
	}


	public int gethPhoneNo() {
		return hPhoneNo;
	}


	public void sethPhoneNo(int hPhoneNo) {
		this.hPhoneNo = hPhoneNo;
	}


	public String getmPhoneCarrier() {
		return mPhoneCarrier;
	}


	public void setmPhoneCarrier(String mPhoneCarrier) {
		this.mPhoneCarrier = mPhoneCarrier;
	}


	public String gethPhoneCarrier() {
		return hPhoneCarrier;
	}


	public void sethPhoneCarrier(String hPhoneCarrier) {
		this.hPhoneCarrier = hPhoneCarrier;
	}
	

	
	
}
