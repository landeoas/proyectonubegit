package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity 
public class Matricula extends Model {

    @Id
    public Long id;
    
    @ManyToOne
	@Constraints.Required(message="Debe ingresar el alumno")
    public Alumno tipoAlumno;
	public Alumno getAlumno(Long id) {
		return Alumno.find.where().idEq(id).findUnique();
	}

	@ManyToOne
	@Constraints.Required(message="Debe ingresar el curso")
    public Curso tipoCurso;
	public Curso getCurso(Long id) {
		return Curso.find.where().idEq(id).findUnique();
	}
    // Generic query helper for entity with id Long
    public static Model.Finder<Long,Matricula> find = new Model.Finder<Long,Matricula>(Long.class, Matricula.class);

}

