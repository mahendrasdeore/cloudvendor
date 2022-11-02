package com.cloudvendor.service;

import java.util.List;

import com.cloudvendor.model.CloudVendor;


public interface CloudvendorService {
	
	public CloudVendor createCloudVendor(CloudVendor vendordata);
	
	public CloudVendor updateCloudVendor(Integer cloudid,CloudVendor vendordata);
	
	public CloudVendor getCloudVendor( Integer vendorid);
	
	public List<CloudVendor> getAllCloudVendor();
	
	public String deleteCloudVendor(Integer vendorid);
	
	
	

}
