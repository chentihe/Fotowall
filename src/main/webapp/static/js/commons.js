$(function() {
	$(".showLogin").on("click", function() {
	    $(".modalLogin").fadeIn(1000);
	});
	$(".showRegister").on("click", function() {
	    $(".modalRegister").fadeIn(1000);
	});
	$(".showUpload").on("click", function() {
	    $(".modalUpload").fadeIn(1000);
	});
	$(window).on("click", function(e) {
	    if ($(e.target).is($("#login"))) {
	        $(".modalLogin").fadeOut(1000);
	    } else if ($(e.target).is($("#register"))) {
			$(".modalRegister").fadeOut(1000);
		} else if ($(e.target).is($("#upload"))) {
			$(".modalUpload").fadeOut(1000);
		}
	});

    $("label>.upload").on("change", function(elem) {
	    let e = elem || window.event;
	    let files = e.target.files;
	    if(files.length>0) {
	        let fileName = [];
	        for (let i = 0; i < files.length; i++) {
	            fileName.push(files[i].name)
	        }
	        $("label>div").text(fileName.join(", "));
	    }else {
	        $("label>div").text("Please Choose Files Again");
	    }
	});
})

