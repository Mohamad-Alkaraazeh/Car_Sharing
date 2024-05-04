<!DOCTYPE html>
<html>
<#include "header.ftl">
<head>
    <title>Fahrt Suchen </title>
</head>
<div style="text-align: center;">
    <body>
    <fieldset> <legend> <h1> Fahrt suchen </h1> </legend>
        <form action="fahrtsuchen?action=fahrtsuchen" method="post">
            <label for ="name"> Startort</label><br>

            <label for ="name"> Zielort</label><br>

            <label for="start">ab</label><br>
            <input type="date" id="start" name="ab"
                   min="01.02.2022" max="31.12.2122"><br><br>

            <input type="submit" value="Suchen">
        </form>
    </fieldset>
    </body>
</div>
</html>