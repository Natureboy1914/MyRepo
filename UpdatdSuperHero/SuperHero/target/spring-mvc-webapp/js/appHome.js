$(document).ready(function () {
    listTopSightings();
   
});
function fail() {
    alert("Ajax failed!");
    console.log("Ajax failed!");
}


function listTopSightings(){
    
    var sightTr = $("#recentSightings");
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/recentSightings',
        success: function (response) {


            sightTr.empty();
            var html = "<table class= 'table'>";
            html += "<tr> " + "<th>SuperHero's Name</th>" +
                    "<th>Location</th>" +
                    "<th>Date</th>" + " </tr>";
            response.forEach(function (Sighting) {
                html += "<tr>" + "<td>" + Sighting.name + "</td> " +
                        "<td>" + Sighting.location.name + "</td>" +
                        "<td>" + Sighting.date + "</td> ";


            });
            html += "</table>";
            sightTr.append(html);
        }
    });
}