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

    // Mostrar formulario para agregar o editar una canción
    @GetMapping({"/add", "/update/{id}"})
    public String addOrEditSongForm(@PathVariable(value = "id", required = false) Long id, Model model) {
        CreateSongDto createSongDto;

        if (id != null) {  // Modo edición
            Song song = songService.findSongById(id);
            if (song == null) {
                return "redirect:/songs"; // Redirigir si la canción no se encuentra
            }

            // Cargar los datos existentes en el DTO
            createSongDto = new CreateSongDto(
                song.getTitle(),
                song.getArtist(),
                song.getGenre(),
                song.getYear(),
                song.getAlbum(),
                song.getAlbumCover(),
                song.getDuration()
            );

            model.addAttribute("songId", id); // Pasar el ID al formulario
        } else {  // Modo agregar
            createSongDto = new CreateSongDto();
        }

        model.addAttribute("createSongDto", createSongDto);
        return "add"; // Refers to add.html (view)
    }

    // Procesar el formulario para agregar o actualizar una canción
    @PostMapping({"/add", "/update/{id}"})
    public String saveOrUpdateSong(@PathVariable(value = "id", required = false) Long id, 
                                   @ModelAttribute("createSongDto") CreateSongDto createSongDto) {
        Song song;

        if (id != null) {  // Modo actualización
            song = songService.findSongById(id);
            if (song == null) {
                return "redirect:/songs"; // Redirigir si no existe la canción
            }

            // Actualizar los valores del objeto existente
            song.setTitle(createSongDto.getTitle());
            song.setArtist(createSongDto.getArtist());
            song.setGenre(createSongDto.getGenre());
            song.setYear(createSongDto.getYear());
            song.setAlbum(createSongDto.getAlbum());
            song.setAlbumCover(createSongDto.getAlbumCover());
            song.setDuration(createSongDto.getDuration());

            songService.updateSong(song); // Actualizar la canción
        } else {  // Modo agregar
            song = new Song(
                createSongDto.getTitle(),
                createSongDto.getArtist(),
                createSongDto.getGenre(),
                createSongDto.getYear(),
                createSongDto.getAlbum(),
                createSongDto.getAlbumCover(),
                createSongDto.getDuration()
            );

            songService.saveSong(song); // Guardar la nueva canción
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
