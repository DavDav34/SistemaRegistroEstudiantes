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