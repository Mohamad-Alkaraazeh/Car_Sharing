<!DOCTYPE html>
<html>
<#include "header.ftl">
<head>
    <title>Fahrt Erstelen</title>
</head>
<div>
    <body>
    <fieldset> <legend> <h1> Fahrt Erstellen: </h1> </legend>
        <form action="CreateFahrten?action=CreateFahrten" method="post">
            <label for ="stort"> Startort:</label><br>
            <input type="text" id="stort" name="stort" size="50"><br><br>

            <label for ="zort"> Zielort:</label><br>
            <input type="text" id="zort" name="zort" size="50"><br><br>

            <label for="Maxk">Maximale kapazität:</label><br>
            <input type="number" id="Maxk" name="Maxk" placeholder="Maximale kapazitaet" required min="0" max="10"> <br><br>

            <label for ="kosten">Fahrtkosten:</label><br>
            <input type="number" id="kosten" name="kosten" placeholder="Positive Ganzzahl für die Fahrtkosten!" min="0" required ><br><br>

            <label>Transportmittel:</label>

            <input type="radio" id="Bus" name="mittel" value="Bus" required>
            <label for="Bus">Bus</label>
            <input type="radio" id="Auto" name="mittel" value="Auto">
            <label for="Auto">Auto</label>
            <input type="radio" id="Kleintransporter" name="mittel" value="Kleintransporter">
            <label for="Kleintransporter">Kleintransporter</label><br><br>

            <label for="fdatum">Fahrtdatum:</label><br>
            <input type="date" id="fdatum" name="fdatum" min="2022-01-29">
            <input type="time" id="datum" name="datum"><br><br>

            <label for="Description">Beschreibung:</label><br>
            <textarea name="Description" id="Description" cols="40" rows="5" placeholder="Maximal 50 Zeichnen." max="50" required ></textarea><br><br>
            <input type="submit" value="Erstellen">
            <!-- <a href="Fahrt_erstellen.ftl"><button>Erstellen </button></a>-->
            <!--<input type="submit" style="background-color:darksalmon" value="Erstellen">-->
        </form>
    </fieldset>
    </body>
</div>
</html>