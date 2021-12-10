$(function events() {
    $(".drop-duration li a").click(function() {
        $("#dropdown-duration-button:first-child").text($(this).text() + ' minutes');
        $("#dropdown-duration-button:first-child").val($(this).text());
    });

    $(".drop-room li a").click(function() {
        $("#dropdown-room-button:first-child").text($(this).text());
        $("#dropdown-room-button:first-child").val($(this).text());
    });

    $("#feed-button").click(function() {
        $("#feed-section").attr("style", "display flex!important");
        $("#matches-section").attr("style", "display none!important");
    });

    $("#matches-button").click(function() {
        $("#feed-section").attr("style", "display:none!important");
        $("#matches-section").attr("display", "display:flex!important");
    });
});