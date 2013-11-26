package controllers;

import java.util.List;
import play.*;
import play.mvc.*;
import views.html.profesor.*;
import views.html.curso.*;
import views.html.clase.*;
import models.*;
import play.data.*;
import java.io.File;


public class ProfesorController extends Controller {
	//private FileCopy fc;
	
	 public static Result index() {
	        return ok(index.render(Profesor.find.all()));
	 }
 // GET, formulario para un nuevo registro
    public static Result inicio_profesor(){
    	return ok(inicio_profesor.render());
    }
	 
	 public static Result create() {
        Form<Profesor> formulario = Form.form(Profesor.class);
        return ok(create.render(formulario));
    }
 //POST
    public static Result save() {
        Form<Profesor> formulario = Form.form(Profesor.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(create.render(formulario));
        }
        formulario.get().created = new java.util.Date();
        formulario.get().updated = new java.util.Date();
        formulario.get().save();
        File repo= new File("public/archivos/profesores/"+formulario.get().id.toString());
        repo.mkdirs();
        flash("success", "Profesor " + formulario.get().nombres + " creado con exito!");
        return redirect(routes.ProfesorController.index());
    }
    
 // GET, editar el registro
    public static Result edit(Long id) {
        Form<Profesor> formulario = Form.form(Profesor.class).fill(Profesor.find.byId(id));
        return ok(edit.render(id, formulario));
    }
    
    // POST, guardar el registro editado
    public static Result update(Long id) {
        Form<Profesor> formulario = Form.form(Profesor.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(edit.render(id, formulario));
        }
        formulario.get().updated = new java.util.Date();
        formulario.get().update(id);
        flash("success", "Profesor " + formulario.get().nombres + " actualizado con exito!");
        return redirect(routes.ProfesorController.index());
    }

    // POST, elimina registro
    public static Result delete(Long id) {
    	Profesor.find.ref(id).delete();
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
    	
    	Profesor profesor = Profesor.find.where().eq("dni",formulario.get().dni).findUnique();
    		
	        if(profesor == null) {
	        	System.out.print("entro1");
	            flash("invalid", "Profesor no registrado con ese DNI");
	            return badRequest(buscar.render(formulario));
	        }else{
	        	System.out.print(profesor.email+"mostro");
	        	return ok(mostrar.render(profesor));
	        }
        
    }
    
    public static Result create_curso(){
    	Form<Curso> formulario = Form.form(Curso.class);
        return ok(create_curso.render(formulario));
    }
    
    public static Result save_curso(){
    	Form<Curso> formulario = Form.form(Curso.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(create_curso.render(formulario));
        }
        //formulario.get().ciclo = Integer.parseInt(formulario.get().ciclo);
        //formulario.get().creditos.toInteger();
        formulario.get().created = new java.util.Date();
        formulario.get().updated = new java.util.Date();
        //formulario.get().profesor= Curso.getProfesor(Session_User_Profesor().id);
        formulario.get().profesor = Session_User_Profesor();
        formulario.get().save();
        flash("success", "Curso " + formulario.get().name + " creado con exito!");
        return redirect(routes.ProfesorController.inicio_profesor());
    }
    
    public static Profesor Session_User_Profesor(){
    	return Profesor.find.where().eq("dni",session().get("login")).findUnique();
    }
    
    public static Result gestion_cursos(){
    	List<Curso> cursos = Curso.find.where().eq("profesor_id",Session_User_Profesor().id).findList(); 
    	return ok(gestion_cursos.render(cursos));
    }
    public static Result gestion_curso(Long id){
    	Curso curso = Curso.find.where().eq("id",id).findUnique();
    	List<Clase> clases = Clase.find.where().eq("curso_id",id).findList();
    	return ok(gestion_curso.render(curso, clases));
    }
    
    public static Result create_clase(Long id){
    	Form<Clase> formulario = Form.form(Clase.class);
    	Curso curso = Curso.find.where().eq("id",id).findUnique();
    	return ok(create_clase.render(curso, formulario));
    }
    
    @BodyParser.Of(BodyParser.MultipartFormData.class)
    public static Result save_clase(Long id){
    	Form<Clase> formulario = Form.form(Clase.class).bindFromRequest();
    	if(formulario.hasErrors()) {
    		Curso curso = Curso.find.where().eq("id",id).findUnique();
            return badRequest(create_clase.render(curso,formulario));
        }
        //
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart archivo = body.getFile("FILE");
        if (archivo != null) {
            String fileName = archivo.getFilename();
            formulario.get().file=fileName;
            String contentType = archivo.getContentType(); 
            File file = archivo.getFile();
            //fc = new FileCopy(file.getAbsolutePath(),session().get("folder"));
        } else {
            Curso curso = Curso.find.where().eq("id",id).findUnique();
            return badRequest(create_clase.render(curso,formulario));  
        }
        //

    	formulario.get().created = new java.util.Date();
        formulario.get().updated = new java.util.Date();
        formulario.get().curso = Clase.getCurso(id);
        formulario.get().save();
        flash("success", "Clase " + formulario.get().titulo + " creada con exito!");
        return redirect(routes.ProfesorController.gestion_curso(id));
    }
    
    public static Result edit_clase(Long id){
    	return ok("TODO");
    }
    
    public static Result update_clase(Long id){
    	return ok("TODO");
    }
    
    public static Result delete_clase(Long id){
    	Clase.find.ref(id).delete();
        flash("success", "Clase eliminada");
        return redirect(routes.ProfesorController.gestion_curso(id));
    }
    
    public static Result download_clase(Long id){
    	return ok("TODO");
    }
}