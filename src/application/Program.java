package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import entities.Participation;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Participation> list = new ArrayList<>();
		Map<String, Set<String>> map = new LinkedHashMap<>();

		System.out.print("Entre com o caminho do arquivo: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String eventName = fields[0];
				String email = fields[1];

				list.add(new Participation(eventName, email));

				line = br.readLine();
			}

			for (Participation p : list) {

				if (!map.containsKey(p.getEventName())) {
					Set<String> set = new HashSet<>();
					set.add(p.getEmail());
					map.put(p.getEventName(), set);
				} else {
					Set<String> set = map.get(p.getEventName());
					set.add(p.getEmail());
				}

			}

			System.out.println();
			System.out.println("RELATORIO DO EVENTO");
			System.out.println();

			for (String key : map.keySet()) {

				System.out.println(key + " -> " + map.get(key).size() + " participants");

			}

			Set<String> total = new HashSet<>();

			for (String key : map.keySet()) {
				total.addAll(map.get(key));
			}

			System.out.println();
			System.out.println("TOTAL DE PARTICIPANTES UNICOS: " + total.size());

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		sc.close();

	}

}
