// DOM Ready
$(function () {

    var $el, leftPos, newWidth;
    $mainNav2 = $("#example-two");

    /*
     EXAMPLE ONE
     */

    /* Add Magic Line markup via JavaScript, because it ain't gonna work without */
    $("#example-one").append("<li id='magic-line'></li>");

    /* Cache it */
    var $magicLine = $("#magic-line");
    var $check = $('*').hasClass('current_page_item');

    if ($check) {
        $magicLine
            .width($(".current_page_item").width())
            .css("left", $(".current_page_item a").position().left)
            .data("origLeft", $magicLine.position().left)
            .data("origWidth", $magicLine.width());
        $("#example-one li").find("a").hover(function () {
            $el = $(this);
            leftPos = $el.position().left;
            newWidth = $el.parent().width();
            $magicLine.show();
            $magicLine.stop().animate({
                left: leftPos,
                width: newWidth
            });
        }, function () {
            $magicLine.stop().animate({
                left: $magicLine.data("origLeft"),
                width: $magicLine.data("origWidth")
            });
        });
    }
    else {
        $magicLine.hide();
        $("#example-one li").find("a").hover(function () {
            $el = $(this);
            leftPos = $el.position().left;
            newWidth = $el.parent().width();
            $magicLine.show();
            $magicLine.stop().animate({
                left: leftPos,
                width: newWidth
            });
        }, function () {
            $magicLine.stop().animate({
                left: $magicLine.data("origLeft"),
                width: $magicLine.data("origWidth")
            }).hide();
        });
    }


    /*
     EXAMPLE TWO
     */

    $mainNav2.append("<li id='magic-line-two'></li>");

    var $magicLineTwo = $("#magic-line-two");

    $magicLineTwo
        .width($(".current_page_item_two").width())
        .height($mainNav2.height())
        .css("left", $(".current_page_item_two a").position().left)
        .data("origLeft", $(".current_page_item_two a").position().left)
        .data("origWidth", $magicLineTwo.width())
        .data("origColor", $(".current_page_item_two a").attr("rel"));

    $("#example-two a").hover(function () {
        $el = $(this);
        leftPos = $el.position().left;
        newWidth = $el.parent().width();
        $magicLineTwo.stop().animate({
            left: leftPos,
            width: newWidth,
            backgroundColor: $el.attr("rel")
        })
    }, function () {
        $magicLineTwo.stop().animate({
            left: $magicLineTwo.data("origLeft"),
            width: $magicLineTwo.data("origWidth"),
            backgroundColor: $magicLineTwo.data("origColor")
        });
    });

    /* Kick IE into gear */
    $(".current_page_item_two a").mouseenter();


});