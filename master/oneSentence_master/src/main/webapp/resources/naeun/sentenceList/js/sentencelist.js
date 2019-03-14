$().ready(function () {   
	$(window).scroll(function() {
    	 if ($(window).scrollTop() == $(document).height() - $(window).height()) {
            $('.col-lg-8').append('<div class="newdiv"><span style="color: darkgray;padding-right:1rem">1</span><a href="#" style="color: black"><i class="fa fa-user icon">  신짱구2</i></a><span class="eventA"><i class="fa fa-ellipsis-v icon"></i></span><center><div class="divmodal"><div class="my"><a href="#"><i class="fa fa-reply icon"></i></a></div><div class="my"><a href=""><i class="fa fa-remove icon"></i></a></div><div class="all"><a href="#"><i class="fa fa-send-o icon"></i></a></div></div></center><span style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">2019.3.12 23:10</span><br> <span style="padding-left: 2rem; font-size: 1.5rem;">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</span><br> <span style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray"><i>채식주의자, 한강, 창비, p128 에서.. </i></span><br><hr><span class="hashtag" >#봉미선 #흰둥이</span><span class="like"><i class="fa fa-heart"> 11</i></span></div>');
            $('.my').hide();
            $('.all').hide();
        }
    });     
   
 });  