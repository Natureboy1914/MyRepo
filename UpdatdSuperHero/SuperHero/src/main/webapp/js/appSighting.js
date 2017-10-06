$(document).ready(function () {
    listAllSightings();
    dDSuperList();
    dDLocationList();
});
function fail() {
    alert("Ajax failed!");
    console.log("Ajax failed!");
}

function listAllSightings(){
    
    var sightTr = $("#sighting");
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/allSightings',
        success: function (response) {


            sightTr.empty();
            var html = "<table class= 'table'>";
            html += "<tr> " + "<th>SuperHero's Name</th>" +
                    "<th>Location</th>" +
                    "<th>Date</th>" +
                    "<th>Edit</th>" +
                    "<th>Delete</th>" + " </tr>";
            response.forEach(function (Sighting) {
                html += "<tr>" + "<td>" + Sighting.name + "</td> " +
                        "<td>" + Sighting.location.name + "</td>" +
                        "<td>" + Sighting.date + "</td> " +
                        "<td><a href='editSighting.jsp' id='editHero' value= " + Sighting.SightingID + " >Edit</a></td>" 
                        + "<td><button class='deleteSighting' value = " + Sighting.SightingID + " >delete</button></td>" + "</tr>";


            });
            html += "</table>";
            sightTr.append(html);
 $(".deleteSighting").click(function () {

                $.ajax({
                    type: 'GET',
                    contentType: 'application/json',
                    dataType: 'json',
                    url: 'http://localhost:8080/SuperHero/deleteSighting/' + $(this).val(),
                    success: function (data) {
                             listAllSightings();
                    },
                    error: function (xhr) {
                       listAllSightings();
                    }
                });

            });
            
             $("#editSighting").click(function () {

                $.ajax({
                    type: 'GET',
                    contentType: 'application/json',
                    dataType: 'json',
                    url: 'http://localhost:8080/SuperHero/editSighting' ,
                    success: function () {
                            listAllSightings();
                    },
                    error: function () {
                       listAllSightings();
                    }
                });

            });
           
        }

    });

}

$("#btnCreateSighting").click(function () {

    var newSight = {
        "name": $("#myHeros").val(),
        "location": $("#heroLocation").val(),
        "date": $("#txtDate").val()
    };


    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/addSighting',
        data: JSON.stringify(newSight),
        success: function (data) {
             listAllSightings();
        },
        error: function (xhr) {
             listAllSightings();
        }
    });

});

   
function dDSuperList() {
    
  var heroTr = $("#herosNames");
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/allHeros',
        success: function (response) {


            heroTr.empty();
            var html = "<select id='myHeros'class= 'select'>";
           response.forEach(function (SuperHero) {
                html +=  "<option value= "+ SuperHero.superHeroID + ">" + SuperHero.name + "</option> ";
                
            });
            html += "</select>";
            heroTr.append(html);
    
        }
    });
    
    }
    
    function dDLocationList() {
    
  var locTr = $("#Loc");
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/allLocations',
        success: function (response) {


            locTr.empty();
            var html = "<select id='heroLocation'class= 'select'>";
           response.forEach(function (Location) {
                html +=  "<option value= "+ Location.locationID + " >" + Location.name + "</option> ";
                
            });
            html += "</select>";
            locTr.append(html);
    
        }
    });
    
    }
    