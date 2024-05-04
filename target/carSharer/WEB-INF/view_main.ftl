<!DOCTYPE html>
<html>
<#include "header.ftl">
<head>
    <title>Hauptseite</title>
</head>
<body>

     <fieldset> <legend> <h2> Meine reserverten Fahrten </h2> </legend>
        <table class="datatable" border="1">
                  <tr>
                    <th><img src="icons/auto.png" alt="Fahrt icon" /></th>
                    <th>Startort</th>
                    <th>Zielort</th>
                    <th>status</th>
                  </tr>
                  <#list Fahrten1 as Fahrt>
                  <tr>
                      <td><a href="Fahrt_details" target="_blank"><img src="icons/auto.png" alt="Fahrt icon"></a></td>
                      <td>${Fahrt.startort}</td> <td>${Fahrt.zielort}</td> <td>${Fahrt.status}</td>
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
               <#list Fahrte2 as Fahrt>
                   <tr>
                       <td><a href="Fahrt_details" target="_blank"><img src="icons/auto.png" alt="Fahrt icon"></a></td>
                        <td>${Fahrt.startort}</td>
                        <td>${Fahrt.zielort}</td>
                        <td>${Fahrt.maxplaetze}</td>
                       <td>kod</td>
                   </tr>
               </#list>
        </table>
    </fieldset>

<form>
    <button formaction="CreateFahrten" style="background: aqua">Fahrt Erstellen</button>
</form>

</body>
</html>