<!DOCTYPE html>
<html>
<#include "header.ftl">
<head>
    <title>Fahrt Bewertungen</title>
</head>
<body>
<div style="text-align: center;">
    <fieldset>  <h1> Fahrt Bewerten </h1>
        <form action="xy?action=xy" method="post" >
            <p>Bewertungstext:</p>
        <label for="Comment"></label><textarea name="Comment" id="Comment" cols="60" rows="6" placeholder="Ihre Bewertung" required!></textarea> <br> <br>

        <p>Bewertungsrating:</p>

            <input type="radio" id="1" name="rating" value="1" required>
            <label for="1">1</label>

            <input type="radio" id="2" name="rating" value="2">
            <label for="2">2</label>

            <input type="radio" id="3" name="rating" value="3">
            <label for="3">3</label>

            <input type="radio" id="4" name="rating" value="4">
            <label for="4">4</label>

            <input type="radio" id="5" name="rating" value="5">
            <label for="5">5</label> &nbsp &nbsp &nbsp
            <br><br>
            <input type="submit" style="background-color: dodgerblue" value ="Bewerten">
        </form>
    </fieldset>
</div>
</body>
</html>