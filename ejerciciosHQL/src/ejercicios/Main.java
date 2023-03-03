package ejercicios;

import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("./hibernate.cfg.xml");
		
		SessionFactory factoria = config.buildSessionFactory();
		Session sesion = factoria.openSession();
		
		Query consulta;
		ArrayList<Empleados> listaEmpleados;
		ArrayList<Departamentos> listaDepartamentos;
		ArrayList<Object[]> listaObjetos;
		
		System.out.println("EJERCICIO 1:");
		consulta = sesion.createQuery("SELECT emp FROM Empleados emp ORDER BY emp.nombreEmpleado");
		listaEmpleados = (ArrayList<Empleados>) consulta.list();
		for (Empleados empleado : listaEmpleados) {
			if (empleado.getPuesto().equals("ADMINISTRATIVO")) System.out.println(empleado);
		}
		
		System.out.println("\nEJERCICIO 2:");
		consulta = sesion.createQuery("SELECT dep FROM Departamentos dep ORDER BY dep.localidad DESC");
		listaDepartamentos = (ArrayList<Departamentos>) consulta.list();
		for (Departamentos departamentos : listaDepartamentos) {
			System.out.println(departamentos);
		}
		
		System.out.println("\nEJERCICIO 3:");
		consulta = sesion.createQuery("SELECT emp.nombreEmpleado, emp.puesto, emp.salario FROM Empleados emp ORDER BY emp.puesto, emp.salario");
		listaObjetos = (ArrayList<Object[]>) consulta.list();
		for (Object[] objects : listaObjetos) {
			String nombre = (String) objects[0];
			String puesto = (String) objects[1];
			BigDecimal salario = (BigDecimal) objects[2];
			System.out.println(nombre + " " + puesto + " " + salario + " euros");
		}
		
		System.out.println("\nEJERCICIO 4:");
		consulta = sesion.createQuery("SELECT emp.nombreEmpleado, emp.puesto, emp.salario FROM Empleados emp ORDER BY emp.puesto DESC, emp.salario ASC");
		listaObjetos = (ArrayList<Object[]>) consulta.list();
		for (Object[] objects : listaObjetos) {
			String nombre = (String) objects[0];
			String puesto = (String) objects[1];
			BigDecimal salario = (BigDecimal) objects[2];
			System.out.println(nombre + " " + puesto + " " + salario + " euros");
		}
		
		System.out.println("\nEJERCICIO 5:");
		consulta = sesion.createQuery("FROM Empleados emp WHERE NUM_DEPARTAMENTO IS 30");
		listaEmpleados = (ArrayList<Empleados>) consulta.list();
		for (Empleados empleado : listaEmpleados) {
			if (empleado.getDepartamentos().getNumDepartamento() == 30) System.out.println("Salario-> " + empleado.getSalario() + " Comision-> " + empleado.getComision());
		}
		
		System.out.println("\nEJERCICIO 6:");
		consulta = sesion.createQuery("SELECT emp.salario+1000 FROM Empleados emp WHERE NUM_DEPARTAMENTO IS 30");
		ArrayList<BigDecimal> listaSalarios = (ArrayList<BigDecimal>) consulta.list();
		for (BigDecimal salarioIncrem : listaSalarios) {
			System.out.println(salarioIncrem);
		}
		
		System.out.println("\nEJERCICIO 7:");
		consulta = sesion.createQuery("SELECT emp.salario, emp.salario+1000 FROM Empleados emp WHERE NUM_DEPARTAMENTO IS 30");
		listaObjetos = (ArrayList<Object[]>) consulta.list();
		for (Object[] objects : listaObjetos) {
			BigDecimal salarioOriginal = (BigDecimal) objects[0];
			BigDecimal salarioIncrementado = (BigDecimal) objects[1];
			System.out.println(salarioOriginal + " => " + salarioIncrementado);
		}
		
		System.out.println("\nEJERCICIO 8:");
		consulta = sesion.createQuery("SELECT emp FROM Empleados emp WHERE emp.comision > (emp.salario / 2)");
		listaEmpleados = (ArrayList<Empleados>) consulta.list();
		for (Empleados emple : listaEmpleados) {
			System.out.println(emple);
		}
		
		System.out.println("\nEJERCICIO 9:");
		consulta = sesion.createQuery("SELECT emp FROM Empleados emp WHERE emp.comision <= (emp.salario * 0.25)");
		listaEmpleados = (ArrayList<Empleados>) consulta.list();
		for (Empleados emple : listaEmpleados) {
			System.out.println(emple);
		}
		
		System.out.println("\nEJERCICIO 10:");
		consulta = sesion.createQuery("SELECT emp.salario, emp.comision FROM Empleados emp WHERE emp.numEmpleado > 7500");
		listaObjetos = (ArrayList<Object[]>) consulta.list();
		for (Object[] objects : listaObjetos) {
			System.out.println();
			BigDecimal salario = (BigDecimal) objects[0];
			BigDecimal comision = (BigDecimal) objects[1];
			System.out.println("Salario: " + salario);
			
			if (comision != null)	System.out.println("Comision: " + comision);
			else	System.out.println("Comision: NO");
			
		}
		
		System.out.println("\nEJERCICIO 11:");
		consulta = sesion.createQuery("SELECT emp.salario, emp.comision FROM Empleados emp WHERE emp.numEmpleado > 7500");
		listaObjetos = (ArrayList<Object[]>) consulta.list();
		for (Object[] objects : listaObjetos) {
			System.out.println();
			BigDecimal salario = (BigDecimal) objects[0];
			BigDecimal comision = (BigDecimal) objects[1];
			System.out.println("Salario: " + salario);
			
			if (comision != null)	System.out.println("Comision: " + comision);
			else	System.out.println("Comision: NO");
			
		}
	}

}
