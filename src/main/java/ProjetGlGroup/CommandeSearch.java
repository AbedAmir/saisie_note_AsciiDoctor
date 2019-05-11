package ProjetGlGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.asciidoctor.AsciiDocDirectoryWalker;
import org.asciidoctor.DirectoryWalker;

public class CommandeSearch implements Commande{
	
	@Override
	public void execute(String fichier) throws IOException, URISyntaxException, InterruptedException {
		int cpt=0,test=0;
		String line;
		DirectoryWalker directoryWalker = new AsciiDocDirectoryWalker(AppConfiguration.getInstance().getDossierstockage());
		List<File> asciidocFiles = directoryWalker.scan();
		for (File file : asciidocFiles) {
			test=0;
			BufferedReader reader = new BufferedReader(new FileReader(file)); 
			line = null; 
			
			while ((line = reader.readLine()) != null) { 
				if (line.contains(fichier)) { 
					cpt++;
					test++;	
				} 
			} 
			if(test!=0)
				System.out.println(fichier+" est dans : "+file.getName() +"\t nombre de fois répété : " +test); 
				
			reader.close();
		}
		if(cpt == 0)
			System.out.println("Aucun resultat trouvé");
	}

}
