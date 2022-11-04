package com.cloudvendor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudvendor.model.CloudVendor;
import com.cloudvendor.service.CloudvendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
	
	@Autowired
	CloudvendorService cvservice;
	
	// controller logic
	
	@PostMapping("/createvendor")
	public ResponseEntity<CloudVendor> createCloudVendor(@RequestBody CloudVendor vendordata) {
		
		return ResponseEntity.ok(cvservice.createCloudVendor(vendordata));
	}
	
	@GetMapping("/getvendor/{getid}")
	public  ResponseEntity<CloudVendor> getCloudVendorDetails(@PathVariable("getid") Integer vid) {
		
		return ResponseEntity.ok(cvservice.getCloudVendor(vid));		
	}
	
	@GetMapping("/getAllvendor")
	public ResponseEntity<List<CloudVendor>> getAllCloudVendor(){
		
		return ResponseEntity.ok(cvservice.getAllCloudVendor());		
	}
	@PutMapping("/updatevendor/{vendorid}")
	public ResponseEntity<CloudVendor> updateCloudVendor(@RequestBody CloudVendor vendordata,@PathVariable("vendorid") Integer vendorid) {
		
	return ResponseEntity.ok(cvservice.updateCloudVendor(vendorid, vendordata));	
	}
	
	@DeleteMapping("/deletevendor/{vendorid}")
	public ResponseEntity<String> deleteVendor(@PathVariable Integer vendorid) {
		
		return ResponseEntity.ok(cvservice.deleteCloudVendor(vendorid));
		
	}
	
}
