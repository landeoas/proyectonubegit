package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity 
public class Noticia extends Model {

    @Id
    public Long id;
    
    @Constraints.Required(message="Debe ingresar el titulo")
    public String titulo;
    
    @Constraints.Required(message="Debe ingresar contenido")
    public String contenido;
    
    @Constraints.Required(message="Debe ingresar direccion de imagen")
    public String imagen;
    
    @Constraints.Required(message="Debe ingresar la E.A.P")
    public String escuela;
    
	@Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date created;
    
    @Formats.DateTime(pattern="dd-MM-yyyy - hh:mm")
    public Date updated;
    
    // Generic query helper for entity with id Long
    public static Model.Finder<Long,Noticia> find = new Model.Finder<Long,Noticia>(Long.class, Noticia.class);
    
}

