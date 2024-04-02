<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="mmetier.Entraineur" %>
<%@ page import="metier.Equipe" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire d'entraîneur</title>
</head>
<body>
    <h1>Ajouter un entraîneur</h1>
    <form action="EntraineurEditionController" method="POST">
        <input type="hidden" name="entraineurId" value="0" />
        
        <label for="nom">Nom:</label>
        <input type="text" name="nom" id="nom" required><br><br>
        
        <label for="prenom">Prénom:</label>
        <input type="text" name="prenom" id="prenom" required><br><br>
        
        <label for="dateNaissance">Date de naissance:</label>
        <input type="date" name="dateNaissance" id="dateNaissance" required><br><br>
        
        <label for="pays">Pays:</label>
        <input type="text" name="pays" id="pays" required><br><br>
        
        <label for="salaire">Salaire:</label>
        <input type="number" name="salaire" id="salaire" step="0.01" required><br><br>
        
        <label for="equipeId">Équipe:</label>
        <input type="number" name="equipeId" id="equipeId" required><br><br>
        
        <br>
        <input type="submit" value="Ajouter">
    </form>
    
    <a href="entraineurList">Liste des entraîneurs</a>
</body>
</html>
