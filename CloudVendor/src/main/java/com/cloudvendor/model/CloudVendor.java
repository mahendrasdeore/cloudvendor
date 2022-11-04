package com.cloudvendor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="cloudvendor")
public class CloudVendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int vendrid;
	
	private String vendorName;
	
	private String vendorAddress;
	
	private String ph_no;
	
	
	public CloudVendor(int vendrid, String vendorName, String vendorAddress, String ph_no) {
		super();
		this.vendrid = vendrid;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.ph_no = ph_no;
	}
	
	

}
