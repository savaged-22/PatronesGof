package co.patronesgof.fis.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRutaDto {
    private String codigo;
    private String nombre;
    private String tipoRuta; // Local, Troncal
}
