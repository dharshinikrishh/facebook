package com.mkj.gtset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkj.gtset.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> 
{

	
}