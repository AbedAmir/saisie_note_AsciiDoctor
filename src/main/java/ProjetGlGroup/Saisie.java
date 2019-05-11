package ProjetGlGroup;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class Saisie {
	Commande cmd;

	public Saisie() throws IOException, URISyntaxException, InterruptedException {
		String[] words;
		CmdEnum cmdEnum = null;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("Que voullez vous faire ? [Press 'exit' to end]");

			words = bufferedReader.readLine().split(" ", 3);

			try {
				if(words.length>1)
				{
					cmdEnum = insertIsInsideEnum(words[1]);
					if(cmdEnum != null)
					{
						if(words.length == 3) // note edit text
							cmdEnum.action(words[2]);

						if( words.length == 2)
							cmdEnum.action(words[1]);

					}
					else 
						System.out.println("La commande n'existe pas");

				}else // cas exit
				{
					cmdEnum = insertIsInsideEnum(words[0]);
					if(words[0].equals("exit"))
						cmdEnum.action(words[0]);
					else 
						System.out.println("La commande n'existe pas");
				}


			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);
	}

	public CmdEnum insertIsInsideEnum(String insert) {
		CmdEnum r = null;
		CmdEnum t[] = CmdEnum.values();

		for (CmdEnum cmdEnum : t) {
			if (cmdEnum.getCmd().equals(insert)) {
				r = cmdEnum;
				return r;
			}
		}
		return r;
	}
}

