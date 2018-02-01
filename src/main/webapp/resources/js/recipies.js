var ajaxUrl = "cookbook/recipies/";

//
// $(document).ready(function() {
//     $('#userName').blur(function() {
//         $.ajax({
//             url : ajaxUrl + "getByUser",
//             data : {
//                 user : $('#userName').val()
//             },
//             success : function(responseText) {
//                 $('#ajaxGetUserServletResponse').text(responseText);
//             }
//         });
//     });
// });
// $(document).ready(function(){
//     $("button").click(function(){
//         $.get(ajaxUrl, function(data, status){
//             alert("Data: " + data + "\nStatus: " + status);
//         });
//     });
// });
$(document).on("click", "#userName", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    $.get(ajaxUrl + "getByUser", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
        $("#ajaxGetUserServletResponse").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    });
});