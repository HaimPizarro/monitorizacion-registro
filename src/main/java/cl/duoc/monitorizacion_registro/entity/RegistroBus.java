package cl.duoc.monitorizacion_registro.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "REGISTRO_MONITOREO") 
@Data
public class RegistroBus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_vehiculo")
    private String idVehiculo;

    @Column(name = "estado_horario")
    private String estado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}