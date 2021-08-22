$(function() {
    $(".img").on("click", function() {
        let src = $(this).attr("src");
        $(".imgPreview img").attr("src", src);
        $(".imgPreview").show();
    });
    $(".imgPreview").on("click", function() {
        $(".imgPreview").hide();
    });
})