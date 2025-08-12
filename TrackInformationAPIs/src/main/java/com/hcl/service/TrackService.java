package com.hcl.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.Track;
import com.hcl.repository.TrackRepository;

@Service
public class TrackService {

	@Autowired
	private TrackRepository trackRepository;

	public Track createTrack(Track track) {
		return trackRepository.save(track);
	}

	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	public void deleteById(Long trackId) {
		trackRepository.deleteById(trackId);
	}
	
	public List<Track> getAllTracksSorted() {
		List<Track> tracks = trackRepository.findAll();
		
		Collections.sort(tracks, Comparator.comparing(Track::getTitle));
		
		return tracks;
	}
}
