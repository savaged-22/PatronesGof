package co.patronesgof.fis.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEstacionDto {
    private String nombre;
    private String estado;
}
