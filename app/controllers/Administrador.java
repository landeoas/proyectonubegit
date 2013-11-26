package controllers;

import java.util.List;

import play.*;
import play.mvc.*;
import views.html.admin.*;
import models.*;
import play.data.*;

public class Administrador extends Controller {
	
    public static Result index() {
    	//List<Noticia> listNoticia = Noticia.find.all();
    	//session("user","samir mendoza");
    	//session("tipo","Administrador");
       // return ok(index.render(listNoticia));
    	return ok(index.render());
    	
    }
    

    //Opcion publicar en el menú de administrador
    public static Result publicar() {
    	List<Noticia> listNoticia = Noticia.find.all();
    	//session("user","samir mendoza");
    	//session("tipo","Administrador");
        return ok(publicar.render(listNoticia));
    }
    
 // GET, formulario para una nueva noticia a publicar
    public static Result create() {
        Form<Noticia> formulario = Form.form(Noticia.class);
        return ok(create.render(formulario));
    }
    
    
    public static Result save() {
        Form<Noticia> formulario = Form.form(Noticia.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(create.render(formulario));
        }
        formulario.get().created = new java.util.Date();
        formulario.get().updated = new java.util.Date();
        formulario.get().save();
        flash("success", "Noticia " + formulario.get().titulo + " creado con exito!");
        return redirect(routes.Administrador.publicar());
    }
    
 // GET, editar el registro
    public static Result edit(Long id) {
        Form<Noticia> formulario = Form.form(Noticia.class).fill(Noticia.find.byId(id));
        return ok(edit.render(id, formulario));
    }
    
    // POST, guardar el registro editado
    public static Result update(Long id) {
        Form<Noticia> formulario = Form.form(Noticia.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(edit.render(id, formulario));
        }
        formulario.get().updated = new java.util.Date();
        formulario.get().update(id);
        flash("success", "Noticia " + formulario.get().titulo + " actualizada con exito!");
        return redirect(routes.Administrador.index());
    }

    // POST, elimina registro
    public static Result delete(Long id) {
    	Noticia.find.ref(id).delete();
        flash("success", "Noticia ha sido eliminada!");
        return redirect(routes.Administrador.index());
    }
    
    
}