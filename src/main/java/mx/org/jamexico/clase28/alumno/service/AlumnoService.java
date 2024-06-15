package mx.org.jamexico.clase28.alumno.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.org.jamexico.clase28.alumno.model.Alumno;
import mx.org.jamexico.clase28.alumno.repository.AlumnoRepository;

@Service
public class AlumnoService {

  @Autowired
  private AlumnoRepository alumnoRepository;

  public Alumno altaAlumno(Alumno alumnoReq) {
    alumnoReq.setActivo(true);
    alumnoReq.setFechaBaja(null);
    Alumno alumnoResp = alumnoRepository.save(alumnoReq);
    return alumnoResp;
  }

  public Alumno regresaAlumnoPorId(UUID id) {
    Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
    if (!alumnoOptional.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el ID");
    }
    return alumnoOptional.get();
  }

  public void borrarAlumno(UUID idreq) {
    alumnoRepository.delete(regresaAlumnoPorId(idreq));
  }

  public Alumno actualizaAlumno(UUID idReq, Alumno alumnoReq) {
    Alumno alumnoActualizar = regresaAlumnoPorId(idReq);
    alumnoActualizar.setNombre(alumnoReq.getNombre());
    alumnoActualizar.setApellidoPaterno(alumnoReq.getApellidoPaterno());
    alumnoActualizar.setApellidoMaterno(alumnoReq.getApellidoMaterno());
    alumnoActualizar.setCurp(alumnoReq.getCurp());
    alumnoActualizar.setFechaNacimiento(alumnoReq.getFechaNacimiento());
    alumnoActualizar.setGenero(alumnoReq.getGenero());
    Alumno alumnoActualizado = alumnoRepository.save(alumnoActualizar);
    return alumnoActualizado;
  }
}
