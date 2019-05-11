package ProjetGlGroup;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class CommandeExit implements Commande, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void execute(String fichier) throws IOException, URISyntaxException {
		System.out.println("Vous avez fini");
		inListNote(ConponementNote.ensembleNotes);
		System.exit(0);
	}

	/**
	 * save the Note List
	 * @param o : notes
	 */
	public void inListNote(ArrayList<Note> o) {
		try {
			EntreeSortie es =new EntreeSortie();
			es.ouvrir("ECRIRE", ConponementNote.urlSerialisable);
			es.ecrire(o);
			es.fermer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

