	************************************
*****             ProxiBanqueSI	               *****
	************************************

Concepteurs/développeurs:

	Jean DEGLAIRE
	Stéphanie WOERNER
	François DESTREMAU

Date : 08 septembre 2017

Version : version 4 de ProxiBanqueSI


	************************************ 
*****      	     Livrables  	        *****
	************************************

Les documents livrés sont :


1) Le dossier "Livrables JustJSF/conception" contenant les diagrammes de cas d'utilisation, classes, déploiement ainsi que le diagramme du modèle en couche.

2) Les dossier "Livrables JustJSF/Maquette_conseiller" et "Livrables JustJSF/Maquette_conseiller" qui contiennent les maquettes de présentation du projet.

3) Le lien github permettant de récupérer le projet : https://github.com/JustJSF/ProxiBanque_JustJSF.git

4) Le dossier "javadoc".

5) Le fichier readme.txt



	************************************
*****  	    Description de l'application:   	*****
	************************************

ProxibanqueSI est une application bancaire destinée aux conseillers de clientèle ainsi qu'aux gérants des agences de la banque Proxibanque.
Après connexion à ProxibanqueSI, le conseiller de clientèle peut créer, lire ou modifier les informations relatives à un client. Le logiciel permet également au conseiller de récupérer une liste de clients.

Le gérant pourra, quant à lui, afficher la liste des conseillers clientèle présents dans son agence ainsi qu'en créer de nouveaux et modifier leurs informations. En cas d'absence d'un des conseiller il pourra, si nécessaire, agir à sa place (et créer, modifier un client).
Le gérant pourra également réaliser l'audit de son agence.


	************************************
*****  	          Documentation:	        *****
	************************************

Pour avoir accès à la documentation veuillez suivre les indications suivantes :

1) Ouvrez le dossier 'javadoc'.

2) Double cliquez sur 'index.html'.




	************************************
*****  	          Installation de Git:	        *****
	************************************

Il est nécessaire d'installer Git afin de récupérer le projet sur github.

1) Télécharger git : https://git-scm.com
2) Installer git.



	************************************
*****  	         Récupération sur GitHub	*****
	************************************

Pour récupérer l'application sur Github à partir du lien github, vous devez procéder de la sorte :

1) Ouvrir la console Git Bash.

2) Cloner le projet :
	
	a) Se placer à l'endroit où vous voulez récupérer le projet et créer un dossier (par exemple pour se mettre sur le disque C: et y faire un dossier "test") vous devez taper sur la console : 
		cd C:
		entrée
		mkdir test
		entrée

	b) Cloner le projet depuis le lien donné ci dessus (le lien sera nommé url par la suite) :
	 	git clone url
		git add .



	*****************************************
*****  	  Installation du serveur d'application    *****
	*****************************************

Un serveur d'application est nécessaire pour que fonctionne ProxibanqueSI. Il assure le lien entre les parties Java, base de données et web de ProxibanqueSI.

1) Télécharger le serveur d'application Tomcat version 8.0.45 sur le site suivant : http://tomcat.apache.org/
Pour le téléchargement, choisissez l'option zip dans la liste Core. Une fois le téléchargement effectué, dézippez l'archive zip.

2) Mettez à jour la variable d'environnement de la JDK : 
- Menu Démarrer, clic droit sur Ordinateur, clic gauche sur le champ "propriétés"
- Clic gauche sur le champ Paramètres système avancés, puis sur le bouton Variables d'environnement
- Sous le champ Variables utilisateur, clic gauche sur le bouton Nouvelle...
- Dans le champ Nom de la variable, entrez JAVA_HOME
- Dans le champ Valeur de la variable, entrez le chemin d'accès à la JDK.

3) Double-cliquez sur le fichier bin/startup.bat : la console s'ouvre, et Tomcat démarre.

4) Intégration de Tomcat dans l'interface Eclipse Entreprise :
- Cliquez sur l'onglet File, sélectionnez l'option New puis l'option Other
- Choisir Server/Server puis cliquez sur Next
- Choisir Apache/Tomcat v8.0 Server, puis cliquez sur Next
- Cliquez sur Browse puis naviguez jusqu'au répertoire d'installation de Tomcat
- Cliquez sur Finish.



	
	************************************
***** 	     Execution de l'application:    	*****
	************************************

Veuillez suivre les indications suivantes:
	
1) Par défaut le login et mot de passe du gérant sont "director" et "director" et le login et mot de passe du Conseiller sont "advisor" et "advisor"