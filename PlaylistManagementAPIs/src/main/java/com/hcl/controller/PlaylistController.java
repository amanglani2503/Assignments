package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Playlist;
import com.hcl.service.PlaylistService;

@RestController
@RequestMapping("/v1/playlists")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;
	
	@GetMapping
	public ResponseEntity<List<Playlist>> getAllPlaylists(){
		return ResponseEntity.status(200).body(playlistService.getAllPlaylists());
	}
	
	@GetMapping("/{playlistId}")
	public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long playlistId){
		return ResponseEntity.status(200).body(playlistService.getById(playlistId));
	}
	
	@PostMapping()
	public ResponseEntity<Playlist> createNewPlaylist(@RequestBody Playlist playlist){
		return ResponseEntity.status(201).body(playlistService.createNewPlaylist(playlist)); 
	}
	
	@DeleteMapping("/{playlistId}")
	public ResponseEntity<?> deletePlaylist(@PathVariable Long playlistId){
		playlistService.deleteById(playlistId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	}
}
