package cl.duoc.monitorizacion_registro.service;

import cl.duoc.monitorizacion_registro.entity.RegistroBus;
import cl.duoc.monitorizacion_registro.model.RegistroDTO;
import cl.duoc.monitorizacion_registro.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class MonitorConsumerService {

    @Autowired
    private RegistroRepository repository;

    @KafkaListener(topics = "horarios", groupId = "grupo-monitorizacion")
    public void registrarEnBD(RegistroDTO data) {
        RegistroBus registro = new RegistroBus();
        registro.setIdVehiculo(data.getIdVehiculo());
        registro.setEstado(data.getEstadoHorario());
        registro.setFechaRegistro(LocalDateTime.now());

        repository.save(registro);
        System.out.println("Historial guardado en Oracle para: " + registro.getIdVehiculo());
    }
}