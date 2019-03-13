$(window).scroll(function() {
    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
        $('.col-lg-8').append('<div class="card my-4"><h4 class="card-header">한 문장</h4></div>');
    }
});

