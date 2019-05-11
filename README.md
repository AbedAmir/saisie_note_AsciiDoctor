# Application ligne de commande pour la prise de notes
Abed Amir Chawki

Desctiption de l'application : 

	Notre application application permet d’éditer et d’organiser des notes (documents courts au format texte enrichi). Par exemple, cela peut permettre la prise de notes durant une réunion.
	Les notes sont rédigées par l'utilisateur en utilisant le langage de balisage asciidoctor. Chaque note contiendra un titre, un auteur, une date, et deux attributs 'context' et 'project' et enfin un corp.
	
	Voici un exemple : 
	
	= Cours Genie logiciel
	Jean michel <jean.michel@yahoo.fr>
	22/02/2018
	:context: design pattern
	:project: composite
	* Principe
	* Exemple 1
	* Exemple 2

Instructions d'éxécution:

   java -jar ProjetGl-1.0-SNAPSHOT-jar-with-dependencies.jar

   java -jar ProjetGl-1.0-SNAPSHOT-jar-with-dependencies.jar <commande>


Manuel d'utilisation :

	- L'utilisateur posséde 2 modes d'execution : 

		1- Mode ligne de commande en tappant : java -jar ProjetGl-1.0-SNAPSHOT-jar-with-dependencies.jar <commande>
		2- Mode interpréteur en tappant : java -jar ProjetGl-1.0-SNAPSHOT-jar-with-dependencies.jar
	
	-Quelque soit le mode d'execution choisit l'utilisateur aura la possible de :

		-Créer une note avec la commande "edit <nomDeLaNote>" ou bien "e <nomDeLaNote>", cette note aura un titre, un auteur, une date et deux attributs "context" et "project".

		-Modifier une note déja existante avec la commande "edit <nomDeLaNote>" ou bien "e <nomDeLaNote>".

		-Supprimer une note déja existante avec la commande "delete <nomDeLaNote>" ou bien "d <nomDeLaNote>".

		-Lister toutes les notes déja existantes avec la commande "list" ou bien "ls".

		-Voir le contenu d'une note et ce dans un navigateur "view <nomDeLaNote>" ou bien "v <nomDeLaNote>".

		-Rechercher un mot dans l'ensemble des notes et voir combien de fois le mot est répété avec la commande "search <nomDeLaNote>" ou bien "s <nomDeLaNote>". 

		-Consulter un fichier un index qui contient la liste des notes triées selon plusieurs critéres (titre, mois, contexte, project).

	-De plus l'application donne la possibilité d'initialiser un fichier de configuration qui permet de definir : 

		-Le nom de l'utilisateur (auteur de chaque note).
		-Le systeme d'exploitation du user et adapter les commandes suivants les systeme d'exploitations.
		-Le repertoire de stockage qui contiendra toutes les notes.
		-Les differentes applications a utiliser (Editeur de texte, navigateur).

	-A la fin de l'utilisation de l'application l'utlisateur doit entrée la commande 'exit' pour sauvegarder toutes ses modifications.



Manuel technique :
	
	-Pour ce qui est de l'aspect technique, nous avons travaillé sur un projet maven, et nous avons utilisé 'Bitbucket' comme plateforme collaborative.

	-Notre code est écrit en JAVA 8.

	-L'application est utilisable sur 'Windows' et 'Linux' et ce en le parametrant le fichier configuration.

	-Pour permettre à l'utilisateur de rédiger une note en utlisant le langage ascidoctor nous avons utlisé l'API 'asciidoctorj'.

	-Pour permettre la configuration de l'application, nous avons choisi de crée un fichier externe 'configuration.ini', qui contient les differents paramettres nécessaire pour l'application. A chaque ouverture de l'application, l'application recupére les parametres du fichier.

	-Chaque note est representée par une instance de la classe 'Note'.

	-L'ensemble des notes sont stockés dans une liste presente dans l'interface 'ConponementNote', à chaque ajout/modification/suppression d'une note, la liste est mise à jour.

	-La liste des notes est un fichier persistant, elle est sauvegardée sous forme d'un fichier serialisable 'testSerialisable.ser'. L'objet liste est chargé à chaque ouverture de l'application, et est enregistré a chaque fois que la commande 'exit' est executée.

	-L'indexe est un fichier '.txt' dans lequel on ecrit et on indexe les notes suivants les critéres.

	-Pattern de conception utilisés : 

		-Singleton : pour générer l'instance de configuration 'car il peut exister qu'un seul fichier de configuration'.

		-Commande : pour implémenter les differentes commandes.

		-Builder : pour l'instanciation de la classe 'Note'.

		-Composite : pour la gestion de la liste de notes.

		
