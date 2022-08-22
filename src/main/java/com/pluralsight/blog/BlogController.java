package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    BlogController(PostRepository pr) {
        this.postRepository = pr;
    }
    @RequestMapping("/")
    public String listPosts(ModelMap map) {
        List<Post> posts = this.postRepository.getAllPosts();
        map.put("posts", posts);
        return "home";
    }
    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap) {
        Post post = this.postRepository.findById(id);
        modelMap.put("post", post);
        return "post-details";
    }
}
