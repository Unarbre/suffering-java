package grx.dod.demo.tp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Generation {

	String chemin;
	
	public Generation(String chemin) {
		this.chemin = chemin;
	}
	
	public List<Forme> output() throws Exception {
		File fichier = new File(chemin);
		
		try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {
			return lecteur.lines().map(
				line -> {
					Forme forme;

					if (line!=null) {
						String[] parts = line.split(";");
						String type = parts[0];
						
						if (Forme.CERCLE.equals(type)) {
							forme = new Cercle(
								Double.valueOf(parts[1]), Double.valueOf(parts[2]), 
								Double.valueOf(parts[3]), 
								parts[4]
							);
						} else if (Forme.RECTANGLE.equals(type)) {
							forme = new Rectangle(
								Double.valueOf(parts[1]), Double.valueOf(parts[2]), 
								Double.valueOf(parts[3]), Double.valueOf(parts[4]),
								parts[5]
							);
						} else {
							// Inconnu
							forme = null;
						}
					} else {
						// Inconnu
						forme = null;
					}
					
					return forme;
				}
			).collect(Collectors.toList());
		}

	}
}
