if (numEstudiantes == 0) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        System.out.println("\n--- Lista de Estudiantes ---");
                        for (int i = 0; i < numEstudiantes; i++) {
                            estudiantes[i].mostrarInfo();
                            System.out.println("-----------------------------");
                        }
                    }