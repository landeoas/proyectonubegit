package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity 
public class Alumno extends Model {

    @Id
    public Long id;
    
    @Constraints.Required(message="Debe ingresar su codigo de matricula")
    public Long codigo;
    
    @Constraints.Required(message="Debe ingresar sus nombres")
    public String nombres;
    
    @Constraints.Required(message="Debe ingresar sus apellidos")
    public String apellidos;
    
    @Constraints.Required(message="Debe ingresar su genero")
    public String genero;
    
    //@Formats.DateTime(pattern="dd/mm/yyyy")
    @Constraints.Required(message="Debe ingresar la fecha de nacimiento")
    public Date fecha;
    
    @Constraints.Required(message="Debe ingresar su residencia")
    public String residencia;
    
    @Constraints.Required(message="Debe ingresar su provincia")
    public String provincia;
    
    @Constraints.Required(message="Debe ingresar su E.A.P")
    public String escuela;
    
    @Constraints.Required(message="Debe ingresar su cuenta de usuario")
    public String user;

    @Constraints.Required(message="Debe ingresar su clave de usuario")
    public String password;

	@Constraints.Required(message="Debe ingresar su correo electronico")
    @Constraints.Email
    public String email;
	
	@Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date created;
    
    @Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date updated;
    
    // Generic query helper for entity with id Long
    public static Model.Finder<Long,Alumno> find = new Model.Finder<Long,Alumno>(Long.class, Alumno.class);
    
}

