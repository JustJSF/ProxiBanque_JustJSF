	************************************
*****             ProxiBanqueSI	               *****
	************************************

Concepteurs/d�veloppeurs:

	Jean DEGLAIRE
	St�phanie WOERNER
	Fran�ois DESTREMAU

Date : 08 septembre 2017

Version : version 4 de ProxiBanqueSI


	************************************ 
*****      	     Livrables  	        *****
	************************************

Les documents livr�s sont :


1) Le dossier "Livrables JustJSF/conception" contenant les diagrammes de cas d'utilisation, classes, d�ploiement ainsi que le diagramme du mod�le en couche.

2) Les dossier "Livrables JustJSF/Maquette_conseiller" et "Livrables JustJSF/Maquette_conseiller" qui contiennent les maquettes de pr�sentation du projet.

3) Le lien github permettant de r�cup�rer le projet : https://github.com/JustJSF/ProxiBanque_JustJSF.git

4) Le dossier "javadoc".

5) Le fichier readme.txt



	************************************
*****  	    Description de l'application:   	*****
	************************************

ProxibanqueSI est une application bancaire destin�e aux conseillers de client�le ainsi qu'aux g�rants des agences de la banque Proxibanque.
Apr�s connexion � ProxibanqueSI, le conseiller de client�le peut cr�er, lire ou modifier les informations relatives � un client. Le logiciel permet �galement au conseiller de r�cup�rer une liste de clients.

Le g�rant pourra, quant � lui, afficher la liste des conseillers client�le pr�sents dans son agence ainsi qu'en cr�er de nouveaux et modifier leurs informations. En cas d'absence d'un des conseiller il pourra, si n�cessaire, agir � sa place (et cr�er, modifier un client).
Le g�rant pourra �galement r�aliser l'audit de son agence.


	************************************
*****  	          Documentation:	        *****
	************************************

Pour avoir acc�s � la documentation veuillez suivre les indications suivantes :

1) Ouvrez le dossier 'javadoc'.

2) Double cliquez sur 'index.html'.




	************************************
*****  	          Installation de Git:	        *****
	************************************

Il est n�cessaire d'installer Git afin de r�cup�rer le projet sur github.

1) T�l�charger git : https://git-scm.com
2) Installer git.



	************************************
*****  	         R�cup�ration sur GitHub	*****
	************************************

Pour r�cup�rer l'application sur Github � partir du lien github, vous devez proc�der de la sorte :

1) Ouvrir la console Git Bash.

2) Cloner le projet :
	
	a) Se placer � l'endroit o� vous voulez r�cup�rer le projet et cr�er un dossier (par exemple pour se mettre sur le disque C: et y faire un dossier "test") vous devez taper sur la console : 
		cd C:
		entr�e
		mkdir test
		entr�e

	b) Cloner le projet depuis le lien donn� ci dessus (le lien sera nomm� url par la suite) :
	 	git clone url
		git add .



	*****************************************
*****  	  Installation du serveur d'application    *****
	*****************************************

Un serveur d'application est n�cessaire pour que fonctionne ProxibanqueSI. Il assure le lien entre les parties Java, base de donn�es et web de ProxibanqueSI.

1) T�l�charger le serveur d'application Tomcat version 8.0.45 sur le site suivant : http://tomcat.apache.org/
Pour le t�l�chargement, choisissez l'option zip dans la liste Core. Une fois le t�l�chargement effectu�, d�zippez l'archive zip.

2) Mettez � jour la variable d'environnement de la JDK : 
- Menu D�marrer, clic droit sur Ordinateur, clic gauche sur le champ "propri�t�s"
- Clic gauche sur le champ Param�tres syst�me avanc�s, puis sur le bouton Variables d'environnement
- Sous le champ Variables utilisateur, clic gauche sur le bouton Nouvelle...
- Dans le champ Nom de la variable, entrez JAVA_HOME
- Dans le champ Valeur de la variable, entrez le chemin d'acc�s � la JDK.

3) Double-cliquez sur le fichier bin/startup.bat : la console s'ouvre, et Tomcat d�marre.

4) Int�gration de Tomcat dans l'interface Eclipse Entreprise :
- Cliquez sur l'onglet File, s�lectionnez l'option New puis l'option Other
- Choisir Server/Server puis cliquez sur Next
- Choisir Apache/Tomcat v8.0 Server, puis cliquez sur Next
- Cliquez sur Browse puis naviguez jusqu'au r�pertoire d'installation de Tomcat
- Cliquez sur Finish.



	
	************************************
***** 	     Execution de l'application:    	*****
	************************************

Veuillez suivre les indications suivantes:
	
1) Par d�faut le login et mot de passe du g�rant sont "director" et "director" et le login et mot de passe du Conseiller sont "advisor" et "advisor"