package br.com.lucasalbertoni.alura.angular.alurapic.alurapicbackend.view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasalbertoni.alura.angular.alurapic.alurapicbackend.entity.Photo;

@RestController
@RequestMapping("photos")
public class PhotoView {
	
	List<Photo> photos = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		for(int i=0; i<31; i++) {
			photos.add(new Photo());
			photos.get(i).setId(i);
			photos.get(i).setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ-7CL2ny30QaDYiORp9yC35pR54SOVu5kWJ2s7NllA7UVVDjD&s");
			photos.get(i).setDescription("Farol" + i);
			photos.get(i).setPostDate(LocalDateTime.now());
			photos.get(i).setAllowComments(true);
			photos.get(i).setComments(1000);
			photos.get(i).setNumber(i);
			photos.get(i).setUserId(i);
		}
	}
	
	@GetMapping("/{username}")
	public List<Photo> get(@PathVariable String username, @RequestParam(name = "page", required = false) Integer page){
		System.out.println(username);
		List<Photo> photos = new ArrayList<>();
		int size = 9;
		if(page != null) {
			int endValue = page*size;
			if(endValue > this.photos.size())
				endValue = this.photos.size();
			int begginValue = (page-1)*size;
			for(int i=begginValue; i<endValue;i++) {
				photos.add(this.photos.get(i));
			}
		}else {
			photos = this.photos;
		}
		return photos;
	}

}
