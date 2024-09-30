package co.patronesgof.fis.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUsuarioDto {
    private String nombre;
    private String tipoUsuario; // Regular, Estudiante, PersonaMayor
}
