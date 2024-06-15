package mx.org.jamexico.clase28.alumno.resource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.NoArgsConstructor;
import mx.org.jamexico.clase28.alumno.model.Genero;
import mx.org.jamexico.clase28.alumno.model.TipoSangre;

@Data
@NoArgsConstructor
public class AlumnoDireccionCreateResource {
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private Genero genero;
  private TipoSangre tipoSangre;
  private String curp;
  private LocalDate fechaNacimiento;
  private String calle;
  private String numeroExterior;
  private String numeroInterior;
  private String colonia;
  private String municipio;
  private String estado;
  private String pais;
  private String codigoPostal;
}
