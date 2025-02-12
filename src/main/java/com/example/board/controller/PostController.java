package com.example.board.controller;

import com.example.board.model.Post;
import com.example.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public String getAllPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "post_list";
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        if (post == null) {
            return "error/404";  // 404 에러 페이지로 이동
        }
        model.addAttribute("post", post);
        return "post_detail";
    }

    @GetMapping("/new")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post_form";
    }

    @PostMapping
    public String savePost(@ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String editPostForm(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        if (post == null) {
            return "error/404";  // 게시물이 없으면 404 페이지로 이동
        }
        model.addAttribute("post", post);
        return "post_edit";  // post_edit.html 페이지 반환
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
        Post existingPost = postService.getPostById(id);
        if (existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            postService.savePost(existingPost);
        }
        return "redirect:/posts";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id, Model model) {
        if (!postService.deletePost(id)) {
            return "error/404"; // 삭제하려는 게시물이 없는 경우
        }
        return "redirect:/posts";
    }
}
