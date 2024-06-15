package mx.org.jamexico.clase28.alumno.controller;

import org.springframework.web.bind.annotation.RestController;

import mx.org.jamexico.clase28.alumno.model.Alumno;
import mx.org.jamexico.clase28.alumno.service.AlumnoService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

  @Autowired
  private AlumnoService alumnoService;

  @PostMapping("/alta")
  public ResponseEntity<Alumno> altaAlumnoHTTP(@RequestBody Alumno alumnoReq) {
    Alumno alumnoResp;
    alumnoResp = alumnoService.altaAlumno(alumnoReq);
    return ResponseEntity.ok(alumnoResp);
  }

  @PutMapping("actualizar/{idReq}")
  public ResponseEntity<Alumno> putMethodName(@PathVariable UUID idReq, @RequestBody Alumno alumnoReq) {
    Alumno alumnoResp;
    alumnoResp = alumnoService.actualizaAlumno(idReq, alumnoReq);
    return ResponseEntity.ok(alumnoResp);
  }

  @GetMapping("id/{idReq}")
  public ResponseEntity<Alumno> getAlumnoById(@PathVariable UUID idReq) {
    Alumno alumnoResp = alumnoService.regresaAlumnoPorId(idReq);

    return ResponseEntity.ok(alumnoResp);
  }

  @DeleteMapping("borrar/{idReq}")
  public ResponseEntity<?> borrarAlumno(@PathVariable UUID idReq) {
    alumnoService.borrarAlumno(idReq);
    return ResponseEntity.noContent().build();
  }

}
