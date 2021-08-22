$(function() {
    $(".nav > ul > li").mouseenter(function() {
        $(this).children("ul").slideDown();
    });
    $(".nav > ul > li").mouseleave(function() {
        $(this).children("ul").stop(true, false);
        $(this).children("ul").slideUp();
    });
})