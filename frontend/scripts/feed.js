var url_prefix = "http://192.168.1.21:8080/back-office/api"


export function getUsers(time, duration, room) {
    console.log("Called getUsers");
    var url = url_prefix + "/user";
    //"/filter?time=" + time + "&duration=" + duration + "&room=" + room;
    console.log(url);

    $.ajax({
        method: "GET",
        url: url,
        async: true,
        success: populateFeed,
        error: undefined
    });
}


function populateFeed(data) {
    var feedCardsContainer = $("#feed-cards");

    data.forEach(item => {
        var cardDiv = $("<div></div>");
        cardDiv.id = "card";
        cardDiv.attr("class", "card col-12 col-lg-2 rounded card shadow p-3 mb-5 bg-body");


        var profilePictureDiv = $("<div></div>");
        profilePictureDiv.attr("class", "w-100 d-flex justify-content-center");
        cardDiv.append(profilePictureDiv);

        var profilePicture = $("<img/>");
        profilePicture.attr("src", item.img);
        profilePicture.attr("class", "profile-picture rounded-circle image-fluid");
        profilePicture.attr("alt", "Profile Picture");
        profilePictureDiv.append(profilePicture);


        var divider = $("<hr>");
        cardDiv.append(divider);

        var cardBody = $("<div></div>");
        cardBody.attr("class", "card-body");
        cardDiv.append(cardBody);

        var personInfoContainer = $("<div></div>");
        personInfoContainer.attr("class", "d-flex align-items-center");
        cardBody.append(personInfoContainer);

        var personNameDiv = $("<div></div>");
        personNameDiv.attr("class", "w-75");
        personInfoContainer.append(personNameDiv);

        var personName = $("<p></p>");
        personName.attr("class", "h3 person-name");
        personName.text(item.name);
        personNameDiv.append(personName);

        var locationContainer = $("<div></div>");
        personInfoContainer.append(locationContainer);

        var location = $("<p></p>");
        location.attr("class", "h5");
        location.text(item.city)
        locationContainer.append(location);

        var description = $("<p></p>");
        description.text(item.description);
        cardBody.append(description);

        var buttonDiv = $("<div></div>");
        buttonDiv.attr("class", "d-flex justify-content-center");
        cardBody.append(buttonDiv);

        var button = $("<button></button>");
        button.attr("class", "w-50 btn btn-danger");
        button.text("Let's Boink!");
        buttonDiv.append(button);

        feedCardsContainer.append(cardDiv);
    });

    /* <div id="card" class="card col-12 col-lg-2 rounded card shadow p-3 mb-5 bg-body">
                    <div class="w-100 d-flex justify-content-center">
                        <img class="profile-picture rounded-circle image-fluid" src=" images/profile-pic.png " alt="Profile Picture ">
                    </div>
                    <hr>
                    <div class="card-body">
                        <div class="d-flex align-items-center">
                            <div class="w-75">
                                <p class="h3 person-name">Mário Vieira</p>
                            </div>
                            <div>
                                <p class="h5">Praia da Vitória</p>
                            </div>
                        </div>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Unde blanditiis obcaecati nesciunt, ipsa maiores exercitationem corrupti. Nostrum assumenda sit temporibus aliquam eligendi sed aut. Aliquam sequi ducimus fuga facere ab,
                            quo mollitia possimus perspiciatis culpa hic sapiente cupiditate reiciendis repudiandae.</p>
                        <div class="d-flex justify-content-center">
                            <button class="w-50 btn btn-danger">Let's Parkour!</button>
                        </div>
                    </div>
                </div>*/
}