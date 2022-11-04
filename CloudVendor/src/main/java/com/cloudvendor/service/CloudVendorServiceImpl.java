package com.cloudvendor.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
		
		CloudVendor clouddata = cvrepo.findById(cloudid).orElseThrow(()-> new NoSuchElementException("No such value present in database"));;
		
			clouddata.setVendorName(vendordata.getVendorName());
			clouddata.setVendorAddress(vendordata.getVendorAddress());
			clouddata.setPh_no(vendordata.getPh_no());
			cvrepo.save(clouddata);
			return clouddata;
		
	}

	@Override
	public CloudVendor getCloudVendor(Integer vendorid) {
		CloudVendor cvdata = cvrepo.findById(vendorid).orElseThrow(()-> new NoSuchElementException("No such value present in database"));
		
		return cvdata;
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
		cvrepo.findById(vendorid).orElseThrow(()-> new NoSuchElementException("No such value present in database"));;
		
		cvrepo.deleteById(vendorid);
		return "vendor has been deleted";
		
	}

}
