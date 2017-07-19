/*
 * ######################################################################################
 * # LGPL License                                                                       #
 * #                                                                                    #
 * # This file is part of the LightJason AgentSpeak(L++) Traffic-Simulation             #
 * # Copyright (c) 2017, LightJason (info@lightjason.org)                               #
 * # This program is free software: you can redistribute it and/or modify               #
 * # it under the terms of the GNU Lesser General Public License as                     #
 * # published by the Free Software Foundation, either version 3 of the                 #
 * # License, or (at your option) any later version.                                    #
 * #                                                                                    #
 * # This program is distributed in the hope that it will be useful,                    #
 * # but WITHOUT ANY WARRANTY; without even the implied warranty of                     #
 * # MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                      #
 * # GNU Lesser General Public License for more details.                                #
 * #                                                                                    #
 * # You should have received a copy of the GNU Lesser General Public License           #
 * # along with this program. If not, see http://www.gnu.org/licenses/                  #
 * ######################################################################################
 */


/**
 * Resize function without multiple trigger
 *
 * Usage:
 * $(window).smartresize(function(){
 *     // code here
 * });
 */
(function($,sr){
    // debouncing function from John Hann
    // http://unscriptable.com/index.php/2009/03/20/debouncing-javascript-methods/
    var debounce = function (func, threshold, execAsap) {
        var timeout;

        return function debounced () {
            var obj = this, args = arguments;
            function delayed () {
                if (!execAsap)
                    func.apply(obj, args);
                timeout = null;
            }

            if (timeout)
                clearTimeout(timeout);
            else if (execAsap)
                func.apply(obj, args);

            timeout = setTimeout(delayed, threshold || 100);
        };
    };

    // smartresize
    jQuery.fn[sr] = function(fn){  return fn ? this.bind('resize', debounce(fn)) : this.trigger(sr); };

})(jQuery,'smartresize');

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var CURRENT_URL = window.location.href.split('#')[0].split('?')[0],
    $BODY = $('body'),
    $MENU_TOGGLE = $('#menu_toggle'),
    $SIDEBAR_MENU = $('#sidebar-menu'),
    $SIDEBAR_FOOTER = $('.sidebar-footer'),
    $LEFT_COL = $('.left_col'),
    $RIGHT_COL = $('.right_col'),
    $NAV_MENU = $('.nav_menu'),
    $FOOTER = $('footer');

/**
 * Sidebar
 */
function init_sidebar() {
    // TODO: This is some kind of easy fix, maybe we can improve this
    var setContentHeight = function () {
        // reset height
        $RIGHT_COL.css('min-height', $(window).height());

        var bodyHeight = $BODY.outerHeight(),
            footerHeight = $BODY.hasClass('footer_fixed') ? -10 : $FOOTER.height(),
            leftColHeight = $LEFT_COL.eq(1).height() + $SIDEBAR_FOOTER.height(),
            contentHeight = bodyHeight < leftColHeight ? leftColHeight : bodyHeight;

        // normalize content
        contentHeight -= $NAV_MENU.height() + footerHeight;

        $RIGHT_COL.css('min-height', contentHeight);
    };

    $SIDEBAR_MENU.find('a').on('click', function(ev) {
        //console.log('clicked - sidebar_menu');
        var $li = $(this).parent();

        if ($li.is('.active')) {
            $li.removeClass('active active-sm');
            $('ul:first', $li).slideUp(function() {
                setContentHeight();
            });
        } else {
            // prevent closing menu if we are on child menu
            if (!$li.parent().is('.child_menu')) {
                $SIDEBAR_MENU.find('li').removeClass('active active-sm');
                $SIDEBAR_MENU.find('li ul').slideUp();
            }else
            {
                if ( $BODY.is( ".nav-sm" ) )
                {
                    $SIDEBAR_MENU.find( "li" ).removeClass( "active active-sm" );
                    $SIDEBAR_MENU.find( "li ul" ).slideUp();
                }
            }
            $li.addClass('active');

            $('ul:first', $li).slideDown(function() {
                setContentHeight();
            });
        }
    });

    // toggle small or large menu
    $MENU_TOGGLE.on('click', function() {
        //console.log('clicked - menu toggle');

        if ($BODY.hasClass('nav-md')) {
            $SIDEBAR_MENU.find('li.active ul').hide();
            $SIDEBAR_MENU.find('li.active').addClass('active-sm').removeClass('active');
        } else {
            $SIDEBAR_MENU.find('li.active-sm ul').show();
            $SIDEBAR_MENU.find('li.active-sm').addClass('active').removeClass('active-sm');
        }

        $BODY.toggleClass('nav-md nav-sm');

        setContentHeight();
    });

    // check active menu
    $SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').addClass('current-page');

    $SIDEBAR_MENU.find('a').filter(function () {
        return this.href === CURRENT_URL;
    }).parent('li').addClass('current-page').parents('ul').slideDown(function() {
        setContentHeight();
    }).parent().addClass('active');

    // recompute content when resizing
    $(window).smartresize(function(){
        setContentHeight();
    });

    setContentHeight();

    // fixed sidebar
    if ($.fn.mCustomScrollbar) {
        $('.menu_fixed').mCustomScrollbar({
            autoHideScrollbar: true,
            theme: 'minimal',
            mouseWheel:{ preventDefault: true }
        });
    }
};

