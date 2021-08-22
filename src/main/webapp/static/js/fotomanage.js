$(function() {

    $(".column").on({
        "click":function() {
            let delFoto = $(this).find("input");
            if(delFoto.prop("checked")) {
                delFoto.prop("checked", false);
                $(this).find("img").css("opacity", 1);
            } else {
                delFoto.prop("checked", true);
                $(this).find("img").css("opacity", 0.7);
            };
            let numOfAll = $(".column input").length;
            let numOfSelected = $(".column input:checked").length;
            (numOfSelected==0)? $(".delete").prop("type", "hidden"):$(".delete").prop("type", "submit");
            (numOfAll == numOfSelected)?$(".all").text("Cancel All"):$(".all").text("Select All");
        },
        "mouseenter": function() {
            if(!$(this).find("input").prop("checked")) {
                $(this).find("span").fadeIn();
            }
        },
        "mouseleave": function() {
            if(!$(this).find("input").prop("checked")) {
                $(this).find("span").stop(true, false);
                $(this).find("span").fadeOut();
            }
        }
    });
    $(".all").on("click", function() {
        let numOfAll = $(".column input").length;
        let numOfSelected = $(".column input:checked").length;
        if (numOfSelected == numOfAll) {
            $(".column input").prop("checked", false);
            $(".column span").hide();
            $(".all").text("Select All");
            $(".delete").prop("type", "hidden");
            $(".column img").css("opacity", 1);
        } else {
            $(".column input").prop("checked", true);
            $(".column span").show();
            $(".all").text("Cancel All");
            $(".delete").prop("type", "submit");
            $(".column img").css("opacity", 0.7);
        }
        
    });
    $(".delete").on("click", function() {
        let isDel = confirm("Are you sure to Delete these fotos?");
        return isDel;
    });
	$(".showUpload").on("click", function() {
		$(".modalUpload").show();
	});
	$(window).on("click", function(e) {
		if ($(e.target).is($("#upload"))) {
			$(".modalUpload").fadeOut(1000);
		}
	});
})