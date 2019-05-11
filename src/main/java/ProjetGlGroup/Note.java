package ProjetGlGroup;

import java.io.Serializable;
import java.util.ArrayList;
public class Note implements ConponementNote, Serializable{

	/** 
	 * Utilisation pattern Builder
	 */
	private static final long serialVersionUID = 1L;
	String titre;
	String date;
	String auteur;
	String context;
	String project;
	
	public static class Builder {

		String titre;
		String date;
		String context;
		String project;
		String auteur;
		
		public Builder(String titre, String date,String context,String projet)
		{
			this.titre = titre;
			this.date = date;
			this.context = context;
			this.project = projet;
		}

		public Builder builderAuteur(String auteur)
		{
			this.auteur = auteur;
			return this;
		}

		public Note build()
		{
			return new Note(this);
		}

	}
	public Note(Builder builder) {
		super();
		this.titre = builder.titre;
		this.date = builder.date;
		this.context = builder.context;
		this.project = builder.project;
		this.auteur = builder.auteur;
	}

	public String getAuteur() {
		return auteur;
	}
	public String getTitre() {
		return titre;
	}
	public String getDate() {
		return date;
	}
	public String getContext() {
		return context;
	}
	public String getProject() {
		return project;
	}
	
	@Override
	public void ajouterNote() {
		ensembleNotes.add(this);

	}
	public ArrayList<Note> getEnsembleNoteList()
	{
		return ensembleNotes;
	}
}

