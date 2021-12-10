import { getMatches } from './matches.js';
import { getUsers } from './feed.js';
import { getRoomTypes } from './searchDropdowns.js'

var userId = $("#userID").text();
var carTypes

$(document).ready(function() {
    getRoomTypes();


});

function getCarsType() {
    var url = url_prefix + "/cartype";
    console.log(url);
    $.ajax({
        method: "GET",
        url: url,
        async: true,
        success: carSuccess,
        error: undefined
    });
}

function carSuccess(response) {
    carTypes = response;
    //export carTypes;
}


$(function events() {
    $("#search-button").click(function() {
        var time = convertTimeToUnix($("#picker").val());
        var duration = $("#dropdown-duration-button").val();
        console.log($("#dropdown-room-button").val());
        var room = $("#dropdown-room-button").attr("value");
        getUsers(time, duration, room);
    });

    $(".drop-duration li a").click(function() {
        $("#dropdown-duration-button:first-child").text($(this).text() + ' minutes');
        $("#dropdown-duration-button:first-child").val($(this).text());
    });

    $(".drop-car li a").click(function() {
        $("#dropdown-car-button:first-child").text($(this).text());
        $("#dropdown-car-button:first-child").val($(this).attr('value'));
    });

    $("#feed-button").click(function() {
        $("#feed-button").attr("style", "color: #dc3545 !important");
        $("#matches-button").attr("style", "color: white;");

        $("#feed-section").attr("style", "display: block !important;");
        $("#matches-section").attr("style", "display: none !important;");
    });

    $("#matches-button").click(function() {
        getMatches(userId);
        $("#matches-button").attr("style", "color: #dc3545 !important");
        $("#feed-button").attr("style", "color: white;");

        $("#feed-section").attr("style", "display: none !important");
        $("#matches-section").attr("style", "display: block !important");
    });
});

function convertTimeToUnix(time) {
    var currDate = new Date().toLocaleDateString();
    var date = new Date(currDate + " " + time);
    return date.getTime() / 1000;
}