var randNum = function() {
    return (Math.floor(Math.random() * (1 + 40 - 20))) + 20;
};


/**
 * Panel toolbox
 */
$(document).ready(function() {
    $('.collapse-link').on('click', function() {
        var $BOX_PANEL = $(this).closest('.x_panel'),
            $ICON = $(this).find('i'),
            $BOX_CONTENT = $BOX_PANEL.find('.x_content');

        // fix for some div with hardcoded fix class
        if ($BOX_PANEL.attr('style')) {
            $BOX_CONTENT.slideToggle(200, function(){
                $BOX_PANEL.removeAttr('style');
            });
        } else {
            $BOX_CONTENT.slideToggle(200);
            $BOX_PANEL.css('height', 'auto');
        }

        $ICON.toggleClass('fa-chevron-up fa-chevron-down');
    });

    $('.close-link').click(function () {
        var $BOX_PANEL = $(this).closest('.x_panel');

        $BOX_PANEL.remove();
    });
});

/**
 *  Tooltip
 */
$(document).ready(function() {
    $('[data-toggle="tooltip"]').tooltip({
        container: 'body'
    });
});

/**
 * Progressbar
 */
if ($(".progress .progress-bar")[0]) {
    $('.progress .progress-bar').progressbar();
}

/**
 * Switchery
 */
$(document).ready(function() {
    if ($(".js-switch")[0]) {
        var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
        elems.forEach(function (html) {
            var switchery = new Switchery(html, {
                color: '#26B99A'
            });
        });
    }
});

/**
 * Accordion
 */
$(document).ready(function() {
    $(".expand").on("click", function () {
        $(this).next().slideToggle(200);
        $expand = $(this).find(">:first-child");

        if ($expand.text() === "+") {
            $expand.text("-");
        } else {
            $expand.text("+");
        }
    });
});

/**
 * NProgress
 */
if (typeof NProgress != 'undefined') {
    $(document).ready(function () {
        NProgress.start();
    });

    $(window).load(function () {
        NProgress.done();
    });
}

//hover and retain popover when on popover content
var originalLeave = $.fn.popover.Constructor.prototype.leave;
$.fn.popover.Constructor.prototype.leave = function(obj) {
    var self = obj instanceof this.constructor ?
        obj : $(obj.currentTarget)[this.type](this.getDelegateOptions()).data('bs.' + this.type);
    var container, timeout;

    originalLeave.call(this, obj);

    if (obj.currentTarget) {
        container = $(obj.currentTarget).siblings('.popover');
        timeout = self.timeout;
        container.one('mouseenter', function() {
            //We entered the actual popover – call off the dogs
            clearTimeout(timeout);
            //Let's monitor popover content instead
            container.one('mouseleave', function() {
                $.fn.popover.Constructor.prototype.leave.call(self, self);
            });
        });
    }
};

$('body').popover({
    selector: '[data-popover]',
    trigger: 'click hover',
    delay: {
        show: 50,
        hide: 400
    }
});

function gd(year, month, day) {
    return new Date(year, month - 1, day).getTime();
}

/**
 * AUTOSIZE
 */
function init_autosize() {
    if(typeof $.fn.autosize !== 'undefined'){
        autosize($('.resizable_textarea'));
    }
}

/**
 * PNotify
 */
function init_pnotify() {

    if( typeof (PNotify) === 'undefined'){ return; }
    //console.log('init_PNotify');

    PNotify.prototype.options.styling = "bootstrap3";
    PNotify.prototype.options.styling = "fontawesome";

}

/**
 * creates a notify-message
 *
 * @param px_options object, text, title and type must be set
 */
function notifymessage( px_options )
{
    new PNotify( jQuery.extend( true, { delay: 2500, animate_speed: "fast" }, px_options ) );
}


/**
 * codemirror save function
 *
 * @param pc_id id
 * @param pc_source source code
 */
function codemirrorsave( pc_id, pc_source )
{
    if (!pc_id)
        return;

    LightJason.ajax({
        url: "/api/simulation/asl/set/" + pc_id,
        data: pc_source,
        dataType: "text",
        method: "POST",
        headers: { "Content-Type": "text/plain" }
    })
    .success(function(i) { console.log(i); notifymessage({ title: "Agent", text: i, type: "info" }); })
    .error(function(i) { notifymessage({ title: i.statusText, text: i.responseText, type: "error" }); });
}

