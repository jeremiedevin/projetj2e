# MyEpsi

Une application de petites annonces en J2EE

## Déploiement

Utilisez le fichier WAR sur votre server Tomcat pour déployer l'application.

### Prérequis

Vous devez disposer d'un serveur Tomcat et le lancer

```
./startup.sh
```

## Installation

Rendez vous dans votre interface d'administration Tomcat


[http://localhost:8080/manager](http://localhost:8080/manager)


Importez votre fichier,

Déployez ! :)

## Utilisation

Rendez-vous sur [localhost:8080/fr.epsi.myEpsi/login](localhost:8080/fr.epsi.myEpsi/login) Et créez votre compte

Vous pouvez maintenant voir les annonces présentes sur le site ou ajouter ou supprimer les votre.

## ConnectServlet.java

Ce servlet et celui qui permet la connexion au site.

## AnnoncesServlet.java

Cette page affiche la liste des annonces.

Nous récupérons les annonces depuis la base de données
```
String requete = "SELECT * FROM ANNONCES WHERE STATUS=0 ORDER BY CREATION_DATE";
```

Les données affichées à propos des annonces sont : L'ID de l'annonce, son titre, sa description et son prix.

## AnnonceAjout.java

 Cette page permet à l'utilisateur de créer une nouvelle annonce

 Les informations de l'annonce sont récupérées puis envoyées en base de données

```
String requete = "INSERT INTO ANNONCES VALUES(?,?,?,'test@epsi.fr',NULL,NULL,?,NULL,NULL,NULL,NULL)";
```


## ModifierAnnonce.java

Cette page permet de modifier une de vos annonces 

Une fois les informations modifiées apportées, les données sont modifiées dans la base de données.

```
String requete = "SELECT * FROM ANNONCES WHERE ID=?";
```


## SupprimerAnnonce.java

Ce servlet est appelé par le bouton "Supprimer" présent sur la liste des annonces.

```
String requete = "DELETE FROM ANNONCES WHERE ID = ?";
```


## VoirAnnonce.java

Cette page permet de voir une annonce via un lien unique de type [localhost:8080/fr.epsi.myEpsi/Annonce](localhost:8080/fr.epsi.myEpsi/Annonce)

```
String requete = "SELECT * FROM ANNONCES WHERE ID=?";
```


## Archivage/Mode privé

Les annonces peuvent être archivée ou mise en mode privé pour que son propriétaire soit le seul a pouvoir la voir

Le mode Archive est caractérisé par une valeur de STATUS égale à 1 et le mode privé à une valeur de 2.



