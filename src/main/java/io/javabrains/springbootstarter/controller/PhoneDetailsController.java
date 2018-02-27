package io.javabrains.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.model.Phone;
import io.javabrains.springbootstarter.service.PhoneDetailService;

@RestController
public class PhoneDetailsController {
	
	@Autowired
	private PhoneDetailService phoneDetailService;
	
	@RequestMapping(value="/phones/userName")
	public List<Phone> getPhonesByPersonFirstName(@RequestParam String userName){
		
		return phoneDetailService.getPhonesByPersonFirstName(userName);
		
	}
	
	@RequestMapping(value="/addphones", method=RequestMethod.POST)
	public Phone addPhoneByEmail(@RequestParam(value="emailId")String emailId,@RequestParam(value="phoneNumber")String phonenumber,@RequestBody Phone phone){
		
		return phoneDetailService.addPhoneByEmail(emailId,phonenumber,phone);
		
	}
	
	@RequestMapping(value="/phones/{emailId:.+}")
	@ResponseBody
	public List<Phone> getPhonesByEmailId(@PathVariable String emailId){
		return phoneDetailService.getPhonesByPersonEmailId(emailId);
	}
	
	@RequestMapping(value="/phones/{emailId:.+}/{phoneNumber}")
	@ResponseBody
	public List<Phone> getPhonesByEmailIdAndPhoneNumber(@PathVariable String emailId,@PathVariable String phoneNumber){
		return phoneDetailService.getPhonesByEmailIdAndPhoneNumber(emailId,phoneNumber);
	}
	
	@RequestMapping(value="/phones/phoneName")
	@ResponseBody
	public Phone getPhonesByPhoneName(@RequestParam String phoneName){
		return phoneDetailService.getPhoneByName(phoneName);
	}
	
	@RequestMapping(value="/phones")
	@ResponseBody
	public List<Phone> getPhonesByPhoneNameAndOperatingSystem(@RequestParam String phoneName,@RequestParam String operatingSystem){
		return phoneDetailService.findByPhoneNameAndOperatingSystem(phoneName,operatingSystem);
	}
	
	@RequestMapping(value="/phones/all")
	@ResponseBody
	public List<Phone> getAllPhonesByNamedQuery(){
		return phoneDetailService.getData();
	}
	
	
	
}
