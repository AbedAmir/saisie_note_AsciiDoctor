package ProjetGlGroup;

import java.util.ArrayList;

public interface ConponementNote {
	public static ArrayList<Note> ensembleNotes= new ArrayList<>();
	public void ajouterNote();
	public static String urlSerialisable="testSerialisable.ser";
}

