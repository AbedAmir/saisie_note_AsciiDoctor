package ProjetGlGroup;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class CommandeDelete implements Commande {

	@Override
	public void execute(String fichier) throws IOException, URISyntaxException {
		Index index = new Index();
		if(Commande.noteExist(fichier)==true)
		{
			File file = new File(AppConfiguration.getInstance().getDossierstockage()+fichier + ".adoc");
			int indice = Commande.getIndiceNote(fichier);
			ConponementNote.ensembleNotes.remove(indice);
			if(file.delete()){
				file = new File(AppConfiguration.getInstance().getDossierstockage()+fichier + ".html");
				file.delete();
				System.out.println(fichier + " est supprimé !");
			}
			index.majIndex();
		}
		else 
			System.out.println("La note n'existe pas");
	}
}
