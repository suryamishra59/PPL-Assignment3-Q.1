/**
 * @author: Surya Deep Mishra
 */

$(document).ready(function() {
	$("#submitBtnJS").click(function(e) {
		e.preventDefault();
		var to = $("#email").val();
		var subject = 'Feedback | Assignment';
		var msg = $("#msg").val();
		window.open('mailto:suryamishra59@gmail.com?subject='+subject+"&body="+msg);
	});
	
	$("#submitBtnJava").click(function(e) {
		e.preventDefault();
		$("html, body").css("-webkit-animation", "expand 0.9s infinite alternate");
        $("html, body").css("-moz-animation", "expand 0.9s infinite alternate");
        $("html, body").css("-ms-animation", "expand 0.9s infinite alternate");
        $("html, body").css("animation", "expand 0.9s infinite alternate");
		var to = $("#email").val();
		var subject = 'Feedback | Assignment';
		var msg = $("#msg").val();
		$.ajax({
			type : "POST",
			url : $("#emailForm").attr('action'),
			data : $("#emailForm").serialize(),
			success : function(data) {
				$("#emailForm")[0].reset();
				$("html, body").css("-webkit-animation", "none");
                $("html, body").css("-moz-animation", "none");
                $("html, body").css("-ms-animation", "none");
                $("html, body").css("animation", "none");
				swal("Success", data, "success");
			},
			error : function(data) {
				$("html, body").css("-webkit-animation", "none");
                $("html, body").css("-moz-animation", "none");
                $("html, body").css("-ms-animation", "none");
                $("html, body").css("animation", "none");
				alert(data);
			}
		});
	});
});