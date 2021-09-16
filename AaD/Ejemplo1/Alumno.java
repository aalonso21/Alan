package pooAlumnosProfesores;
import java.util.Scanner;

public class Alumno extends Persona{
	
	protected String curso;
	protected int nota;
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public Alumno() {
		
	}
	
	public Alumno(String nombre, String apellido, String telefono, String dni, String curso, int nota) {
		setNombre(nombre);
		setApellido(apellido);
		setTelefono(telefono);
		setDni(dni);
		this.curso=curso;
		this.nota=nota;
	}
	
	@Override
	public void mostrarPersona() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
		System.out.println("Teléfono: "+telefono);
		System.out.println("DNI: "+dni);
		System.out.println("Curso: "+curso);
		System.out.println("Nota: "+nota);
	}
	
	public Alumno alta(Scanner sc) {
		
		sc.nextLine();
		System.out.println("Introduzca los datos del alumno:\nNombre:");
		nombre = sc.nextLine();
		System.out.println("Apellido:");
		apellido = sc.nextLine();
		System.out.println("Teléfono:");
		telefono = sc.next();
		System.out.println("DNI:");
		dni = sc.next();
		System.out.println("Curso (1 o 2):");
		curso = sc.next();
		System.out.println("Nota:");
		nota=sc.nextInt();

		Alumno alumno = new Alumno(nombre, apellido, telefono, dni, curso, nota);
		return alumno;
	}
}
