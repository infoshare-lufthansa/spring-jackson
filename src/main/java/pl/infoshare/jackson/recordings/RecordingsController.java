package pl.infoshare.jackson.recordings;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.jackson.recordings.model.AudioBook;
import pl.infoshare.jackson.recordings.model.Podcast;
import pl.infoshare.jackson.recordings.model.Recording;
import pl.infoshare.jackson.recordings.model.Song;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecordingsController {

    private final RecordingRepository recordingRepository;

    @GetMapping("/api/songs")
    public List<Song> getSongs() {
        return recordingRepository.findSongs();
    }

    @GetMapping("/api/podcasts")
    public List<Podcast> getPodcasts() {
        return recordingRepository.findPodcasts();
    }

    @GetMapping("/api/audiobooks")
    public List<AudioBook> getAudiobooks() {
        return recordingRepository.findAudiobooks();
    }

    @GetMapping("/api/recordings")
    public List<Recording> getRecordings() {
        return recordingRepository.findRecordings();
    }

    @PostMapping("/api/recordings")
    public void getRecordings(Recording recording) {
        recordingRepository.saveRecording(recording);
    }
}
