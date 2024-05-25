package edu.cibertec.jpa;

import Models.CRUD;
import Models.Employees;

public class SampleJPA {

    public static void main(String[] args) {
        // Para probar cada método, descomenta la llamada al método correspondiente
        
    	// listar();
        // insertar(3, "1990-01-01", "John", "Doe", 'M', "2020-01-01");
        // buscarPorId(4);
        // actualizar(1, "1964-06-02", "Josesito", "Hibrevloxk", 'M', "1986-12-01");
        // eliminar(10004);
    }

    // LISTAR
    public static void listar() {
        CRUD operaciones = new CRUD();
        for (Employees e : operaciones.seleccionarTodo()) {
            System.out.println(e);
        }
    }

    // INSERTAR
    public static void insertar(int emp_no, String birthDate, String firstName, String lastName, char gender, String hireDate) {
        CRUD operaciones = new CRUD();
        Employees nuevoEmpleado = new Employees(emp_no, birthDate, firstName, lastName, gender, hireDate);
        operaciones.insertar(nuevoEmpleado);
        System.out.println("EMPLEADO AGREGADO CORRECTAMENTE");
    }

    // BUSCAR POR ID
    public static void buscarPorId(int id) {
        CRUD operaciones = new CRUD();
        Employees empleado = operaciones.buscar(id);
        if (empleado != null) {
            System.out.println(empleado);
        } else {
            System.out.println("EMPLEADO NO ENCONTRADO");
        }
    }

    // ACTUALIZAR
    public static void actualizar(int id, String birthDate, String firstName, String lastName, char gender, String hireDate) {
        CRUD operaciones = new CRUD();
        Employees empleado = operaciones.buscar(id);
        if (empleado != null) {
            empleado.setBirth_date(birthDate);
            empleado.setFirst_name(firstName);
            empleado.setLast_name(lastName);
            empleado.setGender(gender);
            empleado.setHire_date(hireDate);
            operaciones.actualizar(empleado);
            System.out.println("EMPLEADO ACTUALIZADO CORRECTAMENTE");
        } else {
            System.out.println("EMPLEADO NO ENCONTRADO");
        }
    }

    // ELIMINAR
    public static void eliminar(int id) {
        CRUD operaciones = new CRUD();
        boolean eliminado = operaciones.eliminar(id);
        if (eliminado) {
            System.out.println("EMPLEADO ELIMINADO CORRECTAMENTE");
        } else {
            System.out.println("EMPLEADO NO ENCONTRADO");
        }
    }
}
