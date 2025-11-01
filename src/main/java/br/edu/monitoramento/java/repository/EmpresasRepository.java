package br.edu.monitoramento.java.repository;

import br.edu.monitoramento.java.model.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Integer> {
    Optional<Empresas> findByCnpjEmpresa(String cnpjEmpresa);
}
