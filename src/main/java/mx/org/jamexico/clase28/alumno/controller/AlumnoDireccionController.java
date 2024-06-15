package mx.org.jamexico.clase28.alumno.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import mx.org.jamexico.clase28.alumno.model.Direccion;
import mx.org.jamexico.clase28.alumno.resource.AlumnoDireccionCreateResource;
import mx.org.jamexico.clase28.alumno.resource.AlumnoDireccionResource;
import mx.org.jamexico.clase28.alumno.service.AlumnoDireccionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/alumnoDireccion/")
public class AlumnoDireccionController {

  @Autowired
  AlumnoDireccionService alumnoDireccionService;

  @PostMapping("alta/{idAlumno}")
  public ResponseEntity<AlumnoDireccionResource> altaDireccionAlumno(@PathVariable UUID idAlumno,
      @RequestBody Direccion direccion) {
    AlumnoDireccionResource alumnoDireccion = alumnoDireccionService.altaDireccionAlumno(idAlumno, direccion);
    return ResponseEntity.ok(alumnoDireccion);
  }

  @PostMapping("altaConAlumno/")
  public ResponseEntity<AlumnoDireccionResource> altaDireccionAlumno(
      @RequestBody AlumnoDireccionCreateResource alumnoDireccionCreate) {
    AlumnoDireccionResource alumnoDireccion = alumnoDireccionService.creaAlumnoYDireccion(alumnoDireccionCreate);
    return ResponseEntity.ok(alumnoDireccion);
  }

  @GetMapping("encuentra/{idAlumno}")
  public ResponseEntity<AlumnoDireccionResource> encuentraDireccionAlumno(@PathVariable UUID idAlumno) {
    return ResponseEntity.ok(alumnoDireccionService.encuentraDireccionAlumno(idAlumno));
  }

}