CodeMirror.commands.save = function(i) { codemirrorsave( i.options.sourceid, i.getValue() ); };



// -------------------------------------------------------------------------------------------------------------------------------------------------------------

/**
 * document-ready execution
 */
$(document).ready(function() {

    init_sidebar();
    init_pnotify();
    init_autosize();


    // notify messages
    LightJason.websocket( "/message" )
              .onmessage = function ( i )
              {
                  var lo = JSON.parse( i.data );
                  new PNotify({
                      title: lo.title,
                      text: lo.text,
                      type: lo.type,
                      delay: lo.delay,
                      animate_speed: "fast"
                  })
              };


    // get language labels
    jQuery( ".ui-languagelabel" ).each(function(k, e) {
        var lo = jQuery(e);
        LightJason.ajax( "/api/simulation/language/" + lo.data( "languagelabel" ) )
        .success(function(t) { lo.html(t); })
        .error(function(i) { notifymessage({ title: i.statusText, text: i.responseText, type: "error" }); });
    });

    jQuery( ".ui-languagelabeldata" ).each(function(k, e) {
        var lo = jQuery(e);
        LightJason.ajax( "/api/simulation/language/" + lo.data( "languagelabel" ) )
            .success(function(t) { lo.attr( "data-" + lo.data( "languagelabelid" ), t ); })
            .error(function(i) { notifymessage({ title: i.statusText, text: i.responseText, type: "error" }); });
    });


    // set codemirror
    var l_editor = CodeMirror.fromTextArea(
        document.getElementById("ui-editor"),
        {
            lineNumbers: true,
            matchBrackets: true,
            mode: "text/plain",
            indentUnit: 4,
            sourceid: null
        }
    );

    l_editor.on( "blur", function(i) { codemirrorsave( i.options.sourceid, i.getValue() ); } );


    // save code editor
    jQuery( "#ui-savesource" ).click(function() {
        saveAs( new Blob( [l_editor.getValue()], {type: "text/plain;charset=utf-8"}), "agent.asl" );
    });


    // save panelty image
    jQuery( "#ui-savepanelty" ).click(function() {
        jQuery( "#simulation-panelty" ).get(0).toBlob(function( po_blob ) {
            saveAs( po_blob, "panelty.png" );
        });
    });


    // save simulation image
    jQuery( "#ui-savesimulation" ).click(function() {
        jQuery( "#simulation-screen" ).get(0).toBlob(function( po_blob ) {
            saveAs( po_blob, "simulation.png" );
        });
    });


    // set shutdown button
    jQuery( ".simulation-shutdown" ).click(function() {
        LightJason.ajax( "/api/simulation/shutdown" )
            .error(function(i) {
                if ( ( i.status === 503 ) || ( i.status === 0 ) )
                    return;
                notifymessage({ title: i.statusText, text: i.responseText, type: "error" });
            })

    });


    // get agent list
    LightJason.ajax( "/api/simulation/agents" )
        .success(function(o) {
            var l_dom = jQuery( "#ui-agents" );

            o.forEach(function(i) {
                l_dom.append(
                    jQuery("<li>").append(
                        jQuery("<a>").attr( "href", "#" )
                            .attr("data-sourceid", i)
                            .addClass("ui-agent-source")
                            .text(i)
                    )
                );
            });
        });


    // bind action to load source code
    jQuery(document).on( "click", ".ui-agent-source", function() {
        var l_id = jQuery(this).data("sourceid");
        LightJason.ajax( "/api/simulation/asl/get/" + l_id )
            .success(function(i) {
                l_editor.setValue( i );
                l_editor.options.sourceid = l_id;
            })
            .error(function(i) { notifymessage({ title: i.statusText, text: i.responseText, type: "error" }); });
    });



    // set simulation execution
    jQuery( "#simulation-run" ).click(function() {
        LightJason.ajax( "/api/simulation/run" )
                  .error(function(i) { notifymessage({ title: i.statusText, text: i.responseText, type: "error" }); });
    });


    // slide view
    jQuery( ".slide-view" ).click(function() {
        var l_source = jQuery(this).data("slidesource");
        if ( l_source )
            window.open( "slide.htm", l_source ).slide = l_source;
    });

    // set fullscreen structure
    jQuery( "#ui-fullscreen" ).fullscreen();


    // test chart
    new Chart( jQuery( "#simulation-panelty" ), {
        type: "line",
        data: {
            labels: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,15,17,18,19,20],
            datasets: [{
                data: [12, 19, 3, 5, 2, 3, 7, 10, 98, 76, 54, 128, 55, 44, 33],
                fill: false,
                borderColor: "rgba(255,99,132,1)"
            }]
        },
        options: {
            legend: {
                display: false
            }
        }
    });

});


