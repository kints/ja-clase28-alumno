package mx.org.jamexico.clase28.alumno.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Alumno {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private Genero genero;
  private String curp;
  private LocalDate fechaNacimiento;
  private boolean activo;
  private LocalDateTime fechaBaja;
}
