package mx.org.jamexico.clase28.alumno.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
  @Enumerated(EnumType.ORDINAL)
  private Genero genero;
  @Enumerated(EnumType.STRING)
  private TipoSangre tipoSangre;
  private String curp;
  private LocalDate fechaNacimiento;
  private boolean activo;
  private LocalDateTime fechaBaja;
  @OneToOne(mappedBy = "alumno", cascade = CascadeType.ALL)
  private Direccion direccion;
}
