package co.musicshop.fis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.musicshop.fis.models.Song;
import co.musicshop.fis.repositories.SongRepository;
import co.musicshop.fis.services.interfaces.SongServiceInterface;

@Service
public class SongService implements SongServiceInterface {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public Song updateSong(Song song) {
        // Verificar si la canción existe antes de actualizar
        if (song.getId() != null && songRepository.existsById(song.getId())) {
            return songRepository.save(song); // Actualizar la canción existente
        } else {
            throw new IllegalArgumentException("No se puede actualizar la canción: ID no existe.");
        }
    }
    

    @Override
    public Song findSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }
}
