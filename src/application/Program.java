package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import services.CalculationService;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		// Isso � o caminho onde se encontra o meu arquivo txt, atualize com seu caminho
		String path = "C:\\Users\\T420\\Desktop\\Programa��o\\Projeto Java\\Generics\\GenericosDelimitados\\file.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				// Convertendo para arquivo tipo CSV, separado por v�rgula.
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}

			Product x = CalculationService.max(list);
			System.out.println("Max: ");
			System.out.println(x);

		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
