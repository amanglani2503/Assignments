package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hcl.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Long> {

}
