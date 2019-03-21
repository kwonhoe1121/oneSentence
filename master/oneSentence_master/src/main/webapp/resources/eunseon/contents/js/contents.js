$().ready(function () {
	
	$('.my').hide();
    $('.all').hide();

    $('.eventA').on('click', function () {
        var $this = $(this);
        $('.my').hide();
        $('.all').hide();
        if (true) { 
            $this.next().find('.my').show();
        }
        $this.next().find('.all').show();
    });

    $(document).mouseup(function (e) {
        var container = $('.my');
        var container2 = $('.all');
        if (container.has(e.target).length === 0 || container2.has(e.target).length === 0) {
            container.hide();
            container2.hide();
        }
    })

    
});
