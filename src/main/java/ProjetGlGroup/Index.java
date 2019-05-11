package ProjetGlGroup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class Index {
	
	/** Methode qui permet de generer un etat coherent de l'index
	 * @throws IOException
	 */
	public void majIndex() throws IOException
	{
		ArrayList<String> enTete = new ArrayList<>();
		enTete.add("Titre");
		enTete.add("Editeur");
		enTete.add("Date");
		enTete.add("context");
		enTete.add("Projet");
		FileWriter file = new FileWriter(AppConfiguration.getInstance().getDossierstockage() + "index.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(file);
		bufferedWriter.write("");
		enTeteTableau("AFFICHAGE ALL NOTES",enTete,bufferedWriter);
		ecritureAllNotes(bufferedWriter);
		enTeteTableau("NOTES TRIEES TITRE",enTete,bufferedWriter);
		ecritureAllNotesTrie("titre",bufferedWriter);
		enTeteTableau("NOTES TRIEES DATE",enTete,bufferedWriter);
		ecritureAllNotesTrieMois(bufferedWriter);
		enTeteTableau("NOTES TRIEES CONTEXT",enTete,bufferedWriter);
		ecritureAllNotesTrie("context",bufferedWriter);
		enTeteTableau("NOTES TRIEES PROJET",enTete,bufferedWriter);
		ecritureAllNotesTrie("project",bufferedWriter);
		bufferedWriter.close();
		
	}
	/**
	 * Permet d'ecrire les en-tete des tableau pour chaque tableau
	 * @param message
	 * @param e
	 * @param bufferedWriter
	 * @throws IOException
	 */
	public void enTeteTableau(String message, ArrayList<String> e,BufferedWriter bufferedWriter) throws IOException
	{
		bufferedWriter.write("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	
		bufferedWriter.write(message + "\n\n");

		for (String t : e) {
			bufferedWriter.write(t.toString() + "\t\t\t | ");
		}
		bufferedWriter.write("\n");
		for(int i=0;i<30;i++)
		{
			bufferedWriter.write("---");
		}
		bufferedWriter.write("\n");
	}

	/** Trier des notes par mois
	 * @param bufferedWriter
	 * @return
	 * @throws IOException
	 */
	public int ecritureAllNotesTrieMois(BufferedWriter bufferedWriter) throws IOException
	{
		java.util.List<Note> all = new ArrayList<Note>(); 
		for (Note note : ConponementNote.ensembleNotes) {
			all.add(note);
		}
		Collections.sort(all, new Comparator<Note>() {
			@Override
			public int compare(Note o1, Note o2) {
				Date date1 = null, date2 = null, d1 = null, d2 = null;
				try {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					d1 = simpleDateFormat.parse(o1.getDate());
					d2 = simpleDateFormat.parse(o2.getDate());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				int mois1 = d1.getMonth();
				int mois2 = d2.getMonth();
				if(mois1 < mois2)
				{
					return -1;
				}
				else if(mois1 == mois2)
				{
					return 0;
				}
				else
				{
					return 1;
				}
			}
		});
		for (Note note : all) {
			ecrire_Index(note.getTitre(), note.getDate(), note.getAuteur(), note.getContext(), note.getProject(),bufferedWriter);

		}
		return 0;
	}
	

	/** Methode qui permet de trier les notes par titre, contexte, project
	 * @param elem
	 * @param bufferedWriter
	 * @throws IOException
	 */
	public void ecritureAllNotesTrie(String elem,BufferedWriter bufferedWriter) throws IOException
	{
		ArrayList<Note> noteTrie = new ArrayList<Note>();
		ArrayList<String> all = new ArrayList<String>();
		boolean verif = false;
			switch(elem) {
			case "titre":
				for (Note note : ConponementNote.ensembleNotes)
				all.add(note.titre);
				Collections.sort(all);
				for (String titre : all) {
					verif = false;
					for (Note note : ConponementNote.ensembleNotes) {

						if(verif == false && note.getTitre().equals(titre))
						{
							verif=true;
							noteTrie.add(note);
						}
					}
				}
				break;
			
			case "context":
				for (Note note : ConponementNote.ensembleNotes)
					all.add(note.context);
				Collections.sort(all);
				for (String titre : all) {
					verif = false;
					
					for (Note note : ConponementNote.ensembleNotes) {

						if(verif == false && note.getContext().equals(titre))
						{
							verif=true;
							noteTrie.add(note);
						}
					}
				}
				break;
			
			case "project":
				for (Note note : ConponementNote.ensembleNotes)
				all.add(note.project);
				Collections.sort(all);
				for (String titre : all) {
					verif = false;
					
					for (Note note : ConponementNote.ensembleNotes) {

						if(verif == false && note.getProject().equals(titre))
						{
							verif=true;
							noteTrie.add(note);
						}
					}
				}
				break;
					
			}
			
		
		for (Note note : noteTrie) {
			ecrire_Index(note.getTitre(), note.getDate(), note.getAuteur(), note.getContext(), note.getProject(),bufferedWriter);


		}
	}
	
	/** Methode pour ecrire toutes les notes
	 * @param bufferedWriter
	 * @throws IOException
	 */
	public void ecritureAllNotes(BufferedWriter bufferedWriter) throws IOException
	{
		for (Note note : ConponementNote.ensembleNotes) {
			ecrire_Index(note.getTitre(), note.getDate(), note.getAuteur(), note.getContext(), note.getProject(),bufferedWriter);


		}
	}
	
	/** Methode pour ecrire chaque note dans le fichier
	 * @param titre
	 * @param date
	 * @param auteur
	 * @param context
	 * @param project
	 * @param bufferedWriter
	 * @throws IOException
	 */
	public void ecrire_Index(String titre, String date, String auteur, String context, String project, BufferedWriter bufferedWriter) throws IOException
	{
		bufferedWriter.write(titre + "\t\t | " + auteur + "\t\t | " + date + "\t\t | " + context + "\t\t | " + project);
		bufferedWriter.write("\n");
		
		bufferedWriter.write("\n");
	}

}








