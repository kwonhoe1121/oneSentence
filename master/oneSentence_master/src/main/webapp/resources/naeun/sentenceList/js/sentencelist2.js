$().ready(function () {
    $('.my').hide();
    $('.all').hide();
    $('.eventA').on('click', function () {
        var $this = $(this);
        $('.my').hide();
        $('.all').hide();
        var k = $this.next().val();         
        var session = $('#session').val();
        if (session==k) { /*여기에서 해당문장의 userIdx와 session의 userIdx를 비교한다.*/
            $this.next().next().find('.my').show();
        }
        $this.next().next().find('.all').show();
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