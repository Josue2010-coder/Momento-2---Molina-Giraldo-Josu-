
import java.util.Scanner;

public class Main {

public static void main(String[] args) {
ControlAcceso sistema = new ControlAcceso();
cargarDatosDePrueba(sistema);
Scanner scanner = new Scanner(System.in);
int opcion = -1;

do {
mostrarMenu();
System.out.print("Selecciona una opcion bro: ");
String entrada = scanner.nextLine().trim();

try {
opcion = Integer.parseInt(entrada);
} catch (NumberFormatException e) {
System.out.println("pon un numero valido bro");
continue;
}

try {
switch (opcion) {

case 1:

sistema.mostrarUsuarios();
break;

case 2:
sistema.mostrarZonas();
break;

case 3:
sistema.mostrarBitacora();
break;

case 4:
System.out.print("id del usuario: ");
String idUsuario = scanner.nextLine().trim();
System.out.print("Codigo de la zona: ");
String codigoZona = scanner.nextLine().trim();
sistema.intentarIngreso(idUsuario, codigoZona);
break;

case 5:
System.out.print("Codigo de la zona a cerrar: ");
String codigoCerrar = scanner.nextLine().trim();
sistema.cerrarZona(codigoCerrar);
break;

case 6:
registrarUsuario(scanner, sistema);
break;

case 7:
registrarZona(scanner, sistema);
break;

case 8:
actualizarUsuario(scanner, sistema);
break;

case 9:

System.out.print("id del usuario que vas a borrar bro: ");
String idEliminar = scanner.nextLine().trim();

if (sistema.eliminarUsuario(idEliminar)) {
System.out.println("Usuario eliminado :(");
} else {
System.out.println("No se encontro ese usuario bro");
}
break;

case 0:


System.out.println("Cerrando el sistema bro, nos vemos");
break;
default:
System.out.println("Opcion invalida brother");
}

} catch (IllegalArgumentException e) {
System.out.println("Error: " + e.getMessage());
}

} while (opcion != 0);

scanner.close();
}

private static void registrarUsuario(Scanner scanner, ControlAcceso sistema) {

System.out.println("Tipo de usuario:");
System.out.println("1 Cliente");
System.out.println("2 Administrador");
System.out.print("Seleccione el tipo: ");
int tipo = Integer.parseInt(scanner.nextLine().trim());

System.out.print("id: ");
String id = scanner.nextLine().trim();
System.out.print("Nombre: ");
String nombre = scanner.nextLine().trim();
System.out.print("Edad: ");
int edad = Integer.parseInt(scanner.nextLine().trim());

if (tipo == 1) {
System.out.print("Nivel de acceso del cliente (1 o 2): ");
int nivel = Integer.parseInt(scanner.nextLine().trim());

sistema.registrarUsuario(new Cliente(id, nombre, edad, nivel));

} else if (tipo == 2) {
sistema.registrarUsuario(new Administrador(id, nombre, edad));

} else {
System.out.println("Tipo de usuario invalido bro");
}
}

private static void registrarZona(Scanner scanner, ControlAcceso sistema) {

System.out.print("Codigo de la zona: ");
String codigo = scanner.nextLine().trim();
System.out.print("Nombre de la zona: ");
String nombre = scanner.nextLine().trim();
System.out.print("Nivel requerido (1, 2 o 3): ");
int nivel = Integer.parseInt(scanner.nextLine().trim());

sistema.registrarZona(new Zona(codigo, nombre, nivel));
}

private static void actualizarUsuario(Scanner scanner, ControlAcceso sistema) {

System.out.print("id del usuario que quieres actualizar: ");
String id = scanner.nextLine().trim();
System.out.print("Nuevo nombre: ");
String nombre = scanner.nextLine().trim();
System.out.print("Nueva edad: ");
int edad = Integer.parseInt(scanner.nextLine().trim());

if (sistema.actualizarUsuario(id, nombre, edad)) {
System.out.println("Usuario actualizado bro");
} else {
System.out.println("No se encontro ese usuario brother");
}
}

private static void mostrarMenu() {
System.out.println("SISTEMA DE CONTROL DE ACCESO");

System.out.println("1 Ver usuarios");

System.out.println("2 Ver zonas");

System.out.println("3 Ver bitacora");

System.out.println("4 Intentar ingreso a una zona");
System.out.println("5 Cerrar una zona");

System.out.println("6 Registrar usuario");

System.out.println("7 Registrar zona");

System.out.println("8 Actualizar usuario");
System.out.println("9 Eliminar usuario");

System.out.println("0 Salir");
}

private static void cargarDatosDePrueba(ControlAcceso sistema) {

sistema.registrarUsuario(new Cliente("U1", "Camila Torres", 20, 1));

sistema.registrarUsuario(new Administrador("U2", "Andres Perez", 30));

sistema.registrarZona(new Zona("Z1", "Recepcion", 1));

sistema.registrarZona(new Zona("Z2", "Sala de servidores", 3));

}

}
