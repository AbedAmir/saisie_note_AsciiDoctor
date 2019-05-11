package ProjetGlGroup;

import static org.asciidoctor.Asciidoctor.Factory.create;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.junit.After;
import org.junit.Test;

public class CommandeSeachTest {
	String fichier = "JUnitTest";
	String url;
	@Test
	public void testSearchTitreDeLaNote() throws IOException {
		boolean verif = false;
		String line;
		BufferedReader bufferedReader;
		File file;
		FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		//f.close();
		BufferedWriter bufferedWriter = new BufferedWriter(f);
		bufferedWriter.write("= " + fichier);
		bufferedWriter.newLine();
		bufferedWriter.write("Abed Amir " + "<abedamir@hotmail.com>");
		bufferedWriter.newLine();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		bufferedWriter.write(dateFormat.format(date));
		bufferedWriter.close();
		Asciidoctor asciidoctor = create();
		asciidoctor.convertFile(new File(
				AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"),
				OptionsBuilder.options().safe(SafeMode.UNSAFE));
		url=AppConfiguration.getInstance().getDossierstockage() + fichier + ".adoc";
		file = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"); 
		bufferedReader = new BufferedReader(new FileReader(file)); 

		line = null; 
		
		while ((line = bufferedReader.readLine()) != null) { 
			if (line.contains("Abed")) { 
				verif = true;
			} 
		}
		bufferedReader.close();
		assertTrue(verif);
	}
	
	@Test
	public void testSearchDateDeLaNote() throws IOException {
		boolean verif = false;
		String line;
		BufferedReader bufferedReader;
		File file;
		FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		//f.close();
		BufferedWriter bufferedWriter = new BufferedWriter(f);
		bufferedWriter.write("= " + fichier);
		bufferedWriter.newLine();
		bufferedWriter.write("Abed Amir " + "<abedamir@hotmail.com>");
		bufferedWriter.newLine();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		bufferedWriter.write(dateFormat.format(date));
		bufferedWriter.close();
		Asciidoctor asciidoctor = create();
		asciidoctor.convertFile(new File(
				AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"),
				OptionsBuilder.options().safe(SafeMode.UNSAFE));
		url=AppConfiguration.getInstance().getDossierstockage() + fichier + ".adoc";
		file = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"); 
		bufferedReader = new BufferedReader(new FileReader(file)); 

		line = null; 
		
		while ((line = bufferedReader.readLine()) != null) { 
			if (line.contains(dateFormat.format(date))) { 
				verif = true;
			} 
		}
		bufferedReader.close();
		assertTrue(verif);
	}
	
	@Test
	public void testSearchAdresseMailDeLaNote() throws IOException {
		boolean verif = false;
		String line;
		BufferedReader bufferedReader;
		File file;
		FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		//f.close();
		BufferedWriter bufferedWriter = new BufferedWriter(f);
		bufferedWriter.write("= " + fichier);
		bufferedWriter.newLine();
		bufferedWriter.write("Abed Amir " + "<abedamir@hotmail.com>");
		bufferedWriter.newLine();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		bufferedWriter.write(dateFormat.format(date));
		bufferedWriter.close();
		Asciidoctor asciidoctor = create();
		asciidoctor.convertFile(new File(
				AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"),
				OptionsBuilder.options().safe(SafeMode.UNSAFE));
		url=AppConfiguration.getInstance().getDossierstockage() + fichier + ".adoc";
		file = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"); 
		bufferedReader = new BufferedReader(new FileReader(file)); 

		line = null; 
		
		while ((line = bufferedReader.readLine()) != null) { 
			if (line.contains("abedamir@hotmail.com")) { 
				verif = true;
			} 
		}
		bufferedReader.close();
		assertTrue(verif);
	}
	
	@Test
	public void testSearchCorpDeLaNote() throws IOException {
		boolean verif = false;
		String line;
		BufferedReader bufferedReader;
		File file;
		FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
		//f.close();
		BufferedWriter bufferedWriter = new BufferedWriter(f);
		bufferedWriter.write("= " + fichier);
		bufferedWriter.newLine();
		bufferedWriter.write("Abed Amir " + "<abedamir@hotmail.com>");
		bufferedWriter.newLine();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		bufferedWriter.write(dateFormat.format(date));
		bufferedWriter.newLine();
		bufferedWriter.write("Corp : Salut Salut");
		bufferedWriter.close();
		Asciidoctor asciidoctor = create();
		asciidoctor.convertFile(new File(
				AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"),
				OptionsBuilder.options().safe(SafeMode.UNSAFE));
		url=AppConfiguration.getInstance().getDossierstockage() + fichier + ".adoc";
		file = new File(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"); 
		bufferedReader = new BufferedReader(new FileReader(file)); 

		line = null; 
		
		while ((line = bufferedReader.readLine()) != null) { 
			if (line.contains("Salut")) { 
				verif = true;
			} 
		}
		bufferedReader.close();
		assertTrue(verif);
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
