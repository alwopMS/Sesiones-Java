package integracionTXT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		try {
			Set<Usuario> usuarios = new HashSet<>();
			Set<String> stringUsuarios = new HashSet<>();
			
			File doc1 = new File("C:\\Users\\amunizs\\CursoJava\\Ejercicio18\\USUARIOS_1.txt");
			BufferedReader obj1 = new BufferedReader(new FileReader(doc1));
			
			for (int i = 0; i < 3; i++) {
				if(i==0) {
					obj1.readLine();
				}
				String linea =obj1.readLine();
				stringUsuarios.add(linea);
			}
			
			File doc2 = new File("C:\\Users\\amunizs\\CursoJava\\Ejercicio18\\USUARIOS_2.txt");
			BufferedReader obj2 = new BufferedReader(new FileReader(doc2));
			
			for (int i = 0; i < 3; i++) {
				if(i==0) {
					obj2.readLine();
				}
				String linea =obj2.readLine();
				stringUsuarios.add(linea);
			}
			
			File doc3 = new File("C:\\Users\\amunizs\\CursoJava\\Ejercicio18\\Usuarios_3.txt");
			BufferedReader obj3 = new BufferedReader(new FileReader(doc3));
			
			for (int i = 0; i < 3; i++) {
				if(i==0) {
					obj3.readLine();
				}
				String linea =obj3.readLine();
				stringUsuarios.add(linea);
			}
			obj1.close();
			obj2.close();
			obj3.close();
			for (String string : stringUsuarios) {
				String[]datos=string.split(" ");
				String[] fNacimiento = datos[1].split("/");
				String[] fRegistro = datos[2].split("/");
				String[] fLogin = datos[3].split("/");
				Usuario usu = new Usuario(datos[0], LocalDate.of(Integer.parseInt(fNacimiento[2]), Integer.parseInt(fNacimiento[1]), Integer.parseInt(fNacimiento[0])),
						datos[5], LocalDate.of(Integer.parseInt(fRegistro[2]), Integer.parseInt(fRegistro[1]), Integer.parseInt(fRegistro[0])),
						LocalDate.of(Integer.parseInt(fLogin[2]), Integer.parseInt(fLogin[1]), Integer.parseInt(fLogin[0])),
						Integer.parseInt(datos[4]));
				usuarios.add(usu);
			}
			
			LocalDate fecha = LocalDate.now();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
			String fechaHoy = fecha.format(dateTimeFormatter);
			String nombreFichero = "informeDiario_"+fechaHoy+".txt";
			String ruta = "C:\\Users\\amunizs\\CursoJava\\Ejercicio18\\";
			
			escribirFichero(usuarios,ruta,nombreFichero);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public static void escribirFichero(Set<Usuario> usuarios, String ruta, String nombreFichero) {
		try {
			String rutaCompleta = ruta+nombreFichero;
			File archivo = new File(rutaCompleta);
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			if (!archivo.exists())
			{
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			String contenidoCompleto = "Nombre\tFecha de Nacimiento\tEdad\tFecha de Registro\tUltima fecha login\tStatus\tSegmento\tAntiguedad\tCantidad de Compras\tPais\n",contenidoparcial;
			for (Usuario user : usuarios) {
				contenidoparcial=user.getNombre()+"\t"+user.getFechaNacimiento().format(formato)+"\t"+user.getEdad()+"\t"+user.getFechaRegistro().format(formato)+"\t"+user.getFechaUltimoLogin().format(formato)+"\t"+user.getStatus()+"\t"+user.getSegmento()+"\t"+user.getAntiguedad()+"\t"+user.getCantidadCompras()+"\t"+user.getPais()+"\n";
				contenidoCompleto+=contenidoparcial;
			}
			
			bw.write(contenidoCompleto);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
