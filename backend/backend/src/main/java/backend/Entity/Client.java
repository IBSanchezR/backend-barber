package backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client extends Persona {

    @Column(name = "notes", length = 500)
    @Size(max = 500, message = "Las notas no pueden exceder los 500 caracteres")
    private String notes;

    @Column(name = "points", nullable = false)
    @Min(value = 0, message = "Los puntos no pueden ser negativos")
    private Integer points;

    @Column(name = "membership_level", nullable = false)
    @NotBlank(message = "El nivel de membresía no puede estar vacío")
    @Pattern(regexp = "BASIC|SILVER|GOLD|PLATINUM", message = "El nivel de membresía invalido")
    private String membershipLevel;

    public String getNotes() {
        return notes;
    }

    public void setNotes (String notes) {
        this.notes = notes;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }
}