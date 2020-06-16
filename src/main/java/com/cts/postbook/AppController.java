package com.cts.postbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	private List<Post> allPosts;

	public AppController() {

		allPosts = new ArrayList<>();
		allPosts.add(new Post(1, "hi there!!", "message"));
		allPosts.add(new Post(2, "bye there!!", "quit"));

	}

	@GetMapping("/all")
	public List<Post> getAllPosts() {

		return allPosts;
	}

	@PostMapping("/add")
	public Post addPost(@RequestBody Post post) {
		allPosts.add(post);
		return post;
	}

	@PutMapping("/edit")
	public Post editPost(@RequestBody Post post) {

		for (int ind = 0; ind < allPosts.size(); ind++) {
			if (allPosts.get(ind).getId() == post.getId()) {
				allPosts.set(ind, post);
				break;
			}

		}
		return post;
	}

	@DeleteMapping("/delete/{id}")
	public Status deletePost(@PathVariable("id") Integer id) {
		boolean flag = allPosts.removeIf(p -> p.getId() == id);
		return (flag) ? new Status(true, "deleted succesfully") : new Status(false, "unable to delete");

	}

}
