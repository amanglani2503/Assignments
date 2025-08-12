package com.hcl.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Track {
	@Id
	@GeneratedValue
	private Long id;

	private String title;
	private String albumName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private Integer playCount;

	public Track() {
		super();
	}

	public Track(Long id, String title, String albumName, Date date, Integer playCount) {
		super();
		this.id = id;
		this.title = title;
		this.albumName = albumName;
		this.date = date;
		this.playCount = playCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPlayCount() {
		return playCount;
	}

	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}

}
