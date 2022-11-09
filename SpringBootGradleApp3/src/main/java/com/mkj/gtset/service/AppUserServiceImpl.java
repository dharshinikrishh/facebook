package com.mkj.gtset.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.gtset.entity.AppUser;
import com.mkj.gtset.entity.Post;
import com.mkj.gtset.entity.Profile;
import com.mkj.gtset.repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	AppUserRepository userRepository;

	@Override
	public List<AppUser> getAllUsers() throws Exception {
		List<AppUser> allUsers = userRepository.findAll(); // Note : same as save
		return allUsers;
	}

	@Override
	public List<AppUser> getAllUsers(String role) throws Exception {
		return null;
	}

	@Override
	public AppUser getUserByUserName(String username) throws Exception {
		AppUser outputUser = userRepository.getUsersByUsername(username);

		if (outputUser == null) {
			throw new EntityNotFoundException(username + " not listed in the database");
		} else {
			return outputUser;
		}

	}

	@Override
	public List<AppUser> getUsersConnections(String username) throws Exception {
		return null;
	}

	@Override
	public AppUser getUserByUserNameAndRole(String username, String role) throws Exception {
		return null;
	}

	@Override
	public List<AppUser> getUsersByRole(String role) throws Exception {
		System.out.println(" ---->> Inside Servive Impl role " + role);
		return userRepository.getAllUsersByRole(role);
	}

	@Override
	public List<AppUser> getUsersBetweenIds(int range1, int range2) throws Exception {
		return userRepository.getUsersBetweenIds(range1, range2);
	}

	@Override
	public AppUser getUserById(int searchedUserId) throws Exception {
		AppUser outputUser = userRepository.getReferenceById(searchedUserId);
		return outputUser;
	}

	@Override
	public List<Post> getAllPosts(String username) {
		return null;
	}

	@Override
	@Transactional
	public AppUser insertUser(AppUser user) throws Exception {
		AppUser savedUser = userRepository.save(user); // Note : save() is already implemented by Spring Data JPA
		if (savedUser != null) {
			return savedUser;
		} else
			return null;

	}

	@Override
	@Transactional
	public AppUser addHobbies(List<String> allHobbies, AppUser appUser) {
		System.out.println(" --- 2> Inside UserService Impl ");
		System.out.println(appUser + " \n \n " + allHobbies);
		appUser.setHobbies(allHobbies);
		return appUser;
	}

	@Override
	@Transactional
	public AppUser addPost(Post post, AppUser appUser) {
		List<Post> allUserPost = appUser.getAllPosts();

		if (allUserPost == null) {
			allUserPost = new ArrayList<>();
			allUserPost.add(post);
		} else {
			allUserPost.add(post);
		}

		appUser.setAllPosts(allUserPost);

		return appUser;
	}

	@Override
	@Transactional
	public AppUser linkProfile(Profile profile, AppUser appUser) {
		appUser.setUserProfile(profile);
		return appUser;
	}

}
