package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity 
public class Profesor extends Model {

    @Id
    public Long id;
    
    @Constraints.Required(message="Debe Ingresar el DNI")
    public Long dni;
    
    @Constraints.Required(message="Debe ingresar los nombres")
    public String nombres;
    
    @Constraints.Required(message="Debe ingresar los apellidos")
    public String apellidos;
    
    //@Formats.DateTime(pattern="dd/mm/yyyy")
    @Constraints.Required(message="Debe ingresar la fecha de nacimiento")
    public Date fecha;
    
    @Constraints.Required(message="Debe ingresar su correo electronico")
    @Constraints.Email
    public String email;
    
    @Constraints.Required(message="Debe ingresar su cuenta de usuario")
    public String user;

    @Constraints.Required(message="Debe ingresar su clave de usuario")
    public String password;
    
    @Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date created;
    
    @Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date updated;
    
    
    // Generic query helper for entity with id Long
    public static Model.Finder<Long,Profesor> find = new Model.Finder<Long,Profesor>(Long.class, Profesor.class);
    

    
    
}
