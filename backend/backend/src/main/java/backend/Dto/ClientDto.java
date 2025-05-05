package backend.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClientDto(
        Long id,

        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
        String name,

        @NotBlank(message = "El apellido no puede estar vacío")
        @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
        String lastName,

        @NotBlank(message = "El celular no puede estar vacío")
        @Pattern(regexp = "\\d{10}", message = "El celular debe tener 10 dígitos numéricos")
        String cellPhone,

        @Size(max = 500, message = "Las notas no pueden exceder los 500 caracteres")
        String notes
) {}