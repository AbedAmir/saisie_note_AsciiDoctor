package ProjetGlGroup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.asciidoctor.AsciiDocDirectoryWalker;
import org.asciidoctor.DirectoryWalker;

public abstract class CommandeList implements Commande {

	public static void execute() throws FileNotFoundException, IOException {
		System.out.println("la list des notes :\n");
		DirectoryWalker directoryWalker = new AsciiDocDirectoryWalker(AppConfiguration.getInstance().getDossierstockage());
		List<File> asciidocFiles = directoryWalker.scan();
		for (File file : asciidocFiles) {
			System.out.println("\t* "+ file.getName()+"\n");
		}

	}

}
