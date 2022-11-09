package com.mkj.gtset.service;

import org.springframework.stereotype.Service;

import com.mkj.gtset.entity.Profile;

@Service
public interface ProfileService {

	public Profile addProfile(Profile profile);
}
