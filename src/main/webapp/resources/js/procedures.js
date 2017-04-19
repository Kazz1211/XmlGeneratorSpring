/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function setNoParametersView() {
    document.getElementById("parameters").style.display = 'none';
    document.getElementById("firstValue").disabled = 'disabled';
    document.getElementById("secondValue").disabled = 'disabled';
    document.getElementById("firstValue").disabled = 'disabled';
    document.getElementById("secondValue").disabled = 'disabled';
}

function setOneParameterView(name) {
    document.getElementById("parameters").style.display = 'block';
    document.getElementById("first").style.display = 'block';
    document.getElementById("firstLabel").innerHTML = name;
    document.getElementById("second").style.display = 'none';
    document.getElementById("firstValue").removeAttribute('disabled');
    document.getElementById("secondValue").disabled = 'disabled';
}

function setTwoParametersView(first, second) {
    document.getElementById("parameters").style.display = 'block';
    document.getElementById("first").style.display = 'block';
    document.getElementById("second").style.display = 'block';
    document.getElementById("firstLabel").innerHTML = first;
    document.getElementById("secondLabel").innerHTML = second;
    document.getElementById("firstValue").removeAttribute('disabled');
    document.getElementById("secondValue").removeAttribute('disabled');
}
