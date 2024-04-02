<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Édition d'une équipe</title>
</head>
<body>
    <h1>Édition d'une équipe</h1>
    <form action="EquipeEditionController" method="POST">
        <input type="hidden" name="equipeId" value="${equipe.equipeId}" />
        <label for="nom">Nom :</label>
        <input type="text" name="nom" value="${equipe.nom}" /><br>
        <label for="dateCreation">Date de création :</label>
        <input type="text" name="dateCreation" value="${equipe.dateCreation}" /><br>
        <label for="pays">Pays :</label>
        <input type="text" name="pays" value="${equipe.pays}" /><br>
        <label for="entraineurId">ID d'entraîneur :</label>
        <input type="text" name="entraineurId" value="${equipe.entraineurId}" /><br>
        <label for="image_url">image-url :</label>
        <input type="text" name="image_url" value="${equipe.image_url}" /><br>
        <input type="submit" value="Enregistrer" />
    </form>
</body>
</html>
