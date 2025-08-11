package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

}
