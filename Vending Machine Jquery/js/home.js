$(document).ready(function(){
  loadItems();
  DollarButton();
  QuarterButton();
  DimeButton();
   NickelButton();

$("#make-purchase").click(function(event){
VendItem( $("#item-display").val(),$("#money-display").val());


})

});

function loadItems(){
  var myItems = $('#items');


  $.ajax({
    type:'GET',
    url:'http://localhost:8080/items',
    success:function(itemArray){
      $.each(itemArray, function(index,items){
        var id = items.id;
        var name = items.name;
        var price = items.price;
        var quantity = items.quantity;



        //   $(".theItem").hover(function(){
        //     $(this).css("background-color", "grey");
        //
        // });

        var currentItem = '<div class="col-md-4  theItem" >';
        currentItem += '<p class="myId">' + id + '</p>';
        currentItem += '<p >' + name + '</p>';
        currentItem += '<p >$' + price +  '</p>';
        currentItem += '<p>Quantity Left: ' + quantity + '</p>';
        currentItem += '</div>'
        myItems.append(currentItem);



        $(".theItem").click(function(event){
          $('#item-display').val($(this).find(".myId").text());

        });

        $( ".theItem" ).hover(function(){
          $(this).css("background-color", "grey");

        }, function(){
          $(this).css("background-color", "");
        });


      });
    },


  });
}

function VendItem(id,price){


  $.ajax({
    type:'GET',
    url: 'http://localhost:8080/money/' + price + '/item/'+ id,
    success:function(data){
      var quarter = data.quarters;
      var dime = data.dimes;
      var nickle = data.nickels;
      var pennies = data.pennies;


      var change = $("#change-display");
      change.val("Quarters: " + quarter +""+ "Dimes: " + dime +""+ "nickels: " + nickle +""+"Pennies: " + pennies);

    },

    error:function(vendMessage){
      var messageObj = JSON.parse(vendMessage.responseText);
      $("#message-display").val(messageObj.message);
    }


  })
}

function DollarButton(){
          var dollar = 1.00;

          $("#add-dollar").click(function(event){

          var updateMoney = parseFloat($("#money-display").val());
                updateMoney += dollar;
                  $("#money-display").val(updateMoney) ;
            });
}

function QuarterButton(){
  var quarter = 0.25;

  $("#add-quarter").click(function(event){

  var updateMoney = parseFloat($("#money-display").val());
        updateMoney += quarter;

          $("#money-display").val(updateMoney) ;

    });

  }

function DimeButton(){

var dime = 0.10;

  $("#add-dime").click(function(event){

  var updateMoney = parseFloat($("#money-display").val());
        updateMoney += dime;
          $("#money-display").val(updateMoney) ;

    });

  }


function NickelButton(){
  var nickel = 0.05;

  $("#add-nickel").click(function(event){

  var updateMoney = parseFloat($("#money-display").val());
        updateMoney += nickel;

      $("#money-display").val(updateMoney) ;
    });

  }
