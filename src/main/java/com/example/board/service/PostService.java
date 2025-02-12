package com.example.board.service;

import com.example.board.model.Post;
import com.example.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public boolean deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            return false; // 게시물이 없으면 삭제 불가능
        }
        postRepository.deleteById(id);
        return true;
    }
}

