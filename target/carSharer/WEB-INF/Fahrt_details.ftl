<!DOCTYPE html>
<html>
<#include "header.ftl">
<head>
    <title> Fahrt Details </title>
    <style>
        button {background-color: #1e40a8;}
    </style>
</head>
<body>
<div style="text-align: center;">

    <ul>
        <fieldset><legend><h1>Informationen</h1></legend>
            <a href="Fahrt_details" target="_blank"><img src="icons/auto.png" alt="Icon_Bild"></a>
            <p><h1>Anbieter:${FahrtPlatzhalter.anbitermail}</h1>
            <p><h2>Startort:${FahrtPlatzhalter.startort}</h2>
            <p><h3>Zielort:${Fa}</h3>
            <p><h4>FahrtDatumzeti${FahrtPlatzhalter.fahrtdatum}</h4>
            <p><h5>Anzahl freie plätze:${FahrtPlatzhalter.freieplaetze}</h5>
            <p><h6>Fahrtkosten:${FahrtPlatzhalter.fahrtkosten}</h6>
            <p><h7>Status:${FahrtPlatzhalter.status}</h7></p>
            <p><h8>Beschreibung</h8>
                <label for="kommentare">Beschreibung:</label><textarea name="kommentare" id="kommentare" cols="40" rows="5" placeholder="Fahrt Beschreibung">
            </textarea><br></p>
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
            <a href=""><button>Fahrt reservieren</button></a>
        </#if>
        <hr>

        <fieldset><h3> Bewertungen</h3>
            <table class="datatable" border = "1" width="90%">
                <tr>
                    <th><h3>Benutzer E_mail</h3></th>
                    <th><h3>Text</h3></th>
                    <th><h3>rating</h3></th>
                </tr>
                <#list Bewertungen as Bewertung>
                    <tr>
                        <td><center><h3>${Bewertung.benutzer.email}</h3></center></td>
                        <td><h3>${Bewertung.textnachricht}</h3></td>
                        <td><h3>${Bewertung.rating}</h3></td>
                    </tr>
                </#list>
            </table>
            <a href="xy?fid=${FahrtPlatzhalter.fid}"><button>Bewerten</button></a>
        </fieldset>
    </ul>
</div>
</body>
</html>