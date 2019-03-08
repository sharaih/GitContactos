import java.util.*;
import java.util.stream.Collectors;

public class GestorContactos {

	private static Scanner scan = new Scanner(System.in);
	private static List<Contacto> contactos = new ArrayList<>();

	public static void main(String[] args) {
		int opcion;
		do {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("+-------- Gestor de contactos --------+");
			System.out.println("|                                     |");
			System.out.println("| Seleccione una opción:              |");
			System.out.println("| 1) Crear contacto                   |");
			System.out.println("| 2) Eliminar contacto                |");
			System.out.println("| 3) Mostrar todos los contactos      |");
			System.out.println("| 4) Filtrar por nombre               |");
			System.out.println("| 0) Salir                            |");
			System.out.println("|                                     |");
			System.out.println("+-------------------------------------+");
			opcion = scan.nextInt();
			switch (opcion) {
				case 1:
					crearContacto();
					break;
				case 2:
					eliminarContacto();
					break;
				case 3:
					mostrarTodos();
					break;
				case 4:
					mostrarFiltrados();
					break;
				case 0:
					System.out.println("\n\nBye ;)");
					return;
				default:
					System.err.println("Opción inválida\n\n\n");
			}
		} while(opcion != 0);
	}

	private static void crearContacto() {

		Contacto newContact = new Contacto();

		System.out.print("Ingrese Nombre:");
		newContact.setNombre(scan.next());
		System.out.print("\nIngrese Apellido:");
		newContact.setApellido(scan.next());
		System.out.print("\nIngrese Fecha de Nacimiento:");
		newContact.setFechaNacimiento(scan.next());
		System.out.print("\nIngrese Numero de Telefono:");
		newContact.setTelefono(scan.next());
		contactos.add(newContact);
		System.out.print("\n\n");
	}

	private static void eliminarContacto() {
	System.out.println("Ingrese el número que desea eliminar de sus contactos");
  String telefono = scan.nextLine();
  contactos = contactos.stream()
  .filter(c -> ! c.getTelefono().equals(telefono))
  .collect(Collectors.toList());
	}

	private static void mostrarTodos() {
		contactos.forEach(System.out::println);
		}

		private static void mostrarFiltrados() {
				 System.out.println("Ingrese nombre contacto: ");
				 String criterio =scan.next().trim().toLowerCase();
		                 contactos.stream().filter(c->c.getNombre().equals(criterio)).map(c -> c.toString())
		                 .forEach(System.out::println);
		                 System.out.println("Su filtracion ha sido exitosa");

}
}
