package ProjetGlGroup;

import static org.asciidoctor.Asciidoctor.Factory.create;
import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.junit.After;
import org.junit.Test;

public class CommandeEditTest {
	String fichier = "JUnitTest";
	@Test
	public void testCreationNouvelleNote() throws IOException {
		FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		f.close();
		File fich = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		assertTrue(fich.exists());
	}
	
	@Test
	public void testCreationHtmlNote() throws IOException {
		String fichier = "JUnitTest";
		FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		Asciidoctor asciidoctor = create();
		asciidoctor.convertFile(new File(
				AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"),
				OptionsBuilder.options().safe(SafeMode.UNSAFE));
		asciidoctor.shutdown();
		f.close();
		File fichHtml = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".html");
		assertTrue(fichHtml.exists());
	}
	
	@Test
	public void testMethodNoteExist() throws IOException {
		String fichier = "JUnitTest";
		FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		assertTrue(Commande.noteExist("JUnitTest"));
		f.close();
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
