/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getId() {
    var element = document.getElementById('template');
    return element.value;
}
function setTemplate(id) {
    switch (id) {
        case "1":
            setFirstTemplate();
            break;
        case "2":
            setSecondTemplate();
            break;
        case "3":
            setThirdTemplate();
            break;
        default:
            break;
    }
}
function setFirstTemplate() {
    document.getElementById('kp').value = 'black';
    document.getElementById('kn').value = 'darkgray';
    document.getElementById('pogrubienieTak').checked = true;
    document.getElementById('kursywaNie').checked = true;
    document.getElementById('podkreslenieTak').checked = true;
    document.getElementById('ko').value = 'white';
    document.getElementById('kpn').value = 'yellow';
    document.getElementById('kpk').value = 'red';
    document.getElementById('wielkosc').value = '10pt';
    document.getElementById('kolor').value = 'white';
}
function setSecondTemplate() {
    document.getElementById('kp').value = 'white';
    document.getElementById('kn').value = 'gray';
    document.getElementById('pogrubienieNie').checked = true;
    document.getElementById('kursywaTak').checked = true;
    document.getElementById('podkreslenieNie').checked = true;
    document.getElementById('ko').value = 'black';
    document.getElementById('kpn').value = 'darkblue';
    document.getElementById('kpk').value = 'red';
    document.getElementById('wielkosc').value = '10pt';
    document.getElementById('kolor').value = 'black';
}
function setThirdTemplate() {
    document.getElementById('kp').value = 'gray';
    document.getElementById('kn').value = 'beige';
    document.getElementById('pogrubienieNie').checked = true;
    document.getElementById('kursywaNie').checked = true;
    document.getElementById('podkreslenieTak').checked = true;
    document.getElementById('ko').value = 'black';
    document.getElementById('kpn').value = 'purple';
    document.getElementById('kpk').value = 'green';
    document.getElementById('wielkosc').value = '12pt';
    document.getElementById('kolor').value = 'black';
}