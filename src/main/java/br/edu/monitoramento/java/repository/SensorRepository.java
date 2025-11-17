package br.edu.monitoramento.java.repository;

import br.edu.monitoramento.java.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    /**
     * Encontra todos os registros de sensores associados a um ID de usuário.
     * @param usuarioId O ID da empresa.
     * @return Uma lista de sensores.
     */
    List<Sensor> findByUsuarioId(Integer usuarioId);
}
