package com.cloudvendor.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudvendor.model.CloudVendor;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
	
	@PostMapping("/createvendor")
	public String createAllCloudVendor(@RequestBody CloudVendor vendordata) {
		
		System.out.println(vendordata.getVendorName()+" "+
							vendordata.getVendorAddress()+"  "+vendordata.getPh_no());
		
	ArrayList<CloudVendor>list=new ArrayList<>();
			list.add(vendordata);
	if(!list.isEmpty()) {
	
	return "cloudvendor has been succefully created" ;
	}else {
		return "cloudvendor not been created" ;
	}
	}
	
	@GetMapping("/getvendorid/{getid}")
	public CloudVendor getCloudVendorDetails(@PathVariable("getid") Integer vid) {
		
		System.out.println("cloud vendor id"+vid);
		
		return null;
		
	}
	
	@PutMapping("/updatevendor")
	public String updateCloudVendor(@RequestBody CloudVendor vendordata) {
		
		System.out.println(vendordata.getVendorName()+" "+
							vendordata.getVendorAddress()+"  "+vendordata.getPh_no());
		
	return" vendor data updated";	
	}
	
	@DeleteMapping("/deletevendor/{vendorid}")
	public String deleteVendor(@PathVariable Integer vendorid) {
		
		return "vendor has been deleted";
		
	}
	
}
