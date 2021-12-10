import { carTypes } from "./events.js";

var url_prefix = "http://192.168.1.113:8080/back-office/api"
var roomType;

export function getMatches(userId) {
    console.log("called getMatches");
    var url = url_prefix + "/match/" + userId

    $.ajax({
        url: url,
        async: true,
        success: populateMatches,
        error: undefined
    });
}

function populateMatches(data) {
    var matchesCardsContainer = $("#matches-cards");

    data.forEach(item => {
        var cardDiv = $("<div></div>");
        cardDiv.attr("class", "card-matches card col-12 col-lg-2 rounded card shadow p-3 mb-5 bg-body");


        //Header

        var cardHeader = $("<div></div>");
        cardHeader.attr("class", "w-100 d-flex justify-content-center flex-column matches-images-container");
        cardDiv.append(cardHeader);

        var roomImg = $("<img/>");
        roomImg.attr("class", "image-fluid position-absolute room-image top-0");
        roomImg.attr("src", item.roomImg);
        roomImg.attr("alt", "Room Photo");
        cardHeader.append(roomImg);

        var personImageContainer = $("<div><div/>");
        personImageContainer.attr("class", "person-image-matches-container");
        cardHeader.append(personImageContainer);

        var profilePicture = $("<img/>");
        profilePicture.attr("src", item.profilePicture);
        profilePicture.attr("alt", "Profile Picture");
        profilePicture.attr("class", "profile-matches-picture rounded-circle image-fluid");
        personImageContainer.append(profilePicture);

        var personInfoContainer = $("<div></div>");
        personInfoContainer.attr("class", "person-info-matches-container p-1 w-100 d-flex flex-row");
        cardHeader.append(personInfoContainer);

        var nameContainer = $("<div></div>");
        nameContainer.attr("class", "w-50 ps-3");
        personInfoContainer.append(nameContainer);

        var name = $("<p></p>");
        name.attr("class", "h3 person-name-matches");
        name.text(item.personName);
        nameContainer.append(name);

        var locationContainer = $("<div></div>");
        locationContainer.attr("class", "w-50 text-end pe-3");
        personInfoContainer.append(locationContainer);

        var location = $("<p></p>");
        location.attr("class", "h5 person-location-matches");
        locationContainer.append(location);



        //Body
        var cardBody = $("<div></div>");
        cardBody.attr("class", "card-body");
        cardDiv.append(cardBody);

        var bodyContainer = $("<div></div>");
        bodyContainer.attr("class", "body-container");
        cardBody.append(bodyContainer);

        var carDropdown = $("<div></div>");
        carDropdown.attr("class", "w-50 mb-1 dropdown d-flex justify-content-center flex-row");
        bodyContainer.append(carDropdown);

        var dropdownButton = $("<button></button>");
        dropdownButton.attr("class", "w-100 btn btn-secondary dropdown-toggle");
        dropdownButton.attr("id", "dropdown-car-button");
        dropdownButton.attr("type", "button");
        dropdownButton.attr("data-bs-toggle", "dropdown");
        dropdownButton.attr("aria-expanded", "false");
        dropdownButton.text("Car");
        carDropdown.append(dropdownButton);

        var list = $("<ul></ul>");
        list.attr("class", "w-100 dropdown-menu drop-car");
        list.attr("aria-labelledby", "dropdownMenuButtonRoom");
        carDropdown.append(list);

        carTypes.forEach(carType => {
            var listItem = $("<li></li>");
            var link = $("<a></a>");

            link.attr("class", "dropdown-item");
            link.attr("value", item.carName);
            link.text(item.name);
            listItem.append(link);
            list.append(listItem);
        });


        var priceInfoContainer = $("<div></div>");
        priceInfoContainer.attr("class", "w-100 d-flex justify-content-center");
        cardBody.append(priceInfoContainer);

        var priceContainer = $("<div></div>");
        priceContainer.attr("w-50");
        priceInfoContainer.append(priceContainer);

        var carPrice = $("<p></p>");
        carPrice.attr("class", "h5");
        carPrice.attr("id", "carPrice");
        var carTypePrice = carTypes.find((carType) => carType.carName === $("#dropdown-car-button").attr("value"))
        carPrice.text("Car: " + carTypePrice + "$");
        priceContainer.append(carPrice);


        var roomPrice = $("<p></p>");
        carPrice.attr("class", "h5");
        carPrice.attr("id", "roomPrice");
        carPrice.text("Room: " + roomType.price);
        priceContainer.append(roomPrice);


        var totalPrice = $("<p></p>");
        carPrice.attr("class", "h5");
        carPrice.attr("id", "totalPrice");
        carPrice.text("Total: " + roomType.price + carType.price);
        priceContainer.append(totalPrice);


        var finishButtonContainer = $("<div></div>");
        finishButtonContainer.attr("class", "d-flex justify-content-center");
        cardBody.append(finishButtonContainer);

        var finishButton = $("<button></button>");
        finishButton.attr("class", "w-50 btn btn-danger");
        finishButton.text("Finish");
        finishButtonContainer.append(finishButton);
    });


    /*
     <div id="card" class="card-matches card col-12 col-lg-2 rounded card shadow p-3 mb-5 bg-body ">
                    <div class="card-body">
                  


                        <div class="d-flex justify-content-center">
                            <button class="w-50 btn btn-danger">Finish</button>
                        </div>

                    </div>
                </div> */
}