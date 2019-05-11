package ProjetGlGroup;


import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import ProjetGlGroup.CommandeEdit;;

public enum CmdEnum {
	
	Edit("e") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException {
			commande = new CommandeEdit();
			commande.execute(fichier);
		}
	},
	Editt("edit") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException {
			commande = new CommandeEdit();
			commande.execute(fichier);
		}
	},
	List("ls") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException {
			CommandeList.execute();
		}
	},
	Listt("list") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException {
			CommandeList.execute();
		}
	},
	Delete("d") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException {
			commande = new CommandeDelete();
			commande.execute(fichier);
		}
	},
	Deletee("delete") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException {
			commande = new CommandeDelete();
			commande.execute(fichier);
		}
	},
	View("v") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException {
			commande = new CommandeView();
			commande.execute(fichier);

		}
	},
	Vieww("view") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException {
			commande = new CommandeView();
			commande.execute(fichier);
		}
	},
	Search("s") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException {
			commande = new CommandeSearch();
			commande.execute(fichier);
		}
	},
	Searchh("search") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException {
			commande = new CommandeSearch();
			commande.execute(fichier);
		}

	},
	exit("exit") {
		@Override
		public void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException {
			commande = new CommandeExit();
			commande.execute(fichier);
		}
	};
	
	Commande commande;
	String cmd;
	private CmdEnum(String cmd) {
		this.cmd = cmd;
	}

	public Commande getCommande() {
		return commande;
	}

	public String getCmd() {
		return cmd;
	}

	public String getCmdValue(String cmd) {
		return String.valueOf(cmd);
	}

	public abstract void action(String fichier) throws IOException, URISyntaxException, InterruptedException, ParseException;

}

