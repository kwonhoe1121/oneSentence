//$(document).ready(function(){
//    $(window).scroll(function(){
//        var scrollHeight=$(window).scrollTop()+$(window).height();
//        var documentHeight=$(document).height();
//        console.log("window의 height() : " + $(window).height());
//        if(scrollHeight==documentHeight)
//            {
//                for(var i=0; 1<10; i++)
//                {
//                    $('<h1>무한스크롤</h1>')
//                    .appendTo('#bookscroll');
//                }
//            }
//    });
//    
//});


//<c:forEach items="${items}" var="b"><div class="book_div"><imgsrc="${b.cover}"alt="book_1" class="img-fluid img-rounded book_img"><p class="ptitle"><strong>${b.title }</strong></p><p class="ptext_01">${b.author }</p><p class="ptext_01">${b.publisher }</p><p class="ptext_01"><c:out value="${fn:substring(b.pubDate,5,16)}"/></p><hr></div></c:forEach>
//$(window).scroll(function () {
//    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
//        $('.bookmore').append('<div class=\"book_div\"><img src = \"../search/img/book1.jpg\" alt=\"book_1\" class=\"img-fluid img-rounded book_img\"> <p class = \"ptitle\"><strong>강아지와고양이</strong></p> <p class = \"ptext_01\">김철수</p> <p class = \"ptext_01\">강아지출판사</p> <p class = \"ptext_01\">2019</p> <hr > < /div>');
//    }
//});
