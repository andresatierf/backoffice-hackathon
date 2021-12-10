import { carTypes } from "./events.js";
var url_prefix = "http://192.168.1.113:8080/back-office/api"


export function getMatches(userId) {
    console.log("called getMatches");
    var url = url_prefix + "/match/" + userId

    $.ajax({
        url: url,
        async: true,
        success: populateMatches,
        error: undefined
    });



    function populateMatches(data) {
        console.log(carTypes);
    }

}