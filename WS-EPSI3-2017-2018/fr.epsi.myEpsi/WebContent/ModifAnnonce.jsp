<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification d'une annonce</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
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
		        <a class="nav-link" href="AnnoncesServlet">Annonces</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="AnnonceAjout">Ajouter une annonce  <span class="sr-only">(current)</span></a>
		      </li>
		    </ul>
		  </div>
		</nav>
		        
        <div class="container">
	        <form method="POST" action="AnnonceAjout">
	            <fieldset>
	              <legend>Modification d'une annonce</legend>              
				  <div class="form-group">
				    <label for="nomproduit">Nom du Produit</label>
				    <input type="text" class="form-control" name="TITLE" id="TITLE" value="${annonce.titre}">
				  </div>
				  <div class="form-group">
				    <label for="descriptionproduit">Description du Produit</label>
				    <input type="text" class="form-control" name="DESCRIPTION" id="DESCRIPTION" value="${annonce.description}">
				  </div>				  
				  <div class="form-group">
				    <label for="prixproduit">Prix du Produit</label>
				    <input type="number" step="0.01" class="form-control" name="PRIX" id="PRIX" value="${annonce.prix}">
				  </div>
				  <div class="form-group">
				    <label for="STATUT">Statut de l'annonce</label>
					  <select class="form-control" name="STATUT" id="STATUT">
					    <option>Disponible</option>
					    <option>Vendue</option>
					    <option>Archivée</option>
					  </select>
				  </div>
				  <button type="submit" value="AnnonceAjout" class="btn btn-primary">Valider</button>
	            </fieldset>
			</form>
		</div>
</body>
</html>