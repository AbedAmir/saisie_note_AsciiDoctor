package ProjetGlGroup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppConfiguration {
	/**
	 * Utilisation pattern singleton
	 */
	private static AppConfiguration instance = null;
	private String editeurText;
	private String navigateur;
	private String Dossierstockage;
	private String auteur;
	private String system;
	private AppConfiguration()
	{

	}
	public static AppConfiguration getInstance() throws FileNotFoundException, IOException
	{
		if (instance == null)
		{
			instance = new AppConfiguration();
			//pour windows
			instance.editeurText = read("editeur");
			//pour windows
			instance.navigateur = read("navigateur");
			
			instance.Dossierstockage = read("stockage");
			instance.auteur = read("auteur");
			instance.system = read("system");
		}
		return instance;
	}
	public String getSystem() {
		return system;
	}
	public String getAuteur() {
		return auteur;
	}
	public String getEditeurText() {
		return editeurText;
	}
	public String getNavigateur() {
		return navigateur;
	}
	public String getDossierstockage() {
		return Dossierstockage;
	}
	/**
	 * @param Key
	 * @return Proriete contenu dans le fichier
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String read (String Key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream("configuration.ini"));
		return(p.getProperty(Key));
	}
}
