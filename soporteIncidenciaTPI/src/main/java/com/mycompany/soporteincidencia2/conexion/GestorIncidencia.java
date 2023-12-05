package com.mycompany.soporteincidencia2.conexion;

import com.mycompany.soporteincidencia2.clases.Cliente;
import com.mycompany.soporteincidencia2.clases.Empleado;
import com.mycompany.soporteincidencia2.clases.Incidente;
import com.mycompany.soporteincidencia2.clases.SoporteServicio;
import com.mycompany.soporteincidencia2.clases.Tecnico;

import java.util.Locale;
import java.util.Scanner;

public class GestorIncidencia {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        int caso;
        String respuesta;

        try {
            ConexionDB.conexionDB();
            
            do {
                System.out.println("\n BIENVENIDO AL SISTEMA DE SOPORTE DE INCIDENCIAS");
                System.out.println("PARA ALTA DE EMPLEADO PRESIONE: 1");
                System.out.println("PARA SERVICIO DE SOPORTE PRESIONE: 2");
                System.out.println("PARA ELEGIR SOPORTE PRESIONE: 3");
                System.out.println("PARA OBTENER LISTA DE EMPLEADO PRESIONE: 4");
                System.out.println("PARA BUSQUEDA DE EMPLEADO: 5");
                System.out.println("PARA REPORTAR INCIDENCIA PRESIONE: 6");
                System.out.println("***************************************************");
                caso = entrada.nextInt();

                switch (caso) {
                    case 1:
                        do {
                            Empleado emp1 = Empleado.altaEmpleado();
                            ConexionDB.altaEmpleadoDB(emp1);
                            System.out.println("******************");

                            System.out.println("Quiere dar de Alta otro Empleado?: s/n");
                            respuesta = entrada.next();
                        } while (respuesta.equals("s"));
                        System.out.println("******************");
                        break;
                    case 2:
                        do {
                            SoporteServicio sop1 = SoporteServicio.altaSoporte();
                            ConexionDB.altaSoporteDB(sop1);
                            System.out.println("******************");

                            System.out.println("Quiere otro Servicio de Soporte?: s/n");
                            respuesta = entrada.next();
                        } while (respuesta.equals("s"));
                        System.out.println("******************");
                        break;
                    case 3:
                        do {
                            ConexionDB.listarSoporte();
                            Cliente cli1 = Cliente.altaCliente();
                            ConexionDB.altaClienteDB(cli1);
                            System.out.println("******************");

                            System.out.println("Quiere otro Servicio de Soporte?: s/n");
                            respuesta = entrada.next();
                        } while (respuesta.equals("s"));
                        System.out.println("******************");
                        break;
                    case 4:
                        do {
                            ConexionDB.listarEmpleado();
                            System.out.println("******************");

                            System.out.println("Quiere otro Servicio de Soporte?: s/n");
                            respuesta = entrada.next();
                        } while (respuesta.equals("s"));
                        System.out.println("******************");
                        break;
                    case 5:
                        do {
                            Tecnico tec1 = Tecnico.altaTecnico();
                            ConexionDB.altaTecnicoDB(tec1);
                            System.out.println("******************");

                            System.out.println("Quiere seguir buscando?: s/n");
                            respuesta = entrada.next();
                        } while (respuesta.equals("s"));
                        System.out.println("******************");
                        break;
                    case 6:
                        do {
                            Incidente inc1 = Incidente.altaIncidente();
                            ConexionDB.altaIncidenteDB(inc1);
                            System.out.println("******************");

                            System.out.println("Quiere seguir buscando?: s/n");
                            respuesta = entrada.next();
                        } while (respuesta.equals("s"));
                        System.out.println("******************");
                        break;
                }

            } while (caso >= 1 && caso <= 6);
            
        } catch (Exception obj) {

            System.out.println("Error en ABM de la base de datos MAIN");
            System.out.println(obj.fillInStackTrace());
        }

    }

}
