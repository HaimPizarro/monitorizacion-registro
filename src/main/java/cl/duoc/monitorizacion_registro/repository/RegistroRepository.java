package cl.duoc.monitorizacion_registro.repository;

import cl.duoc.monitorizacion_registro.entity.RegistroBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroBus, Long> {
}