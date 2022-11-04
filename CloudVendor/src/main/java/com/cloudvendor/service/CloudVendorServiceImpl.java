package com.cloudvendor.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudvendor.model.CloudVendor;
import com.cloudvendor.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudvendorService {
	
	@Autowired
	CloudVendorRepository cvrepo;
	

	@Override
	public CloudVendor createCloudVendor(CloudVendor vendordata) {
		CloudVendor clouddata = cvrepo.save(vendordata);
		
		return clouddata ;
	}

	@Override
	public CloudVendor updateCloudVendor(Integer cloudid,CloudVendor vendordata) {
		
		CloudVendor clouddata = cvrepo.findById(cloudid).get();
		if(clouddata!=null) {
			clouddata.setVendorName(vendordata.getVendorName());
			clouddata.setVendorAddress(vendordata.getVendorAddress());
			clouddata.setPh_no(vendordata.getPh_no());
			cvrepo.save(clouddata);
		}
		return clouddata;
		
		//biolarplate code
		
	}

	@Override
	public CloudVendor getCloudVendor(Integer vendorid) {
		Optional<CloudVendor> cvdata = cvrepo.findById(vendorid);
		if(!cvdata.isEmpty()) {
			return cvdata.get();
		}
		
		return null;
	}

	@Override
	public List<CloudVendor> getAllCloudVendor() {
		List<CloudVendor> listofdata = cvrepo.findAll();
		
		 return listofdata.stream().map((data)->
		new CloudVendor(data.getVendrid(), data.getVendorName(), data.getVendorAddress(), data.getPh_no()))
				 .collect(Collectors.toList());

	}

	@Override
	public String deleteCloudVendor(Integer vendorid) {
		Optional<CloudVendor> cvdata = cvrepo.findById(vendorid);
		if(!cvdata.isEmpty()) {
		cvrepo.deleteById(vendorid);
		return "vendor has been deleted";
		}
		return " cloud vendor not found";
		
	}

}
