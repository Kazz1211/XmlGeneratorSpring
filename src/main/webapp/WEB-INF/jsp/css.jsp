<%-- 
    Document   : css
    Created on : 2016-12-11, 14:42:29
    Author     : Ja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wybór CSS</title>
        <script type="text/javascript" src="<c:url value="/resources/js/css.js"/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/css.css"/>">
    </head>
    <body>
        <form action='/XMLGeneratorSpring/css/generate' method='post'>
            <div class="line">
                <div class="label">Szablon</div> 
                <div class="input">
                    <select name="template" id="template" onchange="setTemplate(getId())">
                        <option value="0"></option>
                        <option value="1">Szablon 1</option>
                        <option value="2">Szablon 2</option>
                        <option value="3">Szablon 3</option>
                    </select>
                </div>
            </div>
            <div class="line">
                <div class="label">Kolor tła parzystych wierszy</div> 
                <div class="input">
                    <select name="kp" id="kp">
                        <option value="white">Biały</option>
                        <option value="aliceblue">Błękitny</option>
                        <option value="black">Czarny</option>
                        <option value="beige">Beżowy</option>
                        <option value="gray">Szary</option>
                        <option value="gold">Złoty</option>
                        <option value="silver">Srebrny</option>
                        <option value="darkgray">Ciemnoszary</option>
                    </select>
                </div>
            </div>
            <div class="line">
                <div class="label">Kolor tła nieparzystych wierszy</div> 
                <div class="input">
                    <select name="kn" id="kn">
                        <option value="white">Biały</option>
                        <option value="aliceblue">Błękitny</option>
                        <option value="black">Czarny</option>
                        <option value="beige">Beżowy</option>
                        <option value="gray">Szary</option>
                        <option value="gold">Złoty</option>
                        <option value="silver">Srebrny</option>
                        <option value="darkgray">Ciemnoszary</option>
                    </select>
                </div>
            </div>
            <div class="line">
                <div class="label">Pogrubienie</div> 
                <div class="input">
                    <input type="radio" name="pogrubienie" id="pogrubienieTak" value="bold" checked="checked"> Tak 
                    <input type="radio" name="pogrubienie" id="pogrubienieNie" value="normal"> Nie 
                </div>
            </div>
            <div class="line">
                <div class="label">Kursywa</div> 
                <div class="input">
                    <input type="radio" name="kursywa" id="kursywaTak" value="italic" checked="checked"> Tak 
                    <input type="radio" name="kursywa" id="kursywaNie" value="normal"> Nie 
                </div>
            </div>
            <div class="line">
                <div class="label">Podkreślenie</div> 
                <div class="input">
                    <input type="radio" name="podkreslenie" id="podkreslenieTak" value="underline" checked="checked"> Tak 
                    <input type="radio" name="podkreslenie" id="podkreslenieNie" value="none"> Nie 
                </div>
            </div>
            <div class="line">
                <div class="label">Kolor obramowania</div> 
                <div class="input"><select name="ko" id="ko">
                        <option value="black">Czarny</option>
                        <option value="blue">Niebieski</option>
                        <option value="white">Biały</option>
                        <option value="red">Czerwony</option>
                        <option value="gray">Szary</option>
                        <option value="darkgreen">Ciemnozielony</option>
                        <option value="purple">Fioletowy</option>
                    </select>
                </div>
            </div>
            <div class="line">
                <div class="label">Kolor po najechaniu kursorem</div> 
                <div class="input"><select name="kpn" id="kpn">
                        <option value="red">Czerwony</option>
                        <option value="blue">Niebieski</option>
                        <option value="black">Czarny</option>
                        <option value="white">Biały</option>
                        <option value="green">Zielony</option>
                        <option value="yellow">Żółty</option>
                        <option value="purple">Fioletowy</option>
                        <option value="gray">Szary</option>
                        <option value="darkblue">Ciemnoniebieski</option>
                    </select>
                </div>
            </div>
            <div class="line">
                <div class="label">Kolor po kliknięciu</div> 
                <div class="input">
                    <select name="kpk" id="kpk">
                        <option value="red">Czerwony</option>
                        <option value="blue">Niebieski</option>
                        <option value="black">Czarny</option>
                        <option value="white">Biały</option>
                        <option value="green">Zielony</option>
                        <option value="yellow">Żółty</option>
                        <option value="purple">Fioletowy</option>
                        <option value="gray">Szary</option>
                        <option value="darkblue">Ciemnoniebieski</option>
                    </select>
                </div>
            </div>
            <div class="line">
                <div class="label">Wielkość czcionki</div> 
                <div class="input"><select name="wielkosc" id="wielkosc">
                        <option value="6pt">Mała</option>
                        <option value="8pt">Średnia</option>
                        <option value="10pt">Duża</option>
                    </select>
                </div>
            </div>
            <div class="line">
                <div class="label">Kolor czcionki</div> 
                <div class="input">
                    <select name="kolor" id="kolor">
                        <option value="red">Czerwony</option>
                        <option value="blue">Niebieski</option>
                        <option value="black">Czarny</option>
                        <option value="white">Biały</option>
                        <option value="green">Zielony</option>
                        <option value="yellow">Żółty</option>
                        <option value="purple">Fioletowy</option>
                        <option value="gray">Szary</option>
                        <option value="darkblue">Ciemnoniebieski</option>
                    </select>
                </div>
            </div>
            <input type="submit" value="Generuj"/>
        </form>
    </body>
</html>
