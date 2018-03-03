// Transform a textbox into a combobox, so users can enter text or select offered text
// Could be called more than once on the same textbox, however only the first time calling counts -- which means you can't change the suggestions once the combobox is created.
// deerchao@gmail.com   2009-3-16

// usage:
//--------------Html----------------
// <input class="combo" />
//--------------Script-------------
// jQuery('.combo').combobox(['option1', 'option2', 'option3'], {imageUrl : '/images/dropdown.gif'});

(function ($) {
    $.fn.combobox = function (data, config) {
        //keyCode data from http://unixpapa.com/js/key.html
        var keys = {up: 38, down: 40, enter: 13, tab: 9, esc: 27};
        var initKey = 'combobox_initialized';

        config = $.extend({imageUrl: 'dropdown.gif'}, config);

        $(this).each(function (i) {
            var textBox = $(this);

            //exit if already initialized
            if ($.data(this, initKey))
                return;
            $.data(this, initKey, true);

            //turn off browser auto complete feature for textbox
            textBox.attr('autocomplete', 'off').focus(function () {
                show('');
            }).blur(blur).keydown(keydown).keyup(keyup);

            //set different zIndeces to TRY to fixe the ie bug. search "relative ie z-index bug" for more infomation
            var container = textBox.wrap('<div class="combobox" />').parent().css('zIndex', 1000 - i);

            var button = $('<img class="button" src="' + config.imageUrl + '" />').appendTo(container).css({
                top: 1,
                left: textBox.width(),
                height: textBox.height() + 3
            }).click(function () {
                textBox.focus();
            });

            //the ul that contains all the suggestions
            var select;
            //keeps the original value of textbox so we can recove it if use presses esc
            var oriValue;

            function show(filter) {
                oriValue = textBox.val();
                hide();

                //generate the selection ul
                var html = '<ul class="select">';
                for (var k in data) {
                    var v = data[k];
                    if ((!filter) || (filter && v.indexOf(filter) >= 0)) {
                        html += '<li>' + v + '</li>';
                    }
                }
                html += '</ul>';
                select = $(html).appendTo(container).css({
                    left: 0,
                    top: textBox.height() + 3,
                    width: textBox.width() + button.width() - 2
                });
                //if there is jquery.bgiframe plugin, use it to fix ie6 select/z-index bug.
                //search "z-index ie6 select bug" for more infomation
                if (select.bgiframe)
                    select.bgiframe();

                //decide which option is currently selected
                selIndex = 0;
                var found = false;
                var options = select.children('li').each(function (i) {
                    if (found) return;
                    if ($(this).text() == oriValue) {
                        $(this).addClass('selected');
                        selIndex = i;
                        found = true;
                    }
                });
                //if there is no items matched, hide the empty select list, so user can show options with down key
                if (!options.size()) {
                    hide();
                    return;
                }
                if (!found)
                    options.eq(0).addClass('selected');

                //mouse hover to change the highlight option, clicking to select it
                options.click(function () {
                    textBox.val($(this).text());
                }).hover(function () {
                        options.each(function () {
                            $(this).removeClass('selected');
                        });
                        $(this).addClass('selected');
                        selIndex = options.index(this);
                    },
                    function () {
                        $(this).removeClass('selected');
                    }
                );

                $(document).click(pageClick);

                if (!filter)
                //showing all the options
                    select.slideDown();
                else
                //showing filtered options, happens when textbox.value changed, should not flick
                    select.show();
            }

            var selIndex;

            function keydown(evt) {
                switch (evt.keyCode) {
                    case keys.esc:
                        hide();
                        textBox.val(oriValue);
                        //fixes esc twice clears the textbox value bug in ie
                        evt.preventDefault();
                        return;
                    case keys.enter:
                        choose();
                        //don't submit the form
                        evt.preventDefault();
                        return;
                    case keys.tab:
                        choose();
                        return;
                    case keys.up:
                        goup();
                        return;
                    case keys.down:
                        godown();
                        return;
                }
            }

            function godown() {
                if (select) {
                    var options = select.children('li');
                    var n = options.size();
                    if (!n)
                        return;
                    selIndex++;

                    if (selIndex > n - 1)
                        selIndex = 0;

                    var v = options.eq(selIndex);
                    if (v.size()) {
                        options.each(function () {
                            $(this).removeClass('selected')
                        });
                        v.addClass('selected');
                    }
                } else {
                    show('');
                }
            }

            function goup() {
                if (select) {
                    var options = select.children('li');
                    var n = options.size();
                    if (!n)
                        return;
                    selIndex--;

                    if (selIndex < 0)
                        selIndex = n - 1;

                    var v = options.eq(selIndex);
                    if (v.size()) {
                        options.each(function () {
                            $(this).removeClass('selected')
                        });
                        v.addClass('selected');
                    }
                } else {
                    show('');
                }
            }

            function choose() {
                if (select) {
                    var v = $('li', select).eq(selIndex);
                    if (v.size()) {
                        textBox.val(v.text());
                        oldVal = v.text();
                        hide();
                    }
                }
            }

            var oldVal = '';

            function keyup(evt) {
                var v = $(this).val();
                if (v != oldVal) {
                    show(oldVal = v);
                }
            }

            function hide() {
                if (select) {
                    if (hideTimeout) {
                        window.clearTimeout(hideTimeout);
                        hideTimeout = 0;
                    }
                    $(document).unbind('click', pageClick);
                    select.remove();
                    select = null;
                }
            }

            var hideTimeout;

            function blur() {
                $(document).unbind('click', pageClick);
                //if there's no setTimeout, when clicking option li,
                //textBox.blur comes first, so hide is called, and the ul.select is removed
                //so li.click won't fire
                hideTimeout = window.setTimeout(hide, 200);
            }

            function pageClick(evt) {
                //unless we clicked the textbox or the button, hide the suggestions
                if (evt.target != textBox[0] && evt.target != button[0])
                    hide();
            }
        });
    };
})(jQuery);
