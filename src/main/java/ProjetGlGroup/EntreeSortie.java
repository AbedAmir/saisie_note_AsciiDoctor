package ProjetGlGroup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class EntreeSortie {

	private ObjectOutputStream ofW;
	private ObjectInputStream ofR;
	private char mode;


	public void ouvrir(String s, String filename) throws IOException {

		mode = (s.toUpperCase()).charAt(0);
		if((mode == 'R' || mode == 'L') && (filename != null)){
			ofR = new ObjectInputStream (new FileInputStream(filename));
		}
		else if((mode == 'W' || mode == 'E')&& (filename != null)){
			ofW = new ObjectOutputStream (new FileOutputStream(filename));
		}

	}


	public void ecrire (ArrayList<Note> tmp) throws IOException{
		if (tmp != null) {

			ofW.writeObject(tmp);
			ofW.flush(); //Vide le tempon
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Note> lire() throws IOException, ClassNotFoundException {
		ArrayList<Note> tmp = (ArrayList<Note>) ofR.readObject();
		return tmp;
	}

	public void fermer() throws IOException{
		if(mode == 'R' || mode =='L') ofR.close();
		else if(mode == 'W' || mode == 'E') ofW.close();
	}

}
