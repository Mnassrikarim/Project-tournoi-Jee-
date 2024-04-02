<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire d'équipe</title>
</head>
<body>
    <h1>Ajouter une équipe</h1>
    <form action="EquipeEditionController" method="POST">
    <input type="hidden" name="equipeId" value="0" />
        <label for="nom">Nom:</label>
        <input type="text" name="nom" id="nom" required><br><br>
        
        <label for="dateCreation">Date de création:</label>
        <input type="date" name="dateCreation" id="dateCreation" required><br><br>
        
        <label for="pays">Pays:</label>
        <input type="text" name="pays" id="pays" required><br><br>
        
        <label for="entraineurId">ID d'entraîneur:</label>
        <input type="text" name="entraineurId" id="entraineurId" required><br><br>
        
        <label for="image_url">URL de l'image:</label>
        <input type="text" name="image_url" id="image_url" required><br><br>
        
        <input type="submit" value="Ajouter">
    </form>
    
    <a href="<%= request.getContextPath() %>/equipeList">Liste des équipes</a>
</body>
</html>
