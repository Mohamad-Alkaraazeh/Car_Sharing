<!DOCTYPE html>
<html>
<#include "header.ftl">
<head>
    <title> Fahrt Details </title>
    <style>
        button {background-color: #c14cce;}
    </style>
</head>
<body>

<div >

    <ul>
        <fieldset><legend><h1>Informationen</h1></legend>
            <p><h2>startort:${FahrtPlatzhalter.startort}</h2></p>
            <p><h3>zielort : ${FahrtPlatzhalter.zielort}</h3></p>
            <p><h4>Fahrtdatum und Uhrzeit:${FahrtPlatzhalter.fahrtdatumzeit}</h4></p>
            <p><h3>Anzahl freie Plätze: ${FahrtPlatzhalter.maxPlaetze}</h3></p>
            <p><h4>Fahrtkosten : ${Fahrtplatzhalter.fahrtkosten}</h4></p>
            <p><h5>Status:${Fahrtplatzhalter.status}</h5></p>
            <p><h6>Beschreibung:${Fahrtplatzhalter.beschreibung}</h6></p>

        </fieldset>
        <hr>

        <fieldset><h2> Aktionsleiste </h2>
            <label for="cars">Anzahl plätze für reservierung:</label>
            <label for="mittel"></label><select id="mittel" name="mittel">
                <option value="1">1</option>
                <option value="2">2</option>
            </select>
        </fieldset>
        <#if navtype =="anbieter">
            <form method="POST" action="DeleteFahrt?action=DeleteFahrt&fid=${fid}">

                <button class="button" type="submit" id="submit">Fahrt Löschen</button>

            </form><br><br>
        <#else>
            <a href="Fahrt_details"><button>Fahrt reservieren</button></a>
        </#if>
        <hr>

        <fieldset><legend><h3> Bewertungen</h3></legend>
            <table class="datatable" border = "1" width="90%">
                <tr>
                    <th><h3>Benutzer E_mail</h3></th>
                    <th><h3>Text</h3></th>
                    <th><h3>rating</h3></th>
                </tr>
                <list Bewert as Bewertung>
                    <tr>
                        <td><center><h3>{Bewertung.email}</h3></center></td>
                        <td><h3>{Bewertung.textnachricht}</h3></td>
                        <td><h3>{Bewertung.rating}</h3></td>
                    </tr>
                </list>
            </table>
            <a href="xy" target="_blank"><button>Bewerten</button></a>
        </fieldset>
    </ul>
</div>
</body>
</html>


