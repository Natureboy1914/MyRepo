$(document).ready(function () {
    listAllLocations();
    
});
function fail() {
    alert("Ajax failed!");
    console.log("Ajax failed!");
}

function listAllLocations() {

    var locTr = $("#location");
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/allLocations',
        success: function (response) {


            locTr.empty();
            var html = "<table class= 'table'>";
            html += "<tr> " + "<th>Name</th>" +
                    "<th>Description</th>" +
                    "<th>Address</th>" +
                    "<th>latitude</th>" +
                    "<th>longitude</th>" +
                    "<th>Edit</th>" +
                    "<th>Delete</th>" + " </tr>";
            response.forEach(function (Location) {
                html += "<tr>" + "<td>" + Location.name + "</td> " +
                        "<td>" + Location.description + "</td>" +
                        "<td>" + Location.address + "</td> " +
                        "<td>" + Location.latitude + "</td> " +
                        "<td>" + Location.longitude + "</td> " +
                        "<td><a href='editLoc.jsp' id='editLoc' value= " + Location.locationID + " >Edit</a></td>" 
                        + "<td><button class='deleteLocation' value = " + Location.locationID + " >delete</button></td>" + "</tr>";


            });
            html += "</table>";
            locTr.append(html);

            $(".deleteLocation").click(function () {

                $.ajax({
                    type: 'GET',
                    contentType: 'application/json',
                    dataType: 'json',
                    url: 'http://localhost:8080/SuperHero/deleteLocation/' + $(this).val(),
                    success: function (data) {
                            listAllLocations();
                    },
                    error: function (xhr) {
                      listAllLocations();
                    }
                });

            });
            
             $("#editLocation").click(function () {

                $.ajax({
                    type: 'PUT',
                    contentType: 'application/json',
                    dataType: 'json',
                    data:$("#editLocation").serialize(),
                    url: 'http://localhost:8080/SuperHero/editLocation' + $(this).val(),
                    success: function (data) {
                            listAllLocations().update();
                    },
                    error: function (xhr) {
                      listAllLocations();
                    }
                });

            });
           
        }

    });


}

$("#btnCreateLocation").click(function () {

    var newLoc = {
        "name": $("#txtName").val(),
        "description": $("#txtDescription").val(),
        "address": $("#txtAddress").val(),
        "latitude": $("#txtlatitude").val(),
        "longitude": $("#txtlongitude").val()  
    };

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/addLocation',
        data: JSON.stringify(newLoc),
        success: function (data) {
            listAllLocations();
        },
        error: function (xhr) {
            listAllLocations();
        }
    });

});

