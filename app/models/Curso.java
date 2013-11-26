package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity 
public class Curso extends Model {

    @Id
    public Long id;
    
    @Constraints.Required(message="Debe ingresar el nombre")
    public String name;
    
    @Constraints.Required(message="Debe ingresar el ciclo")
    public int ciclo;
    
    @Constraints.Required(message="Debe ingresar los creditos")
    public int creditos;
    
    @Constraints.Required(message="Debe ingresar el grupo")
    public int grupo;
    
    @Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date created;
    
    @Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date updated;

    @ManyToOne
	//@Constraints.Required(message="Debe ingresar el menu")
    public Profesor profesor;
    
	public Profesor getProfesor(Long id) {
		return Profesor.find.where().idEq(id).findUnique();
	}

    // Generic query helper for entity with id Long
    public static Model.Finder<Long,Curso> find = new Model.Finder<Long,Curso>(Long.class, Curso.class);

}



