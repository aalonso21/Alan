package pooAlumnosProfesores;
import java.util.Scanner;

public abstract class Persona {

	protected String nombre;
	protected String apellido;
	protected String telefono;
	protected String dni;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	public abstract void mostrarPersona();
	public abstract Persona alta(Scanner sc);
	
}
