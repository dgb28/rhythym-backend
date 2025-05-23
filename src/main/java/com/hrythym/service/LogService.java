package com.hrythym.service;

import com.hrythym.model.PlaybackLog;
import com.hrythym.model.Song;
import com.hrythym.model.User;
import com.hrythym.repository.PlaybackLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {

    private final PlaybackLogRepository logRepo;

    // ✅ Define constructor explicitly
    public LogService(PlaybackLogRepository logRepo) {
        this.logRepo = logRepo;
    }

    public void logAction(User user, Song song, String action) {
        PlaybackLog log = new PlaybackLog();
        log.setUserId(user.getId());
        log.setSongId(song.getId());
        log.setAction(action);
        log.setGenre(song.getGenre());
        log.setMood(song.getMood());
        log.setTimestamp(LocalDateTime.now());
        logRepo.save(log);
    }
}
