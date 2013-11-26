package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity 
public class Clase extends Model {

    @Id
    public Long id;
    
    @Constraints.Required(message="Debe ingresar un titulo para la clase")
    public String titulo;
    
    @Constraints.Required(message="Debe ingresar una descreipcion general de la clase")
    public String descripcion;
    
    //@Constraints.Required(message="Debe ingresar un archivo para la clase")
    public String file;
    
	@Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date created;
    
    @Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date updated;
    
    
    @ManyToOne
    public Curso curso;
    
    public static Curso getCurso(Long id) {
		return Curso.find.where().idEq(id).findUnique();
	}
    
    // Generic query helper for entity with id Long
    public static Model.Finder<Long,Clase> find = new Model.Finder<Long,Clase>(Long.class, Clase.class);
    
}