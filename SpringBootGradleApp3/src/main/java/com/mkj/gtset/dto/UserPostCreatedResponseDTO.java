package com.mkj.gtset.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserPostCreatedResponseDTO implements MyDTO{

	private String username;
	private int userId;
	private String postDescription;
	private String remarks;
}