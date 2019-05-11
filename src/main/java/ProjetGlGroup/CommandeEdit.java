package ProjetGlGroup;

import static org.asciidoctor.Asciidoctor.Factory.create;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import ProjetGlGroup.Note;

public class CommandeEdit implements Commande {
	
	Index index;
	@Override
	public void execute(String fichier) throws IOException, InterruptedException, ParseException {
		String auteur = AppConfiguration.read("auteur");
		String t,words[] = null;
		index = new Index();
		String titre = null;
		String context = null;
		String project = null;
		Date date = null;
		Process p=null;
		if(Commande.noteExist(fichier))
		{
			
			System.out.println("la note exist");
			
			
			try {
				//pour linux
				if(AppConfiguration.getInstance().getSystem().equals("linux")) {
						String command =AppConfiguration.getInstance().getEditeurText()+" " +AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc";
						p =Runtime.getRuntime().exec(command);
						
				}else
				{//pour windows
						p = new ProcessBuilder(AppConfiguration.getInstance().getEditeurText(),
						AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc")
						.start();
				}
				Asciidoctor asciidoctor = create();
				p.waitFor();
				asciidoctor.convertFile(new File(
						AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"),
						OptionsBuilder.options().safe(SafeMode.UNSAFE));
				asciidoctor.shutdown();
				FileReader fileReader = new FileReader(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				t = bufferedReader.readLine().replaceAll(" ", "");
				if(t.startsWith("="))
				{
					words = t.split("=");
					titre = words[1];
					if(titre !=fichier) {
						if(!Commande.noteExist(titre)) {
					File fichierRename = new File(AppConfiguration.getInstance().getDossierstockage()+ fichier + ".adoc");
					File fichierRename2 = new File(AppConfiguration.getInstance().getDossierstockage()+ fichier + ".html");
					File f2 = new File(AppConfiguration.getInstance().getDossierstockage() + titre + ".adoc");
					File f3 = new File(AppConfiguration.getInstance().getDossierstockage() + titre + ".html");
					fichierRename.renameTo(f2);
					fichierRename2.renameTo(f3);
						
					   // File was not successfully renamed
					}else {
						titre = fichier;
						System.out.println("il existe déjà une autre note avec ce titre");
					}
					}
					//
					bufferedReader.readLine();
					t = bufferedReader.readLine().replaceAll(" ", "");
					words = t.split("/");
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String tiime=Integer.parseInt(words[0])+"/" +Integer.parseInt(words[1])+"/" +Integer.parseInt(words[2]);
					date= dateFormat.parse(tiime);
					t = bufferedReader.readLine().replaceAll(" ", "");
					words = t.split(":");
					try
					{
						context= words[2];
					}catch(java.lang.ArrayIndexOutOfBoundsException exception)
					{
						context=" ";
					}
					t = bufferedReader.readLine().replaceAll(" ", "");
					words = t.split(":");
					try
					{
						project= words[2];
					}catch(java.lang.ArrayIndexOutOfBoundsException exception)
					{
						project=" ";
					}
					p.destroy();
					bufferedReader.close();
					fileReader.close();
					
					int indice = Commande.getIndiceNote(fichier);
					ConponementNote.ensembleNotes.remove(indice);
					//NEW NOTE
					Note note =new Note.Builder(titre.replaceAll(" ", ""), tiime, context,project).builderAuteur(auteur).build();
					
					note.ajouterNote();
					index.majIndex();
				}
				
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			;
			
		}
		else 
		{
			try {
				//pour linux
				if(AppConfiguration.getInstance().getSystem().equals("linux")) {
						String command ="gedit " +AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc";
						p =Runtime.getRuntime().exec(command);
				}else
				{//pour windows
						p = new ProcessBuilder(AppConfiguration.getInstance().getEditeurText(),
						AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc")
						.start();
				}
				
			FileWriter f = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
			BufferedWriter bufferedWriter = new BufferedWriter(f);
			bufferedWriter.write("= " + fichier);
			bufferedWriter.newLine();
			bufferedWriter.write(auteur);
			bufferedWriter.newLine();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = new Date();
			bufferedWriter.write(dateFormat.format(date));
			//System.out.println("YOYO" + dateFormat.format(date));
			bufferedWriter.newLine();
			bufferedWriter.write(":context : ");
			bufferedWriter.newLine();
			bufferedWriter.write(":project : ");
			bufferedWriter.close();
			Asciidoctor asciidoctor = create();
			p.waitFor();
			asciidoctor.convertFile(new File(
					AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc"),
					OptionsBuilder.options().safe(SafeMode.UNSAFE));
			FileReader fileReader = new FileReader(AppConfiguration.getInstance().getDossierstockage() + fichier.replaceAll(" ", "") + ".adoc");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();
			bufferedReader.readLine();
			bufferedReader.readLine();
			t = bufferedReader.readLine().replaceAll(" ", "");
			words = t.split(":");
			try
			{
				context= words[2];
			}catch(java.lang.ArrayIndexOutOfBoundsException exception)
			{
				context="";
			}
			
			t = bufferedReader.readLine().replaceAll(" ", "");
			words = t.split(":");
			try
			{
				project= words[2];
			}catch(java.lang.ArrayIndexOutOfBoundsException exception)
			{
				project="";
			}
			//project= words[2];
			bufferedReader.close();
			Note note = new Note.Builder(fichier.replaceAll(" ", ""), dateFormat.format(date).toString(), context,project).builderAuteur(auteur).build();
			
			note.ajouterNote();
			p.destroy();
			asciidoctor.shutdown();
			index.majIndex();
			
			} catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}

	}
	
}
