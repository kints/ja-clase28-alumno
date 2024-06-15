package mx.org.jamexico.clase28.alumno.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.org.jamexico.clase28.alumno.model.Alumno;
import mx.org.jamexico.clase28.alumno.model.Direccion;
import mx.org.jamexico.clase28.alumno.repository.DireccionRepository;
import mx.org.jamexico.clase28.alumno.resource.AlumnoDireccionCreateResource;
import mx.org.jamexico.clase28.alumno.resource.AlumnoDireccionResource;

@Service
public class AlumnoDireccionService {

  @Autowired
  private DireccionRepository direccionRepository;
  @Autowired
  private AlumnoService alumnoService;

  public AlumnoDireccionResource altaDireccionAlumno(UUID idAlumno, Direccion direccionReq) {
    Alumno alumno = alumnoService.regresaAlumnoPorId(idAlumno);
    direccionReq.setAlumno(alumno);
    Direccion direccion = direccionRepository.save(direccionReq);
    AlumnoDireccionResource alumnoDireccionResource = llenarAlumnoDireccion(alumno, direccion);
    return alumnoDireccionResource;
  }

  private AlumnoDireccionResource llenarAlumnoDireccion(Alumno alumno, Direccion direccion) {
    AlumnoDireccionResource alumnoDireccionResource = new AlumnoDireccionResource();
    alumnoDireccionResource.setNombre(alumno.getNombre());
    alumnoDireccionResource.setApellidoPaterno(alumno.getApellidoPaterno());
    alumnoDireccionResource.setApellidoMaterno(alumno.getApellidoMaterno());
    alumnoDireccionResource.setCalle(direccion.getCalle());
    alumnoDireccionResource.setNumeroExterior(direccion.getNumeroExterior());
    alumnoDireccionResource.setNumeroInterior(direccion.getNumeroInterior());
    alumnoDireccionResource.setCodigoPostal(direccion.getCodigoPostal());
    alumnoDireccionResource.setColonia(direccion.getColonia());
    alumnoDireccionResource.setMunicipio(direccion.getMunicipio());
    alumnoDireccionResource.setEstado(direccion.getEstado());
    alumnoDireccionResource.setPais(direccion.getPais());
    return alumnoDireccionResource;
  }

  public AlumnoDireccionResource encuentraDireccionAlumno(UUID idAlumno) {
    Alumno alumno = alumnoService.regresaAlumnoPorId(idAlumno);
    if (alumno.getDireccion() == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay dirección para ese alumno");
    }
    Direccion direccion = alumno.getDireccion();
    return llenarAlumnoDireccion(alumno, direccion);
  }

  public AlumnoDireccionResource creaAlumnoYDireccion(AlumnoDireccionCreateResource alumnoDireccionCreate) {
    Alumno alumno = new Alumno();
    alumno.setNombre(alumnoDireccionCreate.getNombre());
    alumno.setApellidoPaterno(alumnoDireccionCreate.getApellidoPaterno());
    alumno.setApellidoMaterno(alumnoDireccionCreate.getApellidoMaterno());
    alumno.setCurp(alumnoDireccionCreate.getCurp());
    alumno.setFechaNacimiento(alumnoDireccionCreate.getFechaNacimiento());
    alumno.setGenero(alumnoDireccionCreate.getGenero());
    alumno.setTipoSangre(alumnoDireccionCreate.getTipoSangre());
    alumno = alumnoService.altaAlumno(alumno);

    Direccion direccion = new Direccion();
    direccion.setCalle(alumnoDireccionCreate.getCalle());
    direccion.setCodigoPostal(alumnoDireccionCreate.getCodigoPostal());
    direccion.setColonia(alumnoDireccionCreate.getColonia());
    direccion.setNumeroExterior(alumnoDireccionCreate.getNumeroExterior());
    direccion.setNumeroInterior(alumnoDireccionCreate.getNumeroInterior());
    direccion.setEstado(alumnoDireccionCreate.getEstado());
    direccion.setPais(alumnoDireccionCreate.getPais());

    return altaDireccionAlumno(alumno.getId(), direccion);
  }

}
