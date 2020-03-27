package br.com.lucasalbertoni.alura.angular.alurapic.alurapicbackend.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String url;
	private String description;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime postDate;
	private boolean allowComments;
	private long number;
	private long comments;
	private long userId;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}
	public boolean isAllowComments() {
		return allowComments;
	}
	public void setAllowComments(boolean allowComments) {
		this.allowComments = allowComments;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public long getComments() {
		return comments;
	}
	public void setComments(long comments) {
		this.comments = comments;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

}
