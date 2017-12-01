
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
			  if(r===null){
				  PNotify.prototype.options.styling = "bootstrap3";
				  var notice = new PNotify({
				   title: 'Error',
				   text: 'Usuario o contraseña incorrectas',
				   type: 'error'
				 });
				 notice.get().click(function() {
				     notice.remove();
				 });

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