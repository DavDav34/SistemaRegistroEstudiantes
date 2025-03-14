import java.util.Scanner;

class Estudiante {
    String nombre;
    int edad;
    String matricula;
    String carrera;

    // estructura par un estudiante
    public Estudiante(String nombre, int edad, String matricula, String carrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
        this.carrera = carrera;
    }

    // metodo para mostrar informacion del estudiante
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Carrera: " + carrera);
    }
}

public class SistemaRegistroEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiante[] estudiantes = new Estudiante[100];
        int numEstudiantes = 0;
        int opcion;

        do {
            System.out.println("\n--- Sistema de Registro de Estudiantes ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante por matrícula");
            System.out.println("4. Eliminar estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Carrera: ");
                    String carrera = scanner.nextLine();

                    // Validar si ya existe un estudiante con la misma matrícula
                    boolean matriculaExistente = false;
                    for (int i = 0; i < numEstudiantes; i++) {
                        if (estudiantes[i].matricula.equals(matricula)) {
                            System.out.println("La matrícula ya está registrada.");
                            matriculaExistente = true;
                            break;
                        }
                    }

                    if (!matriculaExistente) {
                        Estudiante nuevoEstudiante = new Estudiante(nombre, edad, matricula, carrera);
                        estudiantes[numEstudiantes] = nuevoEstudiante;
                        numEstudiantes++;
                        System.out.println("Estudiante registrado con éxito.");
                    }
                    break;

                case 2:
                    if (numEstudiantes == 0) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        System.out.println("\n--- Lista de Estudiantes ---");
                        for (int i = 0; i < numEstudiantes; i++) {
                            estudiantes[i].mostrarInfo();
                            System.out.println("-----------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la matrícula a buscar: ");
                    String matriculaBuscar = scanner.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < numEstudiantes; i++) {
                        if (estudiantes[i].matricula.equals(matriculaBuscar)) {
                            estudiantes[i].mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la matrícula del estudiante a eliminar: ");
                    String matriculaEliminar = scanner.nextLine();
                    boolean eliminado = false;

                    for (int i = 0; i < numEstudiantes; i++) {
                        if (estudiantes[i].matricula.equals(matriculaEliminar)) {
                            for (int j = i; j < numEstudiantes - 1; j++) {
                                estudiantes[j] = estudiantes[j + 1];
                            }
                            numEstudiantes--;
                            eliminado = true;
                            System.out.println("Estudiante eliminado con éxito.");
                            break;
                        }
                    }

                    if (!eliminado) {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}