package ProjetGlGroup;


import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;

public class Mainn implements Serializable, ConponementNote{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * pull out the Note list
	 * @return the saved notes
	 */
	public static ArrayList<Note> outNotes() {
		ArrayList<Note> ensembleNotes=null;
		try {
			EntreeSortie es =new EntreeSortie();
			es.ouvrir("Lire", ConponementNote.urlSerialisable);
			ensembleNotes=es.lire();
			es.fermer();
			return ensembleNotes;	

		} catch (Exception e) {
			System.out.println("pas de data sauvgarde");
		}
		return ensembleNotes;
	}

	public static void main(String[] args) throws URISyntaxException, InterruptedException, ClassNotFoundException, IOException, ParseException {
		ArrayList<Note>listN = outNotes();
		if(listN!=null) {
			for(Note k:listN) {
				ensembleNotes.add(k);
			}
		}
		if(args.length==0) {
			try {

				@SuppressWarnings("unused")
				Saisie saisie = new Saisie();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			int test=0;
			String name=null;
			if(args.length>1)
				name=args[1];
			CmdEnum cmd = null;
			for (CmdEnum cmdEnum : CmdEnum.values()) {
				if (cmdEnum.getCmd().equals(args[0])) {
					test=1;
					cmd=cmdEnum;
				}
			}
			if(test==1) {
				for(int i=2; i < args.length; i++)
					name=name + args[i];
				cmd.action(name);
			}
			else 
				System.out.println("La commande n'existe pas");
		}
	}	


	@Override
	public void ajouterNote() {

	}


}

