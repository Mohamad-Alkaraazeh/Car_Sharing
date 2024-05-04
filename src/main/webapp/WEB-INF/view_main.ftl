<!DOCTYPE html>
<html>
<#include "header.ftl">
<head>
    <title>Hauptseite</title>
</head>
<body>

<fieldset> <legend> <h2> Meine reserverten Fahrten </h2> </legend>
    <table class="datatable" border="1">
        <th><img src="icons/auto.png" alt="Fahrt icon" /></th>
        <th>Startort</th>
        <th>Zielort</th>
        <th>status</th>

        <#list Fahrt1 as f>
            <tr>
                <td><a href="Fahrt_details" ><img src="icons/auto.png" alt="Fahrt icon"></a></td>
                <td>${f.startort}</td> <td>${f.zielort}</td> <td>${f.status}</td>
            </tr>
        </#list>
    </table>
</fieldset>

<fieldset> <legend> <h2> Offene Fahrten </h2> </legend>

    <table class="datatable" border = "1">
        <tr>
            <th><img src="icons/auto.png" alt="Fahrt icon" /></th>
            <th>Startort</th>
            <th>Zielort</th>
            <th>maxplaetze</th>
            <th>Fahrtkosten</th>
        </tr>
        <#list Fahrt2 as f>
            <tr>
                <td><a href="Fahrt_details" ><img src="icons/auto.png" alt="Fahrt icon"></a></td>
                <td>${f.startort}</td>
                <td>${f.zielort}</td>
                <td>${f.maxplaetze}</td>
                <td>${f.fahrtkosten}</td>
            </tr>
        </#list>
    </table>
</fieldset>

<form>
    <button formaction="CreateFahrten" style="background: aqua">Fahrt Erstellen</button>
</form>

</body>
</html>



