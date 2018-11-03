package com.nagarro.yourmartapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.entity.Image;
import com.nagarro.yourmartapi.repository.ImageRepository;

@RestController
@CrossOrigin
public class ImageController {

	@Autowired
	private ImageRepository imageRepository;
	
	@GetMapping(value="/product/{id}/image")
	public List<Image> getImages(@PathVariable("id") int productId) {
		return imageRepository.getImages(productId);
	}
	
	@PostMapping(value="/product/image")
	public void saveImages(@RequestBody() Image image) {
		imageRepository.save(image);
	}
}
