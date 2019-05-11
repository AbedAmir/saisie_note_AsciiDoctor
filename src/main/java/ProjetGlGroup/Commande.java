package ProjetGlGroup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import org.asciidoctor.AsciiDocDirectoryWalker;
import org.asciidoctor.DirectoryWalker;

public interface Commande {

	public void execute(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException;

	/**
	 * Methode pour verifier si la note existe deja 
	 * @param nomFichier
	 * @return true si la note existe deja
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean noteExist(String nomFichier) throws FileNotFoundException, IOException {
		DirectoryWalker directoryWalker = new AsciiDocDirectoryWalker(
				AppConfiguration.getInstance().getDossierstockage());
		List<File> asciidocFiles = directoryWalker.scan();
		String fileName;
		for (File file : asciidocFiles) {
			fileName = file.getName().replaceAll("[.][^.]+$", "");
			if (fileName.equals(nomFichier)) {
				return true;
			}
		}
		return false;
	}

	public static String affectationUrl() throws FileNotFoundException, IOException {
		return AppConfiguration.getInstance().getDossierstockage();
	}

	/**
	 * @param fichier
	 * @return l'indice de la note dans notre liste
	 */
	public static int getIndiceNote(String fichier) {
		for (Note note : ConponementNote.ensembleNotes) {
			if(note.titre.equals(fichier))
				return ConponementNote.ensembleNotes.indexOf(note);
		}
		return -1;
	}


}

