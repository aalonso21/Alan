package pooAlumnosProfesores;
import java.util.Scanner;

public class Profesor extends Persona{
	
	private boolean esTutor;
	private int cantidadAsignatura;
	
	public boolean isEsTutor() {
		return esTutor;
	}
	public void setEsTutor(boolean esTutor) {
		this.esTutor = esTutor;
	}
	public int getCantidadAsignatura() {
		return cantidadAsignatura;
	}
	public void setCantidadAsignatura(int cantidadAsignatura) {
		this.cantidadAsignatura = cantidadAsignatura;
	}
	
	public Profesor() {
		
	}
	
	public Profesor(String nombre, String apellido, String telefono, String dni, boolean esTutor, int cantidadAsignaturas) {
		setNombre(nombre);
		setApellido(apellido);
		setTelefono(telefono);
		setDni(dni);
		setEsTutor(esTutor);
		setCantidadAsignatura(cantidadAsignaturas);

	}
	
	@Override
	public void mostrarPersona() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
		System.out.println("Teléfono: "+telefono);
		System.out.println("DNI: "+dni);
		if(esTutor) {
			System.out.println("Es tutor");
		}else {
			System.out.println("No es tutor");
		}
		System.out.println("Cantidad de asignaturas: "+cantidadAsignatura);
	}
	
	public Profesor alta(Scanner sc) {
		
		char eleccion;

		sc.nextLine();
		System.out.println("Introduzca los datos del alumno:\nNombre:");
		this.nombre = sc.nextLine();
		System.out.println("Apellido:");
		this.apellido = sc.nextLine();
		System.out.println("Teléfono:");
		this.telefono = sc.next();
		System.out.println("DNI:");
		this.dni = sc.next();
		System.out.println("¿El profesor es tutor?(s/n):");
		eleccion=sc.next().charAt(0);
		if(eleccion=='s'||eleccion=='S') {
			esTutor=true;
		}else {
			esTutor=false;
		}
		System.out.println("Cantidad de asignaturas:");
		this.cantidadAsignatura=sc.nextInt();

		Profesor profesor = new Profesor(nombre, apellido, telefono, dni, esTutor, cantidadAsignatura);
		
		return profesor;
	}
	
}
