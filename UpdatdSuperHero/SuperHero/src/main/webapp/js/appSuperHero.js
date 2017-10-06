$(document).ready(function () {
    listAllHeros();

});
function fail() {
    alert("Ajax failed!");
    console.log("Ajax failed!");
}
function listAllHeros() {

    var heroTr = $("#heros");
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/allHeros',
        success: function (response) {


            heroTr.empty();
            var html = "<table class= 'table'>";
            html += "<tr> " + "<th>Name</th>" +
                    "<th>Description</th>" +
                    "<th>SuperPower</th>" +
                    "<th>Edit</th>" +
                    "<th>Delete</th>" + " </tr>";
            response.forEach(function (SuperHero) {
                html += "<tr>" + "<td>" + SuperHero.name + "</td> " +
                        "<td>" + SuperHero.description + "</td>" +
                        "<td>" + SuperHero.superPower + "</td> " +
                        "<td><a href='editHero.jsp' id='editHero' value= " + SuperHero.superHeroID + " >Edit</a></td>" 
                        + "<td><button class='deleteHero' value = " + SuperHero.superHeroID + " >delete</button></td>" + "</tr>";




            });
            html += "</table>";
            heroTr.append(html);

            $(".deleteHero").click(function () {

                $.ajax({
                    type: 'GET',
                    contentType: 'application/json',
                    dataType: 'json',
                    url: 'http://localhost:8080/SuperHero/deleteHero/' + $(this).val(),
                    success: function (data) {
                            listAllHeros();
                    },
                    error: function (xhr) {
                      listAllHeros();
                    }
                });

            });
            
             $("#editHero").click(function () {

                $.ajax({
                    type: 'POST',
                    contentType: 'application/json',
                    dataType: 'json',
                    data: formToJSON(),
                    url: 'http://localhost:8080/SuperHero/editHero'+ $(this).val(),
                    success: function (data) {
                            listAllHeros();
                    },
                    error: function (xhr) {
                      listAllHeros();
                    }
                });

            });
           
        }

    });


}

$("#btnCreateHero").click(function () {

    var newHero = {
        "name": $("#txtName").val(),
        "description": $("#txtDescription").val(),
        "superPower": $("#txtPower").val()
    };


    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/addHero',
        data: JSON.stringify(newHero),
        success: function (data) {
            listAllHeros();
        },
        error: function (xhr) {
            listAllHeros();
        }
    });

});

