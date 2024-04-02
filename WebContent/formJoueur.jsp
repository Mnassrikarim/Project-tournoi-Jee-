<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="metier.Joueur" %>
<%@ page import="metier.Equipe" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire de joueur</title>
</head>
<body>
    <h1>Ajouter un joueur</h1>
    <form action="JoueurEditionController" method="POST">
        <input type="hidden" name="joueurId" value="0" />
        
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
        
        <label for="image_url">URL de l'image:</label>
        <input type="text" name="image_url" id="image_url" required><br><br>
        
        <label for="equipeId">Équipe:</label>
        <input type="number" name="equipeId" id="equipeId" required><br><br>
        
        <br>
        <input type="submit" value="Ajouter">
    </form>
    
    <a href="joueurList">Liste des joueurs</a>
</body>
</html>
