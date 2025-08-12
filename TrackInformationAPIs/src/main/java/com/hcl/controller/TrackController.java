package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Track;
import com.hcl.service.TrackService;

@RestController
@RequestMapping("/music/platform/v1/tracks")
public class TrackController {
	
	@Autowired
	private TrackService trackService;
	
	@PostMapping
	public ResponseEntity<Track> createTrack(@RequestBody Track track){
		return ResponseEntity.status(201).body(trackService.createTrack(track));
	}
	
	@GetMapping
	public ResponseEntity<List<Track>> getAllTrack(){
		return ResponseEntity.status(200).body(trackService.getAllTracks());
	}
	
	@DeleteMapping("/{trackId}")
	public ResponseEntity<Void> deleteTrack(@PathVariable Long trackId){
		trackService.deleteById(trackId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/sorted")
	public ResponseEntity<List<Track>> getAllTracksSorted(){
		return ResponseEntity.status(200).body(trackService.getAllTracksSorted());
	}
}
