package co.musicshop.fis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.musicshop.fis.dtos.CreateSongDto;
import co.musicshop.fis.models.Song;
import co.musicshop.fis.services.SongService;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    // Mostrar todas las canciones
    @GetMapping()
    public String allSongs(Model model) {
        List<Song> songs = songService.findAllSongs();
        model.addAttribute("songs", songs);
        return "songs"; // Refers to songs.html (view)
    }

    // Mostrar formulario para agregar una nueva canción
    @GetMapping("/add")
    public String addSongForm(Model model) {
        model.addAttribute("createSongDto", new CreateSongDto());
        return "add"; // Refers to add.html (view)
    }

    // Procesar el formulario para agregar una nueva canción
    @PostMapping()
    public String addSong(@ModelAttribute("createSongDto") CreateSongDto createSongDto) {
        Song song = new Song(
                createSongDto.getTitle(),
                createSongDto.getArtist(),
                createSongDto.getGenre(),
                createSongDto.getYear(),
                createSongDto.getAlbum(),
                createSongDto.getAlbumCover(),
                createSongDto.getDuration());

        songService.saveSong(song);
        return "redirect:/songs"; // Redirigir a /songs
    }

    // Mostrar formulario para actualizar una canción existente
    @GetMapping("/update/{id}")
    public String editSongForm(@PathVariable("id") Long id) {
        Song song = songService.findSongById(id);
        
        if (song == null) {
            return "redirect:/songs"; // Redirigir si la canción no se encuentra
        }
        return "redirect:/update"; // Refers to update.html (view)
    }

    // Procesar el formulario de actualización de una canción
    @PostMapping("/update/{id}")
    public String updateSong(@PathVariable("id") Long id, @ModelAttribute("song") Song updatedSong) {
        Song song = songService.findSongById(id);

        if (song != null) {
            song.setTitle(updatedSong.getTitle());
            song.setArtist(updatedSong.getArtist());
            song.setGenre(updatedSong.getGenre());
            song.setYear(updatedSong.getYear());
            song.setAlbum(updatedSong.getAlbum());
            song.setAlbumCover(updatedSong.getAlbumCover());
            song.setDuration(updatedSong.getDuration());
            songService.saveSong(song); // Usar saveSong para actualizar la canción
        }

        return "redirect:/songs"; // Redirigir a la lista de canciones
    }

    // Eliminar una canción
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") Long id) {
        songService.deleteSong(id); // Usar deleteSong para eliminar
        return "redirect:/songs"; // Redirigir a la lista de canciones
    }
}
