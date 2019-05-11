package ProjetGlGroup;

import java.io.IOException;
import java.net.URISyntaxException;

public class CommandeView implements Commande {

	@Override
	public void execute(String fichier) throws IOException, URISyntaxException {
		if (Commande.noteExist(fichier) == true) {
			
			Runtime rt = Runtime.getRuntime();
			
			if(AppConfiguration.getInstance().getSystem().equals("linux")) {
				String cmd =AppConfiguration.getInstance().getNavigateur() + " \""+ AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".html"+"\" ";
				rt.exec(new String[] { "sh", "-c",cmd.toString() });
		}
			else //pour windows
				rt.exec(AppConfiguration.getInstance().getNavigateur() + " "+ AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".html");
		}
		else
			System.out.println("La note n'existe pas");
		
	}

}

