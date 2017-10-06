$(document).ready(function () {
    listAllOrganizations();
    
});
function fail() {
    alert("Ajax failed!");
    console.log("Ajax failed!");
}

function listAllOrganizations() {

    var locTr = $("#organization");
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/allOrganizations',
        success: function (response) {


            locTr.empty();
            var html = "<table class= 'table'>";
            html += "<tr> " + "<th>Name</th>" +
                    "<th>Description</th>" +
                    "<th>Address</th>" +
                    "<th>Email</th>" +
                    "<th>Edit</th>" +
                    "<th>Delete</th>" + " </tr>";
            response.forEach(function (Organization) {
                html += "<tr>" + "<td>" + Organization.name + "</td> " +
                        "<td>" + Organization.description + "</td>" +
                        "<td>" + Organization.address + "</td> " +
                        "<td>" + Organization.email + "</td> " +
                        "<td><a href='editOrganization.jsp' id='editOrganization' value= " + Organization.orgID + " >Edit</a></td>" 
                        + "<td><button class='deleteOrganization' value = " + Organization.orgID + " >delete</button></td>" + "</tr>";


            });
            html += "</table>";
            locTr.append(html);

            $(".deleteOrganization").click(function () {

                $.ajax({
                    type: 'GET',
                    contentType: 'application/json',
                    dataType: 'json',
                    url: 'http://localhost:8080/SuperHero/deleteOrganization/' + $(this).val(),
                    success: function (data) {
                            listAllOrganizations();
                    },
                    error: function (xhr) {
                      listAllOrganizations();
                    }
                });

            });
            
             $("#editOrganization").click(function () {

                $.ajax({
                    type: 'GET',
                    contentType: 'application/json',
                    dataType: 'json',
                    data:$("#editOrganization").serialize(),
                    url: 'http://localhost:8080/SuperHero/editOrganization' + $(this).val(),
                    success: function (data) {
                            listAllOrganizations();
                    },
                    error: function (xhr) {
                      listAllOrganizations();
                    }
                });

            });
           
        }

    });


}

$("#btnCreateOrganization").click(function () {

    var newLoc = {
        "name": $("#txtName").val(),
        "description": $("#txtDescription").val(),
        "address": $("#txtAddress").val(),
        "email": $("#txtEmail").val()  
    };

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        url: 'http://localhost:8080/SuperHero/addOrganization',
        data: JSON.stringify(newLoc),
        success: function (data) {
            listAllOrganizations();
        },
        error: function (xhr) {
            listAllOrganizations();
        }
    });

});


