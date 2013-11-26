package controllers;

import java.util.List;

import play.*;
import play.mvc.*;
import views.html.*;
import views.html.home.*;
import views.html.alumno.*;
import models.*;
import play.data.*;

public class Home extends Controller {
	static Form<Alumno> AlumnoForm = Form.form(Alumno.class);
	
    
    public static Result welcome(){
    	return ok(welcome.render());
    }
    
    
 // GET, formulario de login al sistema
    public static Result login() {
        session().clear();
        Form<Login> formulario = Form.form(Login.class);
        return ok(login.render(formulario));    
    }
    
    public static Result ingresar() {
        Form<Login> formulario = Form.form(Login.class).bindFromRequest();

        // Debe ingresar la el usuario y la clave
        if(formulario.get().login == "" || formulario.get().clave == "") {
            flash("invalid", "Debe ingresar usuario y clave");
            return badRequest(login.render(formulario));
        }
     // Busca el usuario por login y clave
        if(formulario.get().login.equals("Admin") && formulario.get().clave.equals("123")){
        	session("user", formulario.get().login);
        	return redirect(routes.Administrador.index());
        }
        else{
	        Alumno alumno = Alumno.find.where().eq("user", formulario.get().login).eq("password", formulario.get().clave).findUnique();
	        if(alumno == null) {
	        	Profesor profesor = Profesor.find.where().eq("user", formulario.get().login).eq("password", formulario.get().clave).findUnique();
	            if(profesor == null){
	            	flash("invalid", "Usuario y/o clave incorrecto/s");
	            	return badRequest(login.render(formulario));
	            }
	            else{
	            	session("id",profesor.id.toString());
	            	session("login",profesor.dni.toString());
		        	session("user", profesor.user);
                    session("tipoU","Profesor");
		        	session("folder","public/archivos/profesores/"+profesor.id.toString()+"/");
		        	return redirect(routes.ProfesorController.inicio_profesor());
	            }
	        }
	        else{
	        	// Login correcto, se setean las variables de session
	        	session("login",alumno.codigo.toString());
	        	session("user", alumno.user);
	        	session("tipoU","Alumno");
	        	return redirect(routes.Home.inicio_alumno());
	        }
        }

        
    }
    
    public static Result inicio_alumno() {
        return ok(inicio_alumno.render());
    }
    
   /* public static Result formulario() {
        return ok(formulario.render(AlumnoForm));
    }*/

    public static Result acerca_de() {
    	List<Noticia> listNoticia = Noticia.find.all();
        return ok(acerca_de.render(listNoticia));
    }

    public static Result salir(){
    	session().clear();
    	return redirect(routes.Home.login());
    }
    
    /*public static Result newAlumno(){
    	Form<Alumno> AF = AlumnoForm.bindFromRequest();
    	if(AF.hasErrors()){
    		return badRequest(formulario.render(AF));
    	}
    	else {
    		AF.get().created = new java.util.Date();
    		AF.get().updated = new java.util.Date();
    		AF.get().update(id);
    		flash("registrado","El alumno con codigo: "+AF.get().codigo+" ha sido registrado satisfactoriamente");
    		return redirect(routes.Home.login());  
  		}
    }*/
   
}