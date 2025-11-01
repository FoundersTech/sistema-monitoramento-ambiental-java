package br.edu.monitoramento.java.repository;

import br.edu.monitoramento.java.model.DadosClimaticos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosClimaticosRepository extends JpaRepository<DadosClimaticos, Integer> {
}
