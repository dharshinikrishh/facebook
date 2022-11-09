package com.mkj.gtset.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.gtset.dto.ErrorDTO;
import com.mkj.gtset.dto.MyDTO;
import com.mkj.gtset.dto.UserDefaultResponseDTO;
import com.mkj.gtset.entity.AppUser;
import com.mkj.gtset.entity.Profile;
import com.mkj.gtset.service.AppUserService;
import com.mkj.gtset.service.ProfileService;
import com.mkj.gtset.util.UserDTOConvertor;

@RestController
@RequestMapping("fb/profile")
@Validated
public class ProfileWebController {

	@Autowired
	ProfileService profileService;
	
	@Autowired
	AppUserService userService;
	
	@Autowired
	UserDTOConvertor dtoConvertor;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	
	@PostMapping("/add")  // ....../fbusers/profile/add?username=mike
	public ResponseEntity<MyDTO> doProfileThings(@RequestBody @Valid Profile profile,@RequestParam String username)
	{
		AppUser alreadySavedUser = null;
		try
		{
			System.out.println(" --- > "+mylogs);
			mylogs.info("---->>>Inside try of doprofile things");
			Profile savedProfile = profileService.addProfile(profile);
			if(savedProfile.getProfileId() != 0)
			{
				alreadySavedUser = userService.getUserByUserName(username);
				if(alreadySavedUser != null)
				{
					AppUser profileAddUser = userService.linkProfile(savedProfile, alreadySavedUser);
					
					UserDefaultResponseDTO dtoResponse = dtoConvertor.getUserDefaultDTO(profileAddUser);
					
					return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
				}
				else
				{
					mylogs.error("User not found in post mapping uri : add");
					throw new Exception("User not found ,  "+alreadySavedUser+" for "+username);
				}
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
			ErrorDTO errorDTo = new ErrorDTO(e.getMessage());
			return new ResponseEntity<>(errorDTo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return null;
		
		// code to add the profile
	}
	
}