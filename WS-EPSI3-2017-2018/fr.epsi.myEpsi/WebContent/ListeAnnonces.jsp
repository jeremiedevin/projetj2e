<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Liste des annonces</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    </head>
    <body>
    	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="#">myEpsi</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="AnnoncesServlet">Annonces <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="AnnonceAjout">Ajouter une annonce</a>
		      </li>
		    </ul>
		    <a href="login.html" class="btn btn-danger navbar-btn">Déconnexion</a>
		  </div>
		</nav>
    	<br>
    	<div class="container">
			<h1>Annonces en ligne</h1>
			<div class="table-responsive">
				<table class="table table-striped">
			        <thead>
			            <tr> 
			                <th>Id</th>
			                <th>Titre</th>
			                <th>Description</th>
			                <th>Prix</th>
			                <th>Voir</th>
			                <th>Archiver</th>
			                <th>Rendre Privée</th>
			                <th>Modifier</th>
			                <th>Supprimer</th>
			            </tr>
			        </thead>
			        <tbody>
	       				<c:forEach items="${annonces}" var="a" >
				            <tr>
				                 <td>${a.id}</td>
				                 <td>${a.titre} </td>
				                 <td>${a.description} </td>
				                 <td>${a.prix} </td>
				                 <td><a href="VoirAnnonce?id=${a.id}" class="btn btn-primary navbar-btn"><i class="fas fa-eye"></i></a></td>
				                 <td><a href="ArchiverAnnonce?id=${a.id}" class="btn btn-primary navbar-btn"><i class="fas fa-archive"></i></a></td>
				                 <td><a href="PrivatiserAnnonce?id=${a.id}" class="btn btn-primary navbar-btn"><i class="fas fa-user-secret"></i></a></td>
				                 <td><a href="ModifierAnnonce?id=${a.id}" class="btn btn-primary navbar-btn"><i class="fas fa-edit"></i></a></td>
				                 <td><a href="SupprimerAnnonce?id=${a.id}" class="btn btn-primary navbar-btn"><i class="fas fa-trash-alt"></i></a></td>
				            </tr>   
			   			 </c:forEach>    
			        </tbody>
			     </table>
			</div>
	     </div>
	      
    </body>
</html>