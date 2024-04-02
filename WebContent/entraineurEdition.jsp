<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Édition d'un entraîneur</title>
</head>
<body>
    <h1>Édition d'un entraîneur</h1>
    <form action="EntraineurEditionController" method="POST">
        <input type="hidden" name="entraineurId" value="${entraineur.entraineurId}" />
        <label for="nom">Nom :</label>
        <input type="text" name="nom" value="${entraineur.nom}" /><br>
        <label for="prenom">Prénom :</label>
        <input type="text" name="prenom" value="${entraineur.prenom}" /><br>
        <label for="dateNaissance">Date de naissance :</label>
        <input type="text" name="dateNaissance" value="${entraineur.dateNaissance}" /><br>
        <label for="pays">Pays :</label>
        <input type="text" name="pays" value="${entraineur.pays}" /><br>
        <label for="salaire">Salaire :</label>
        <input type="text" name="salaire" value="${entraineur.salaire}" /><br>
        <label for="equipeId">ID d'équipe :</label>
        <input type="text" name="equipeId" value="${entraineur.equipeId}" /><br>
        <input type="submit" value="Enregistrer" />
    </form>
</body>
</html>
