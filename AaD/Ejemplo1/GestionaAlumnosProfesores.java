package pooAlumnosProfesores;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionaAlumnosProfesores{

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		ArrayList<Alumno> alumnos = new ArrayList<>();
		ArrayList<Profesor> profesores = new ArrayList<>();
		menu(sc, alumnos, profesores);

	}

	public static void menu(Scanner sc, ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores) {
		int elegir=0;
		char repetir='n';

		do {
			System.out.println("�Qu� quieres hacer? Introduce el n�mero de la opci�n que quieras.");
			System.out.println("1- A�adir un nuevo alumno.");
			System.out.println("2- A�adir un nuevo profesor.");
			System.out.println("3- Comprobar la cantidad de alumnos matriculados en primero y en segundo.");
			System.out.println("4- Comprobar porcentaje de alumnos aprobados por curso.");
			System.out.println("5- Obtener el profesor tutor con m�s asignaturas.");
			System.out.println("6- Mostrar la informaci�n de todos los alumnos del centro.");
			System.out.println("7- Mostrar la informaci�n todos los profesores del centro.");
			System.out.println("0- Terminar el programa.");

			do {
				elegir=sc.nextInt();

				if(elegir<0||elegir>5) {
					System.out.println("Error, introduce una opci�n correcta.");
				}

			}while(elegir<0||elegir>7);

			switch(elegir){

			case 0:
				break;
			case 1:
				alumnos.add(nuevoAlumno(sc));
				break;
			case 2:
				profesores.add(nuevoProfesor(sc));
				break;
			case 3:
				cantidadMatriculados(alumnos);
				break;
			case 4:
				calcularAprobados(alumnos);
				break;
			case 5:
				obtenerTutor(profesores);
				break;
			case 6:
				mostrarAlumnos(alumnos);
				break;
			case 7:
				mostrarProfesores(profesores);
				break;
			default:
				break;
			}

			if(elegir!=0) {
				do {
					System.out.println("Escribe S para volver al men� o N para finalizar el programa.");

					repetir=sc.next().charAt(0);
					if(repetir!='s'&&repetir!='S'&&repetir!='n'&&repetir!='N') {
						System.out.println("Error.");
					}
				}while(repetir!='s'&&repetir!='S'&&repetir!='n'&&repetir!='N');

			}
		}while(repetir=='s'||repetir=='S');

		System.out.println("Fin del programa.");
	}

	public static Alumno nuevoAlumno(Scanner sc) {

		Alumno alumno = new Alumno().alta(sc);
		return alumno;
	}

	public static Profesor nuevoProfesor(Scanner sc) {
		Profesor profesor = new Profesor().alta(sc);
		return profesor;
	}

	private static void cantidadMatriculados(ArrayList<Alumno> alumnos) {
		int cantidad1=0;
		int cantidad2=0;
		Alumno alumno;

		for(int i=0;i<alumnos.size();i++) {
			alumno=alumnos.get(i);

			if (alumno.getCurso().equals("1")||alumno.getCurso().equalsIgnoreCase("primero")) {
				cantidad1++;

			}else if(alumno.getCurso().equals("2")||alumno.getCurso().equalsIgnoreCase("segundo")) {
				cantidad2++;
			}
		}
		System.out.println("Cantidad de alumnos matriculados:");
		System.out.println("Primer curso:"+cantidad1);
		System.out.println("Segundo curso:"+cantidad2);
	}

	public static void calcularAprobados(ArrayList<Alumno> alumnos) {
		float porcentaje1=0;
		float porcentaje2=0;
		int cont1=0;
		int cont2=0;
		int aprobados1=0;
		int aprobados2=0;

		if(alumnos.size()==0) {
			System.out.println("No hay alumnos matriculados en ning�n curso.");
		}else {
			for(int i=0;i<alumnos.size();i++) {
				if(alumnos.get(i).getCurso().equals("1")||alumnos.get(i).getCurso().equalsIgnoreCase("primero")) {
					cont1++;
					if(alumnos.get(i).getNota()>=5) {
						aprobados1++;
					}
				}else if(alumnos.get(i).getCurso().equals("2")||alumnos.get(i).getCurso().equalsIgnoreCase("segundo")) {
					cont2++;
					if(alumnos.get(i).getNota()>=5) {
						aprobados2++;
					}
				}
			}

			porcentaje1=aprobados1/cont1*100;
			porcentaje2=aprobados2/cont2*100;
			System.out.println("Porcentajes de aprobados de ambos cursos:");
			System.out.println("Primer curso: "+porcentaje1+"%");
			System.out.println("Segundo curso: "+porcentaje2+"%");
		}

	}

	public static void obtenerTutor(ArrayList<Profesor> profesores) {
		int cantidadMax=0;

		for(int i=0;i<profesores.size();i++) {
			if(profesores.get(i).isEsTutor() && profesores.get(i).getCantidadAsignatura()>cantidadMax) {
				cantidadMax=profesores.get(i).getCantidadAsignatura();
			}
		}

		if(profesores.size() == 0) {
			System.out.println("Todav�a no se han introducido profesores.");
		}else {
			System.out.println("Tutor/tutores con el mayor n�mero de asignaturas:");

			for(int i=0;i<profesores.size();i++) {
				if(profesores.get(i).getCantidadAsignatura()==cantidadMax) {
					System.out.println(profesores.get(i).getNombre()+" "+profesores.get(i).getApellido());
				}
			}
		}
	}

	public static void mostrarAlumnos(ArrayList<Alumno> alumnos) {
		if(alumnos.size()==0) {
			System.out.println("No hay ning�n alumno matriulado.");
		}else {
			for(int i = 0;i < alumnos.size();i++) {
				System.out.println("\nAlumno "+(i+1)+":");
				alumnos.get(i).mostrarPersona();
			}
		}
	}

	public static void mostrarProfesores(ArrayList<Profesor> profesores) {
		if(profesores.size()==0) {
			System.out.println("No hay ning�n profesor.");
		}else {
			for(int i = 0; i < profesores.size(); i++) {
				System.out.println("\nProfesor "+(i+1)+":");
				profesores.get(i).mostrarPersona();
			}
		}
	}
}
