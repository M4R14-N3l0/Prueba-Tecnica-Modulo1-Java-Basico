package org.example;

import org.example.controllers.EmpleadoController;
import org.example.entities.Empleado;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {

    EmpleadoController empleadoController = new EmpleadoController();
    Scanner sca = new Scanner(System.in);

    while (true) {
        try {
            mostrarMenuPrincipal();
            Integer opcion = sca.nextInt();
            sca.nextLine();

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
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            sca.nextLine(); // Limpia el buffer en caso de error
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
        System.out.println("Introduce el nombre del empleado");
        empleado.setNombre(sca.nextLine());
        System.out.println("Introduce el apellido del empleado");
        empleado.setApellido(sca.nextLine());
        for (Empleado trabajador : empleados) {
            if (trabajador.getNombre().equals(empleado.getNombre()) && trabajador.getApellido().equals(empleado.getApellido())) {
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
        System.out.println("Introduce el nombre del empleado");
        empleado.setNombre(sca.nextLine());
        System.out.println("Introduce el apellido del empleado");
        empleado.setApellido(sca.nextLine());

        System.out.println("MENU: ");
        System.out.println("11: Cambiar nombre del empleado\n" +
                "12: Cambiar apellido del empleado\n" +
                "13: Cambiar cargo del empleado\n" +
                "14: Cambiar salario del empleado\n" +
                "15: Cambiar fecha de inicio del empleado\n");

        Integer opcion = sca.nextInt();
        sca.nextLine();
        while (true) {
            try {

                switch (opcion) {
                    case 1:
                        System.out.println("Introduce el nombre del empleado");
                        String nombre = sca.nextLine();
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getNombre().equals(empleado.getNombre()) && trabajador.getApellido().equals(empleado.getApellido())) {
                                Empleado actualizarEmpleado = empleadoController.findOne(trabajador.getId());
                                actualizarEmpleado.setNombre(nombre);
                                empleadoController.update(actualizarEmpleado);
                                System.out.println("El empleado ha sido actualizado");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Introduce el apellido del empleado");
                        String apellido = sca.nextLine();
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getNombre().equals(empleado.getNombre()) && trabajador.getApellido().equals(empleado.getApellido())) {
                                Empleado actualizarEmpleado = empleadoController.findOne(trabajador.getId());
                                actualizarEmpleado.setNombre(apellido);
                                empleadoController.update(actualizarEmpleado);
                                System.out.println("El empleado ha sido actualizado");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Introduce el Cargo del empleado");
                        String cargo = sca.nextLine();
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getNombre().equals(empleado.getNombre()) && trabajador.getApellido().equals(empleado.getApellido())) {
                                Empleado actualizarEmpleado = empleadoController.findOne(trabajador.getId());
                                actualizarEmpleado.setCargo(cargo);
                                empleadoController.update(actualizarEmpleado);
                                System.out.println("El empleado ha sido actualizado");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Introduce el Cargo del empleado");
                        Double salario = sca.nextDouble();
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getNombre().equals(empleado.getNombre()) && trabajador.getApellido().equals(empleado.getApellido())) {
                                Empleado actualizarEmpleado = empleadoController.findOne(trabajador.getId());
                                actualizarEmpleado.setSalario(salario);
                                empleadoController.update(actualizarEmpleado);
                                System.out.println("El empleado ha sido actualizado");
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
                        empleado.setFechaInicio(LocalDateTime.of(anno, mes, hora, dia, minutos));
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getNombre().equals(empleado.getNombre()) && trabajador.getApellido().equals(empleado.getApellido())) {
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
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                sca.nextLine(); // Limpia el buffer en caso de error)


            }
        }
    } catch (Exception e) {
        System.out.println("Error al actualizar empleado: " + e.getMessage());
    }
}

private static void buscarEmpleado(Scanner sca, EmpleadoController empleadoController) {
    try {
        System.out.println("MENU: ");

        System.out.println("6: Buscar un empleado por nombre\n" +
                "7: Buscar un empleado por apellido\n" +
                "8: Buscar un empleado por cargo\n" +
                "9: Buscar un empleado por sueldo\n" +
                "10: Buscar un empleado por fecha de inicio\n");


        Integer opcion = sca.nextInt();
        sca.nextLine();
        List<Empleado> empleados = empleadoController.findAll();
        Empleado empleado = new Empleado();

        while (true) {
            try {
                switch (opcion) {

                    case 1:
                        System.out.println("Introduce el nombre del empleado");
                        empleado.setNombre(sca.nextLine());
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getNombre().equals(empleado.getNombre())) {
                                System.out.println(trabajador);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Introduce el apellido del empleado");
                        empleado.setApellido(sca.nextLine());
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getApellido().equals(empleado.getApellido())) {
                                System.out.println(trabajador);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Introduce el cargo del empleado");
                        empleado.setCargo(sca.nextLine());
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getCargo().equals(empleado.getCargo())) {
                                System.out.println(trabajador);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Introduce el salario del empleado");
                        empleado.setSalario(sca.nextDouble());
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getSalario().equals(empleado.getSalario())) {
                                System.out.println(trabajador);
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
                        empleado.setFechaInicio(LocalDateTime.of(anno, mes, hora, dia, minutos));
                        for (Empleado trabajador : empleados) {
                            if (trabajador.getFechaInicio().equals(empleado.getFechaInicio())) {
                                System.out.println(trabajador);
                            }
                        }
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }

    } catch (Exception e) {
        System.out.println("Error al buscar empleado: " + e.getMessage());
    }
}

private static void agregarEmpleado(Scanner sca, EmpleadoController empleadoController) {
    try {
        Empleado empleado = new Empleado();

        System.out.println("Introduce el nombre del empleado");
        empleado.setNombre(sca.nextLine());
        System.out.println("Introduce el apellido del empleado");
        empleado.setApellido(sca.nextLine());
        System.out.println("Introduce el cargo del empleado");
        empleado.setCargo(sca.nextLine());
        System.out.println("Introduce el salario del empleado");
        empleado.setSalario(sca.nextDouble());
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

}






