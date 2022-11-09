package com.mkj.gtset.util;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mkj.gtset.dto.UserDefaultResponseDTO;
import com.mkj.gtset.dto.UserPostCreatedResponseDTO;
import com.mkj.gtset.entity.AppUser;
import com.mkj.gtset.entity.Post;

@Component
@Scope("singleton")
public class UserDTOConvertor {

	public static UserDefaultResponseDTO  getUserDefaultDTO(AppUser user)
	{
		UserDefaultResponseDTO dto = new UserDefaultResponseDTO(
				                 user.getUsername(), 
				                 user.getUserId(), 
				                 user.getUserProfile().getEmail(),
				                 "User Profile Created , Profile Id : "+user.getUserProfile().getProfileId());
		
		return dto;
	}
	
	
	
	
	public static UserPostCreatedResponseDTO getPostCreatedDTO(AppUser user,Post post)
	{
		UserPostCreatedResponseDTO dto = new UserPostCreatedResponseDTO(
				 user.getUsername(), 
                 user.getUserId(), 
                 post.getDescription(),
                 "Post Added "+post.getDate()
                 );
				 
				 return dto;
	}
}