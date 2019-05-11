package ProjetGlGroup;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class CommandeDeleteTest {
	String fichier = "JUnitTest";
	@Test
	public void testSupprimerNoteExistePas() throws IOException {
		FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		f.close();
		File fich = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") +"toto" + ".adoc");
		assertFalse(fich.delete());
	}
	
	@Test
	public void testSupprimerNoteExist() throws IOException {
		FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		f.close();
		File fich = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		assertTrue(fich.delete());
	}
	
	@After
	public void nettoyage() throws IOException {
		String fichier = "JUnitTest";
		File fich = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		File fichHtml = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".html");
		fich.delete();
		fichHtml.delete();
	}

}
