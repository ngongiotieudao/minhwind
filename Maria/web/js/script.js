/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function KeepHightlight() {
    var list = document.getElementById("menu").getElementsByTagName("a");
    for (var i = 0; i < list.length; i++) {
        if (list[i].href === window.location.href) {
            if(i===1){
                continue;
            }
            list[i].className +=" keepHightLight-link";
            break;
        }
    }
}

function KeepLink() {
    var listPage = document.getElementById("page").getElementsByTagName("a");
    var listMenu = document.getElementById("menu").getElementsByTagName("a");
    var check=false;
    for (var i = 0; i < listPage.length; i++) {
        if (listPage[i].href === window.location.href) {
            listPage[i].className +=" disabled-link";
            listMenu[1].className +=" keepHightLight-link";
            check=true;
            break;
        }
    }
    if(check===false){
        listPage[0].className+=" disabled-link";
        listMenu[1].className +=" keepHightLight-link";
    }
}