package backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Persona extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "El celular no puede estar vacío")
    @Pattern(regexp = "\\d{10}", message = "El celular debe tener 10 dígitos numéricos")
    @Column(name = "cell_phone", nullable = false, unique = true)
    private String cellPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre no puede estar vacío") @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "El nombre no puede estar vacío") @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres") String name) {
        this.name = name;
    }

    public @NotBlank(message = "El apellido no puede estar vacío") @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "El apellido no puede estar vacío") @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "El celular no puede estar vacío") @Pattern(regexp = "\\d{10}", message = "El celular debe tener 10 dígitos numéricos") String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(@NotBlank(message = "El celular no puede estar vacío") @Pattern(regexp = "\\d{10}", message = "El celular debe tener 10 dígitos numéricos") String cellPhone) {
        this.cellPhone = cellPhone;
    }
}