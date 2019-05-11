package ProjetGlGroup;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.asciidoctor.AsciiDocDirectoryWalker;
import org.asciidoctor.DirectoryWalker;
import org.junit.Test;

public class CommandeListTest {

	// On verifie que le dossier test ne contient pas de fichier .adoc ce qui est vrai "Tout les .adoc sont placé dans le dossier fichier"
	@Test
	public void testExistanceFichierAsciiDocDansTest() throws FileNotFoundException, IOException {
		DirectoryWalker directoryWalker = new AsciiDocDirectoryWalker(AppConfiguration.getInstance().getDossierstockage()+"..//src//test//java//ProjetGlGroup");
		List<File> asciidocFiles = directoryWalker.scan();
		assertEquals(asciidocFiles.size(), 0);
	}

}
