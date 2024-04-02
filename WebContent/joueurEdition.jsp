<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Édition d'un joueur</title>
</head>
<body>
    <h1>Édition d'un joueur</h1>
    <form action="JoueurEditionController" method="POST">
        <input type="hidden" name="joueurId" value="${joueur.joueurId}" />
        <label for="nom">Nom :</label>
        <input type="text" name="nom" value="${joueur.nom}" /><br>
        <label for="prenom">Prénom :</label>
        <input type="text" name="prenom" value="${joueur.prenom}" /><br>
        <label for="dateNaissance">Date de naissance :</label>
        <input type="text" name="dateNaissance" value="${joueur.dateNaissance}" /><br>
        <label for="pays">Pays :</label>
        <input type="text" name="pays" value="${joueur.pays}" /><br>
        <label for="salaire">Salaire :</label>
        <input type="text" name="salaire" value="${joueur.salaire}" /><br>
        <label for="image_url">URL de l'image :</label>
        <input type="text" name="image_url" value="${joueur.image_url}" /><br>
        <label for="equipeId">ID d'équipe :</label>
        <input type="text" name="equipeId" value="${joueur.equipeId}" /><br>
        <input type="submit" value="Enregistrer" />
    </form>
</body>
</html>
