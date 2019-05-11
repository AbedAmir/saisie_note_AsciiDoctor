package ProjetGlGroup;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class AppConfigTest {

	@Test
	public void testRecupEditeurText() throws FileNotFoundException, IOException {
		assertNotNull(AppConfiguration.getInstance().getEditeurText());
	}
	
	@Test
	public void testRecupNavigateur() throws FileNotFoundException, IOException {
		assertNotNull(AppConfiguration.getInstance().getNavigateur());
	}
	
	@Test
	public void testRecupDossierStockage() throws FileNotFoundException, IOException {
		assertNotNull(AppConfiguration.getInstance().getDossierstockage());
	}

}
