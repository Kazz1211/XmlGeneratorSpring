<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Generator</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/procedures.css"/>">
        <script type="text/javascript" src="<c:url value="/resources/js/procedures.js"/>"></script>
    </head>
    <body>
        <form action='/XMLGeneratorSpring/select' method='post'>
            <div class="procedure">
                <input type="radio" name="procedure" value="selectAll" checked="checked" onclick="setNoParametersView()"> Wybierz wszystkie
            </div>
            <div class="procedure">
                <input type="radio" name="procedure" value="selectWithNoRedCards" onclick="setNoParametersView()"> Wybierz mecze bez czerwonych kartek
            </div>
            <div class="procedure">
                <input type="radio" name="procedure" value="selectWithNoGoals" onclick="setNoParametersView()"> Wybierz mecze bez goli
            </div>
            <div class="procedure">
                <input type="radio" name="procedure" value="selectWithSelectedGoalsCount" onclick="setOneParameterView('Ilość')"> Wybierz z podaną ilością bramek   
            </div> 
            <div class="procedure">
                <input type="radio" name="procedure" value="selectWithMoreThanSelectedSpectators" onclick="setOneParameterView('Ilość')"> Wybierz z większą ilością widzów  
            </div> 
            <div class="procedure">
                <input type="radio" name="procedure" value="selectWithMoreThanSelectedPossession" onclick="setOneParameterView('Ilość')"> Wybierz z większym posiadaniem piłki   
            </div> 
            <div class="procedure">
                <input type="radio" name="procedure" value="selectWithSelectedScore" onclick="setTwoParametersView('Strzelone', 'Stracone')"> Wybierz o podanym wyniku   
            </div> 
            <div class="procedure">
                <input type="radio" name="procedure" value="selectWithMoreThanSelectedOpponentsShots" onclick="setOneParameterView('Strzały')"> Wybierz z większą ilością strzałów   
            </div> 
            <div class="procedure">
                <input type="radio" name="procedure" value="selectWins" onclick="setNoParametersView()"> Wybierz wygrane  
            </div>
            <div class="procedure">
                <input type="radio" name="procedure" value="selectWithMoreThanSelectedYellowAndRedCards" onclick="setTwoParametersView('Żółte', 'Czerwone')"> Wybierz z większą ilością żółtych i czerwonych   
            </div> 
            <div id="parameters" style="display: none">
                <div class="paramDiv">Wybierz parametry</div>
                <div id="first" class="paramDiv">
                    <div id="firstLabel" class="label"></div>
                    <input type="number" name="first" id="firstValue" min="0" disabled="disabled">
                </div>
                <div id="second" class="paramDiv">
                    <div id="secondLabel" class="label"></div>
                    <input type="number" name="second" id="secondValue" min="0" disabled="disabled">
                </div>
            </div>
            <div class="format">
                Wybierz format: 
                <br> <input type="radio" name="format" value="XML" checked="checked" onClick="document.getElementById('css').style.display = 'block';"> XML <br>
                <input type="radio" name="format" value="JSON" onClick="document.getElementById('css').style.display = 'none';"> JSON <br>
                <input type="radio" name="format" value="YAML" onClick="document.getElementById('css').style.display = 'none';"> YAML <br>
                <input type="radio" name="format" value="OGDL" onClick="document.getElementById('css').style.display = 'none';"> OGDL <br>
                <div id="css">Czy wygenerować css?<br> 
                    <input type="radio" name="css" value="yes" checked="checked" onClick="document.getElementById('cssButton').style.display = 'block';"> <label>Tak</label>
                    <input type="radio" name="css" value="no" onClick="document.getElementById('cssButton').style.display = 'none';"> <label>Nie</label> <br>
                    <div id="cssButton"> <input type="button" onClick="window.open('/XMLGeneratorSpring/css/', '_blank')" value="Generuj arkusz styli"></div>
                </div>
            </div>
            <input type="submit" value="Generate"/>
        </form>
    </body>
</html>
