package com.mkj.gtset.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkj.gtset.entity.Post;

@Service
public interface PostService {

	public Post addPost(Post post);

	public List<Post> getAllPostsbyUser(String username) throws Exception;
}
