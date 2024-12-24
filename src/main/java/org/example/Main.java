            package org.example;

            import org.example.controllers.EmpleadoController;
            import org.example.entities.Empleado;
            import org.example.excepciones.OpcionInvalida;
            import org.example.excepciones.StringInvalido;
            import java.time.LocalDateTime;
            import java.time.format.DateTimeFormatter;
            import java.util.InputMismatchException;
            import java.util.List;
            import java.util.Objects;
            import java.util.Scanner;

            public class Main {
            public static void main(String[] args) throws OpcionInvalida {

                EmpleadoController empleadoController = new EmpleadoController();
                Scanner sca = new Scanner(System.in);

                while (true) {
                    try {
                        mostrarMenuPrincipal();
                        Integer opcion = sca.nextInt();
                        sca.nextLine();
                        validarOpcion(opcion); // Llamamos al metodo de validación
                        System.out.println("Has seleccionado la opción: " + opcion);

                        switch (opcion) {

                            case 1:
                                agregarEmpleado(sca, empleadoController);
                                break;
                            case 2:
                                buscarEmpleado(sca, empleadoController);
                                break;
                            case 3:
                                actualizarEmpleado(sca, empleadoController);
                                break;
                            case 4:
                                eliminarEmpleado(sca, empleadoController);
                                break;
                            case 5:
                                listarEmpleados(sca, empleadoController);
                                break;
                            default:
                                System.out.println("Opción inválida. Intente de nuevo.");
                        }
                        break;
                    } catch (OpcionInvalida e) {
                        // Capturamos y mostramos el error
                        System.out.println("Introduzca una opción valida");

                    } catch (InputMismatchException e) {
                        System.out.println("Introduzca una opción valida");
                        break;

                    }

                    }

                }

            private static void listarEmpleados(Scanner sca, EmpleadoController empleadoController) {
                try {
                    List<Empleado> empleados = empleadoController.findAll();

                    for (Empleado trabajador : empleados) {
                        System.out.println(trabajador);
                    }
                } catch (Exception e) {
                    System.out.println("Error al listar empleados: " + e.getMessage());
                }
            }

            private static void eliminarEmpleado(Scanner sca, EmpleadoController empleadoController) {
                try {
                    List<Empleado> empleados = empleadoController.findAll();
                    Empleado empleado = new Empleado();

                    while(true)
                        try
                        {
                            System.out.println("Introduce el nombre del empleado");
                            String entrada = sca.nextLine();
                            validarTexto(entrada); // Validamos la entrada
                            //System.out.println("La cadena ingresada es válida: " + entrada);
                            empleado.setNombre(entrada);
                            break;
                        } catch (StringInvalido e) {
                            // Capturamos y mostramos el error
                            System.err.println("No ingrese números");
                        }
                    while(true)
                        try
                        {
                            System.out.println("Introduce el apellido del empleado");
                            String entrada = sca.nextLine();
                            validarTexto(entrada); // Validamos la entrada
                            //System.out.println("La cadena ingresada es válida: " + entrada);
                            empleado.setApellido(entrada);
                            break;

                        } catch (StringInvalido e) {
                            // Capturamos y mostramos el error
                            System.err.println("No ingrese números");


                        }
                    for (Empleado trabajador : empleados) {
                        if (trabajador.getNombre().equalsIgnoreCase(empleado.getNombre()) && trabajador.getApellido().equalsIgnoreCase(empleado.getApellido())) {
                            Integer idEliminar = trabajador.getId();
                            empleadoController.delete(idEliminar);
                            System.out.println("El empleado ha sido eliminado");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error al eliminar empleado: " + e.getMessage());
                }
            }

            private static void actualizarEmpleado(Scanner sca, EmpleadoController empleadoController) {
                try {
                    List<Empleado> empleados = empleadoController.findAll();
                    Empleado empleado = new Empleado();

                    while(true)
                        try
                        {
                            System.out.println("Introduce el nombre del empleado");
                            String entrada = sca.nextLine();
                            validarTexto(entrada); // Validamos la entrada
                            //System.out.println("La cadena ingresada es válida: " + entrada);
                            empleado.setNombre(entrada);
                            break;
                        } catch (StringInvalido e) {
                            // Capturamos y mostramos el error
                            System.err.println("No ingrese números");
                        }
                    while(true)
                        try
                        {
                            System.out.println("Introduce el apellido del empleado");
                            String entrada = sca.nextLine();
                            validarTexto(entrada); // Validamos la entrada
                            //System.out.println("La cadena ingresada es válida: " + entrada);
                            empleado.setApellido(entrada);
                            break;

                        } catch (StringInvalido e) {
                            // Capturamos y mostramos el error
                            System.err.println("No ingrese números");
                        }

                    System.out.println("MENU: ");
                    System.out.println("1: Cambiar nombre del empleado\n" +
                            "2: Cambiar apellido del empleado\n" +
                            "3: Cambiar cargo del empleado\n" +
                            "4: Cambiar salario del empleado\n" +
                            "5: Cambiar fecha de inicio del empleado\n");


                        while (true) {
                            try {
                                Integer opcion = sca.nextInt();
                                sca.nextLine();
                                validarOpcion(opcion); // Llamamos al metodo de validación
                                System.out.println("Has seleccionado la opción: " + opcion);

                                switch (opcion) {
                                    case 1:

                                        while(true){
                                            try
                                            {
                                                System.out.println("Introduce el nombre del empleado");
                                                String entrada = sca.nextLine();
                                                validarTexto(entrada); // Validamos la entrada
                                                //System.out.println("La cadena ingresada es válida: " + entrada);
                                                //empleado.setNombre(entrada);
                                                for (Empleado trabajador : empleados) {
                                                    if (trabajador.getNombre().equalsIgnoreCase(empleado.getNombre()) && trabajador.getApellido().equalsIgnoreCase(empleado.getApellido())) {
                                                        Empleado actualizarEmpleado = empleadoController.findOne(trabajador.getId());
                                                        actualizarEmpleado.setNombre(entrada);
                                                        empleadoController.update(actualizarEmpleado);
                                                        System.out.println("El empleado ha sido actualizado");
                                                    }
                                                }
                                                break;
                                            } catch (StringInvalido e) {
                                                // Capturamos y mostramos el error
                                                System.err.println("No ingrese números");
                                            }
                                        }
                                        break;
                                    case 2:

                                        while(true){
                                            try
                                            {
                                                System.out.println("Introduce el apellido del empleado");
                                                String entrada = sca.nextLine();
                                                validarTexto(entrada); // Validamos la entrada
                                                //System.out.println("La cadena ingresada es válida: " + entrada);
                                                //empleado.setNombre(entrada);
                                                for (Empleado trabajador : empleados) {
                                                    if (trabajador.getNombre().equalsIgnoreCase(empleado.getNombre()) && trabajador.getApellido().equalsIgnoreCase(empleado.getApellido())) {
                                                        Empleado actualizarEmpleado = empleadoController.findOne(trabajador.getId());
                                                        actualizarEmpleado.setApellido(entrada);
                                                        empleadoController.update(actualizarEmpleado);
                                                        System.out.println("El empleado ha sido actualizado");
                                                    }
                                                }
                                                break;
                                            } catch (StringInvalido e) {
                                                // Capturamos y mostramos el error
                                                System.err.println("No ingrese números");
                                            }
                                        }
                                        break;

                                    case 3:
                                        while(true){
                                            try
                                            {
                                                System.out.println("Introduce el cargo del empleado");
                                                String entrada = sca.nextLine();
                                                validarTexto(entrada); // Validamos la entrada
                                                //System.out.println("La cadena ingresada es válida: " + entrada);
                                                //empleado.setNombre(entrada);
                                                for (Empleado trabajador : empleados) {
                                                    if (trabajador.getNombre().equalsIgnoreCase(empleado.getNombre()) && trabajador.getApellido().equalsIgnoreCase(empleado.getApellido())) {
                                                        Empleado actualizarEmpleado = empleadoController.findOne(trabajador.getId());
                                                        actualizarEmpleado.setCargo(entrada);
                                                        empleadoController.update(actualizarEmpleado);
                                                        System.out.println("El empleado ha sido actualizado");
                                                    }
                                                }
                                                break;
                                            } catch (StringInvalido e) {
                                                // Capturamos y mostramos el error
                                                System.err.println("No ingrese números");
                                            }
                                        }
                                        //sca.nextLine();


                                        break;


                                    case 4:
                                        boolean entradaValida = false;
                                        while (!entradaValida) {
                                            System.out.println("Introduce el Salario del empleado:");

                                            if (sca.hasNextDouble()) { // Verifica si la entrada es un double
                                                Double salario = sca.nextDouble(); // Lee el número
                                                entradaValida = true; // Marca la entrada como válida
                                                for (Empleado trabajador : empleados) {
                                                    if (trabajador.getNombre().equalsIgnoreCase(empleado.getNombre()) && trabajador.getApellido().equalsIgnoreCase(empleado.getApellido())) {
                                                        Empleado actualizarEmpleado = empleadoController.findOne(trabajador.getId());
                                                        actualizarEmpleado.setSalario(salario);
                                                        empleadoController.update(actualizarEmpleado);
                                                        System.out.println("El empleado ha sido actualizado");
                                                    }
                                                }
                                            } else {
                                                System.err.println("Error: La entrada no es un número decimal válido.");
                                                sca.next(); // Descartar la entrada inválida
                                            }
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Introduce la fecha de inicio del empleado");
                                        System.out.println("año");
                                        Integer anno = sca.nextInt();
                                        System.out.println("mes");
                                        Integer mes = sca.nextInt();
                                        System.out.println("día");
                                        Integer dia = sca.nextInt();
                                        System.out.println("hora");
                                        Integer hora = sca.nextInt();
                                        System.out.println("minutos");
                                        Integer minutos = sca.nextInt();
                                        sca.nextLine();
                                        empleado.setFechaInicio(LocalDateTime.of(anno, mes, hora, dia, minutos));
                                        for (Empleado trabajador : empleados) {
                                            if (trabajador.getNombre().equalsIgnoreCase(empleado.getNombre()) && trabajador.getApellido().equalsIgnoreCase(empleado.getApellido())) {
                                                Empleado actualizarEmpleado = empleadoController.findOne(trabajador.getId());
                                                actualizarEmpleado.setFechaInicio(empleado.getFechaInicio());
                                                empleadoController.update(actualizarEmpleado);
                                                System.out.println("El empleado ha sido actualizado");
                                            }
                                        }
                                        break;
                                    default:
                                        System.out.println("Opción inválida.");
                                }
                                break;
                            } catch (OpcionInvalida e) {
                                // Capturamos y mostramos el error
                                System.out.println("Introduzca una opción valida");
                            }
                        }

                } catch (Exception e) {
                    System.out.println("Error al actualizar empleado: " + e.getMessage());
                }
            }

            private static void buscarEmpleado(Scanner sca, EmpleadoController empleadoController) {
                try {
                    System.out.println("MENU: ");

                    System.out.println("1: Buscar un empleado por nombre\n" +
                            "2: Buscar un empleado por apellido\n" +
                            "3: Buscar un empleado por cargo\n" +
                            "4: Buscar un empleado por sueldo\n" +
                            "5: Buscar un empleado por fecha de inicio\n");

                    while (true) {

                        try{

                            Integer opcion = sca.nextInt();
                            sca.nextLine();
                            validarOpcion(opcion); // Llamamos al metodo de validación
                            System.out.println("Has seleccionado la opción: " + opcion);
                            List<Empleado> empleados = empleadoController.findAll();
                            Empleado empleado = new Empleado();

                            switch (opcion) {

                                case 1:
                                    while(true){
                                        try
                                        {
                                            System.out.println("Introduce el nombre del empleado");
                                            String entrada = sca.nextLine();
                                            validarTexto(entrada); // Validamos la entrada
                                            //System.out.println("La cadena ingresada es válida: " + entrada);
                                            empleado.setNombre(entrada);
                                            for (Empleado trabajador : empleados) {
                                                if (trabajador.getNombre().equals(empleado.getNombre())) {
                                                    System.out.println(trabajador);
                                                }
                                            }
                                            break;
                                        } catch (StringInvalido e) {
                                            // Capturamos y mostramos el error
                                            System.err.println("No ingrese números");
                                        }
                                    }
                                    //sca.nextLine();


                                    break;

                                case 2:
                                    while(true){
                                        try
                                        {
                                            System.out.println("Introduce el apellido del empleado");
                                            String entrada = sca.nextLine();
                                            validarTexto(entrada); // Validamos la entrada
                                            //System.out.println("La cadena ingresada es válida: " + entrada);
                                            empleado.setApellido(entrada);
                                            for (Empleado trabajador : empleados) {
                                                if (trabajador.getApellido().equals(empleado.getApellido())) {
                                                    System.out.println(trabajador);
                                                }
                                            }
                                            break;
                                        } catch (StringInvalido e) {
                                            // Capturamos y mostramos el error
                                            System.err.println("No ingrese números");
                                        }
                                    }
                                    //sca.nextLine();


                                    break;

                                case 3:
                                    while(true){
                                        try
                                        {
                                            System.out.println("Introduce el cargo del empleado");
                                            String entrada = sca.nextLine();
                                            validarTexto(entrada); // Validamos la entrada
                                            //System.out.println("La cadena ingresada es válida: " + entrada);
                                            empleado.setCargo(entrada);
                                            for (Empleado trabajador : empleados) {
                                                if (trabajador.getCargo().equals(empleado.getCargo())) {
                                                    System.out.println(trabajador);
                                                }
                                            }
                                            break;
                                        } catch (StringInvalido e) {
                                            // Capturamos y mostramos el error
                                            System.err.println("No ingrese números");
                                        }
                                    }
                                    //sca.nextLine();


                                    break;

                                case 4:
                                    boolean entradaValida = false;

                                    while (!entradaValida) {
                                        System.out.println("Introduce el Salario del empleado");
                                        sca.nextDouble();
                                        sca.nextLine();

                                        if (sca.hasNextDouble()) { // Verifica si la entrada es un double
                                            Double salario = sca.nextDouble(); // Lee el número
                                            entradaValida = true; // Marca la entrada como válida
                                            empleado.setSalario(salario);
                                            for (Empleado trabajador : empleados) {
                                                if (Objects.equals(trabajador.getSalario(), empleado.getSalario())) {
                                                    System.out.println(trabajador);
                                                }
                                            }
                                        } else {
                                            System.err.println("Error: La entrada no es un número decimal válido.");
                                            sca.next(); // Descartar la entrada inválida
                                        }
                                    }

                                    break;

                                case 5:
                                    System.out.println("Introduce la fecha de inicio del empleado");
                                    System.out.println("año");
                                    Integer anno = sca.nextInt();
                                    System.out.println("mes");
                                    Integer mes = sca.nextInt();
                                    System.out.println("día");
                                    Integer dia = sca.nextInt();
                                    System.out.println("hora");
                                    Integer hora = sca.nextInt();
                                    System.out.println("minutos");
                                    Integer minutos = sca.nextInt();
                                    empleado.setFechaInicio(LocalDateTime.of(anno, mes, dia, hora, minutos));
                                    LocalDateTime fecha = empleado.getFechaInicio();
                                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                    String fechaInicio = fecha.format(formato);
                                    System.out.println(fechaInicio);
                                    for (Empleado trabajador : empleados) {
                                        LocalDateTime fechaInicio2 =trabajador.getFechaInicio();
                                        String fechaInicio3=fechaInicio2.format(formato);
                                        System.out.println(fechaInicio3);
                                        if (fechaInicio3.equals(fechaInicio)){
                                            System.out.println(trabajador);
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Opción inválida.");
                            }
                            break;
                        }
                        catch (OpcionInvalida e) {
                            // Capturamos y mostramos el error
                            System.out.println("Introduzca una opción valida");
                        }}

                } catch (Exception e) {
                    System.out.println("Error al buscar empleado: " + e.getMessage());
               }
            }

            private static void agregarEmpleado(Scanner sca, EmpleadoController empleadoController) {
                try {
                    Empleado empleado = new Empleado();
                    while(true)
                        try
                        {
                            System.out.println("Introduce el nombre del empleado");
                            String entrada = sca.nextLine();
                            validarTexto(entrada); // Validamos la entrada
                            //System.out.println("La cadena ingresada es válida: " + entrada);
                            empleado.setNombre(entrada);
                            break;
                        } catch (StringInvalido e) {
                            // Capturamos y mostramos el error
                            System.err.println("No ingrese números");
                        }
                    while(true)
                        try
                        {
                            System.out.println("Introduce el apellido del empleado");
                            String entrada = sca.nextLine();
                            validarTexto(entrada); // Validamos la entrada
                            //System.out.println("La cadena ingresada es válida: " + entrada);
                            empleado.setApellido(entrada);
                            break;
                        } catch (StringInvalido e) {
                            // Capturamos y mostramos el error
                            System.err.println("No ingrese números");
                        }

                    while(true)
                        try
                        {
                            System.out.println("Introduce el cargo del empleado");
                            String entrada = sca.nextLine();
                            validarTexto(entrada); // Validamos la entrada
                            //System.out.println("La cadena ingresada es válida: " + entrada);
                            empleado.setCargo(entrada);
                            break;
                        } catch (StringInvalido e) {
                            // Capturamos y mostramos el error
                            System.err.println("No ingrese números");
                        }
                    boolean entradaValida = false;
                    while (!entradaValida) {
                        System.out.println("Introduce el Salario del empleado:");

                        if (sca.hasNextDouble()) { // Verifica si la entrada es un double
                            double salario = sca.nextDouble(); // Lee el número
                            empleado.setSalario(salario); // Establece el salario
                            entradaValida = true; // Marca como entrada válida
                        } else {
                            System.out.println("La entrada no es un número decimal válido. Inténtalo de nuevo.");
                            sca.next(); // Descarta la entrada inválida
                        }
                    }

                    System.out.println("Introduce la fecha de inicio del empleado paso por paso");
                    System.out.println("año");
                    Integer anno = sca.nextInt();
                    System.out.println("mes");
                    Integer mes = sca.nextInt();
                    System.out.println("día");
                    Integer dia = sca.nextInt();
                    System.out.println("hora");
                    Integer hora = sca.nextInt();
                    System.out.println("minutos");
                    Integer minutos = sca.nextInt();
                    empleado.setFechaInicio(LocalDateTime.of(anno, mes, hora, dia, minutos));
                    empleadoController.create(empleado);
                    System.out.println("El empleado ha sido creado");
                } catch (Exception e) {
                    System.out.println("Error al agregar empleado: " + e.getMessage());
                }
            }

            private static void mostrarMenuPrincipal() {
                System.out.println("MENU: ");
                System.out.println("1: Agregar un empleado\n" +
                        "2: Buscar un empleado\n" +
                        "3: Cambiar un dato de un empleado\n" +
                        "4: Eliminar un empleado\n" +
                        "5: Listar todos los empleados\n" +
                        "Seleccione una opción");
            }

                // Metodo que valida la entrada del usuario
                public static void validarOpcion(Integer opcion) throws OpcionInvalida {
                    String opcion2=opcion.toString();
                    if (!opcion2.matches("[1-5]")) { // Solo permite "1", "2", o "3"...
                        throw new OpcionInvalida("Debe introducir una opción válida: 1, 2, 3, 4 o 5");
                        }
                }

                public static void validarTexto(String texto) throws StringInvalido {
                    if (texto.matches(".*\\d.*")) { // Verifica si contiene cualquier dígito
                        throw new StringInvalido("No inserte números. Inténtelo nuevamente.");
                    }
                }
            }