var url_prefix = "http://192.168.1.113:8080/back-office/api"


export function getRoomTypes() {
    var url = url_prefix + "/roomtype";

    $.ajax({
        url: url,
        async: true,
        success: populateRoomDropdown,
        error: undefined
    });
}


function populateRoomDropdown(data) {
    var roomList = $("#dropdown-menu");
    data.forEach(item => {
        var listItem = $("<li></li>");
        var link = $("<a></a>");
        link.attr("class", "dropdown-item");
        link.attr("value", item.roomName);
        link.text(item.name);
        link.click(function() {
            $("#dropdown-room-button:first-child").text($(this).text());
            $("#dropdown-room-button:first-child").val($(this).attr('value'));
        })

        listItem.append(link);
        roomList.append(listItem);
    });
}