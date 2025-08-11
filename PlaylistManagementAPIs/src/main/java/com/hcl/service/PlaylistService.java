package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.Playlist;
import com.hcl.repository.PlaylistRepository;

@Service
public class PlaylistService  {
	
	@Autowired
	private PlaylistRepository playlistRepository;
	
	public Playlist createNewPlaylist(Playlist playlist) {
		return playlistRepository.save(playlist);
	}
	
	public List<Playlist> getAllPlaylists(){
		return playlistRepository.findAll();
	}
	
	public Playlist getById(Long id) {
		return playlistRepository.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
		playlistRepository.deleteById(id);
	}
}
