package controllers;

import java.util.List;

import play.*;
import play.mvc.*;
import views.html.alumno.*;
import views.html.curso.*;
import views.html.home.*;
import models.*;
import play.data.*;

public class AlumnoController extends Controller {
	
	 
	 
	 public static Result listaAlu() {
	        //return ok(index.render(Alumno.find.all()));
		 return ok(listaAlu.render(Alumno.find.all()));
	  }
	 
	 public static Result lista_cursos(){
	    	return ok(listaCursos.render(Curso.find.all()));
	    }
	 
	 public static Result buscar_curso(){
		 Form<auxiliar> formulario = Form.form(auxiliar.class);
	        return ok(buscar_curso.render(formulario));
	 }
	 
	 public static Result mostrar_curso(){
		 Form<auxiliar> formulario = Form.form(auxiliar.class).bindFromRequest();
		  
	    	//if(formulario.hasErrors()) {
	          //  return badRequest(buscar.render(formulario));
	        //}
	    	
	    	Curso curso = Curso.find.where().eq("name",formulario.get().nombre).findUnique();
		        if(curso== null) {
		            flash("invalid", "No existe el curso ingresado");
		            return badRequest(buscar_curso.render(formulario));
		        }else{
		        	return ok(mostrar_curso.render(curso));
		        }
	 }
 // GET, formulario para un nuevo registro
    public static Result create() {
        Form<Alumno> formulario = Form.form(Alumno.class);
        return ok(create.render(formulario));
    }
    
    
 //POST
    public static Result save() {
        Form<Alumno> formulario = Form.form(Alumno.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(create.render(formulario));
        }
        formulario.get().created = new java.util.Date();
        formulario.get().updated = new java.util.Date();
        formulario.get().save();
        flash("success", "Alumno " + formulario.get().nombres + " creado con exito!");
        return redirect(routes.Home.login());
    }
    
        
    public static Result editar_perfil(){ 
    	return redirect(routes.AlumnoController.edit_perfil(Session_User_Alumno().id));
    }
    public static Result editar_password(){
    	return redirect(routes.AlumnoController.edit_password(Session_User_Alumno().id));
    }
    
    // GET, editar el registro
    public static Result edit_perfil(Long id) {
    	Form<Alumno> formulario = Form.form(Alumno.class).fill(Alumno.find.byId(id));
        return ok(edit_perfil.render(id, formulario));
    }
    public static Result edit_password(Long id){
    	Form<Login> LoginForm = Form.form(Login.class);
    	return ok(edit_password.render(id, LoginForm));
    }
    
    // POST, guardar el registro editado
    public static Result update_perfil(Long id) {
        Form<Alumno> formulario = Form.form(Alumno.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(edit_perfil.render(id, formulario));
        }
        formulario.get().updated = new java.util.Date();
        formulario.get().update(id);
        flash("success", "Alumno:  " + formulario.get().nombres + " actualizado con exito!");
        return redirect(routes.Home.inicio_alumno());
    }
    public static Result update_password(Long id){
    	Form<Login> formulario = Form.form(Login.class).bindFromRequest();

        // Debe ingresar los 3 datos
        if(formulario.get().clave_act == "" || formulario.get().clave_new == "" || formulario.get().clave_rep == "") {
            flash("invalid", "Debe ingresar las claves");
            return badRequest(edit_password.render(id ,formulario));
        }

        // La clave nueva y repeteida deben ser iguales
        if(!formulario.get().clave_new.equals(formulario.get().clave_rep)) {
            flash("invalid", "La clave nueva debe ser igual a la repetida");
            return badRequest(edit_password.render(id ,formulario));
        }

        // Busca el usuario logueado y compara la clave con la actual
        Alumno alumno = Alumno.find.where().eq("id",id).findUnique();
        if(alumno == null) {
            flash("invalid", "La clave actual no es la del usuario logueado");
            return badRequest(edit_password.render(id ,formulario));
        }

        // Todo correcto, se cambia la clave
       	alumno.password = formulario.get().clave_new;
        alumno.save();
        return redirect(routes.Home.inicio_alumno());
    }

    // POST, elimina registro
    public static Result delete(Long id) {
    	Alumno.find.ref(id).delete();
        flash("success", "Profesor ha sido eliminado!");
        return redirect(routes.ProfesorController.index());
    }
    
  //GET, buscar profesor
    public static Result buscar() {
        Form<auxiliar> formulario = Form.form(auxiliar.class);
        return ok(buscar.render(formulario));
    }
    
    //POST, postear datos del profesor
    public static Result mostrar() {
    	Form<auxiliar> formulario = Form.form(auxiliar.class).bindFromRequest();
  
    	//if(formulario.hasErrors()) {
          //  return badRequest(buscar.render(formulario));
        //}
    	
    	Alumno alumno = Alumno.find.where().eq("codigo",formulario.get().codigo).findUnique();
    		
	        if(alumno == null) {
	            flash("invalid", "Alumno no reigstrado con ese codigo");
	            return badRequest(buscar.render(formulario));
	        }else{
	        	return ok(mostrar.render(alumno));
	        }
        
    }
    public static Alumno Session_User_Alumno(){
    	return Alumno.find.where().eq("dni",session().get("login")).findUnique();
    }
    
}