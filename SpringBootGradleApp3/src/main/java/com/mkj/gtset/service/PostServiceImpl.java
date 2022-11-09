package com.mkj.gtset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.gtset.entity.AppUser;
import com.mkj.gtset.entity.Post;
import com.mkj.gtset.repository.AppUserRepository;
import com.mkj.gtset.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	AppUserRepository userRepository;

	@Override
	public Post addPost(Post post) {

		Post savedPost = postRepository.save(post);
		return savedPost;
	}

	@Override
	public List<Post> getAllPostsbyUser(String username) throws Exception {
		AppUser user = userRepository.getUsersByUsername(username);

		return null;

	}

}
