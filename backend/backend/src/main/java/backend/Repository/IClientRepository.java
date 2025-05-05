package backend.Repository;

import backend.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
    // Obtener solo clientes con estado = true
    List<Client> findByEstadoTrue();

    // Buscar por ID solo si está activo
    Optional<Client> findByIdAndEstadoTrue(Long id);
}