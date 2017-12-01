

// $("#btn").click(function(){
//   $.ajax({
//      url:'https://gym-danm97.c9users.io/sucursals',
//      dataType:'json',
//      type:'GET'
//
//   }).done(function (response) {
//   console.log(response);
//       });
//   });
//
//var datos={
//  ubicacion:"San Vicente"
//};
//  $("#btn").click(function(){
//    $.ajax({
//       type:'post',
//       url:'https://gym-danm97.c9users.io/sucursals',
//       data:datos,
//       dataType:'json'
//       
//
//    });
//    });
$(document).ready(function () {
    $("#contact_form").animate({
                                'opacity':'0'
  },1).animate({
                                'opacity':'1'
  },3000);       
    
  $('.texto').animate({
                               'margin-left':'-1500px',
                                'opacity':'0'
                    },1).animate({
                        'margin-left':'0',
                         'opacity':'1'
                    },2000);
            
                    
 });



$("#contact_form").submit(function(e) {
	e.preventDefault();
	$.ajax({
		  type: "POST",
		  url: "https://gym-danm97.c9users.io/login",
		  data: {'codigo':$("#codigo").val(),'contrasena':$("#password").val()},
		  success: function(r){
			  console.log(r);
			  if(r===null){
				  console.log("no existe");
			  }else{
				  createCookie(r.id);
				  location.reload();
			  }
			  
		  },
		  dataType: "json"
		});
})
function createCookie(id){
var b = new Date();
        b.setTime(b.getTime() + ((60 * 1000)*5));
        var c = "; expires=" + b.toGMTString();
        document.cookie = "empleado=" + id + c;
}