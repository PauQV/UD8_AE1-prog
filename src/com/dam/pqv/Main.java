package com.dam.pqv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int opcion;
		Boolean encendido = true;
		
		Electrodomestico e1 = new Electrodomestico();
		e1.setConsumoEnergetico('B');
		Electrodomestico e2 = new Electrodomestico(50,3);
		Electrodomestico e3 = new Electrodomestico(300,"negro",82,'A');
		Electrodomestico e4 = new Electrodomestico(500,"rojo",20,'D');
		Lavadora l1 = new Lavadora();
		Lavadora l2 = new Lavadora(200, 47);
		Lavadora l3 = new Lavadora(250,"gris",60,'A',40);
		Television t1 = new Television();
		Television t2 = new Television(50,20);
		Television t3 = new Television(500,"negro",10,'E',47,true);
		
		ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>();
		
		electrodomesticos.add(e1);
		electrodomesticos.add(e2);
		electrodomesticos.add(e3);
		electrodomesticos.add(e4);
		electrodomesticos.add(l1);
		electrodomesticos.add(l2);
		electrodomesticos.add(l3);
		electrodomesticos.add(t1);
		electrodomesticos.add(t2);
		electrodomesticos.add(t3);
		
		while (encendido) {
		
		System.out.println("1-Listar electrodomesticos\n2-Añadir electrodomestico\n3-Eliminar electrodoméstico\n4-Mostrar precios agrupados\n5-Apagar programa"); opcion=sc.nextInt();
		switch(opcion) {
		case 1:
			System.out.println(listarElectrodomesticos(electrodomesticos));
			break;
		case 2:
			System.out.println("1-Crear electrodomestico // 2-Crear lavadora // 3-Crear television"); opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				electrodomesticos.add(addElectrodomestico(sc));
				break;
			case 2:
				electrodomesticos.add(addLavadora(sc));
				break;
			case 3:
				electrodomesticos.add(addTelevision(sc));
				break;
			default:
				System.out.println("Opcion no valida");
			}
			break;
		case 3:
			eliminarElectrodomestico(electrodomesticos, sc);
			break;
		case 4:
			System.out.println(preciosAgrupados(electrodomesticos));
			break;
		case 5:
			System.out.println("Apagando programa...\n\n");
			encendido = false;
			break;
		default:
			System.out.println("Opción no válida");
		}
		
		}
		
		System.out.println("ANEXO III: Ordenacion con comparators");
		
		Collections.sort(electrodomesticos, new OrdenarElectrodomesticoMayorAMenorPeso());
		System.out.println(listarElectrodomesticos(electrodomesticos));
		Collections.sort(electrodomesticos, new OrdenarElectrodomesticoMenorAMayorPrecio());
		System.out.println(listarElectrodomesticos(electrodomesticos));
		Collections.sort(electrodomesticos, Collections.reverseOrder(new OrdenarElectrodomesticoPorConsumoMenAMay()));
		System.out.println(listarElectrodomesticos(electrodomesticos));
		
		sc.close();
	}

	
	public static String listarElectrodomesticos(ArrayList<Electrodomestico> electrodomesticos) {
		
		String lista = "";
		
		for (Electrodomestico e : electrodomesticos) {
			
			lista += ("\nPosición: " + electrodomesticos.indexOf(e) + " // " + e.toString());
			
		}
		
		return lista;
	}
	
	public static Electrodomestico addElectrodomestico(Scanner sc) {
		
		System.out.println("Indica el precio del electrodomestico"); double precioBase = sc.nextDouble();
		sc.nextLine();
		System.out.println("Indica el color del electrodomestico"); String color = sc.nextLine();
		System.out.println("Indica el peso del electrodomestico"); double peso = sc.nextDouble();
		sc.nextLine();
		System.out.println("Indica el consumo energetico del electrodomestico"); char consumoEnergetico = sc.next().charAt(0);
		
		Electrodomestico e = new Electrodomestico(precioBase, color, peso, consumoEnergetico);
		
		return e;
	}
	
	public static Lavadora addLavadora(Scanner sc) {
		
		System.out.println("Indica el precio de la lavadora"); double precioBase = sc.nextDouble();
		sc.nextLine();
		System.out.println("Indica el color de la lavadora"); String color = sc.nextLine();
		System.out.println("Indica el peso de la lavadora"); double peso = sc.nextDouble();
		sc.nextLine();
		System.out.println("Indica el consumo energetico de la lavadora"); char consumoEnergetico = sc.next().charAt(0);
		System.out.println("Indica la carga de la lavadora"); double carga = sc.nextDouble();
		sc.nextLine();
		
		Lavadora l = new Lavadora(precioBase, color, peso, consumoEnergetico, carga);
		
		return l;
	}
	
	public static Television addTelevision(Scanner sc) {
		
		System.out.println("Indica el precio de la television"); double precioBase = sc.nextDouble();
		sc.nextLine();
		System.out.println("Indica el color de la television"); String color = sc.nextLine();
		System.out.println("Indica el peso de la television"); double peso = sc.nextDouble();
		sc.nextLine();
		System.out.println("Indica el consumo energetico de la television"); char consumoEnergetico = sc.next().charAt(0);
		System.out.println("Indica las pulgadas de la television"); double pulgadas = sc.nextDouble();
		sc.nextLine();
		System.out.println("Indica si la television tiene smartTV (true) o no (false)"); Boolean smartTV = sc.nextBoolean();
		
		Television t = new Television(precioBase, color, peso, consumoEnergetico, pulgadas, smartTV);
		
		return t;
	}
	
	public static Boolean eliminarElectrodomestico (ArrayList<Electrodomestico> electrodomesticos, Scanner sc) {
		
		System.out.println("Indica la posicion del elemento que quieres eliminar"); int posicion = sc.nextInt();
		
		System.out.println("\nEstas seguro de que quieres eliminar este electrodomestico?\nPosición: " + electrodomesticos.indexOf(electrodomesticos.get(posicion)) + " // " + electrodomesticos.get(posicion).toString() + "\nSi(1) / No(2)"); 
		int decision = sc.nextInt();
		
		if (decision == 1) {
			System.out.println("Eliminando electrodomestico de la posicion " + electrodomesticos.indexOf(electrodomesticos.get(posicion)) + ".");
			electrodomesticos.remove(posicion);
			return true;
		} else if (decision == 2) {
			System.out.println("No se elimina el elemento.");
			return false;
		} else {
			System.out.println("Opcion no valida. No se elimina el elemento.");
			return false;
		}
	}
	
	public static String preciosAgrupados(ArrayList<Electrodomestico> electrodomesticos) {
		
		double precioElectrodomestico = 0;
		double precioLavadora = 0;
		double precioTelevision = 0;
		
		for (Electrodomestico e : electrodomesticos) {
			
			if (e instanceof Electrodomestico) {
				precioElectrodomestico += e.precioFinal();
			}
			
			if (e instanceof Lavadora) {
				precioLavadora += e.precioFinal();
			}
			
			if (e instanceof Television) {
				precioTelevision += e.precioFinal();
			}
		}
		
		return ("Precios agrupados electrodomesticos: " + precioElectrodomestico + "\nPrecios agrupados lavadoras: " + precioLavadora + "\nPrecios agrupados televisiones: " + precioTelevision);
	}
	
}
