//책검색 이벤트
function bookSearch() {
    //검색어 가져오기
    var searchName = document.getElementById("searchName").value;
    //이전 검색어 결과 제거
    document.getElementById("result").innerHTML = "";
    console.log(searchName);

    
    $.ajax({
        url: "https://www.googleapis.com/books/v1/volumes?q=" + searchName, // 검색어 가져온것 구글 api에서 가져온다.
        dataType: "json",
        type: "GET",
        success: function (data) { //jQuery는 가져온 json를 알아서 parsing해준다. -> 배열로 담아준다.
            console.log(data);//data 속성확인.
            //배열만큼 루프돌기.(data.items)
            for (var i = 0; i < data.items.length; i++) {
                //현재 책의 정보.
                var searchData = data.items[i].volumeInfo;

                //요소(element) 생성
                var container = document.createElement("div");
                var img = document.createElement("img");
                var bookName = document.createElement("h2");
                var bookAuthor = document.createElement("h3");
                var publishedYear = document.createElement("h4");
                var moreInfo = document.createElement('a');
                
                //요소(element)에 클래스 추가
                container.className = "container";
                moreInfo.className = "moreInfo";

                //텍스트 삽입.
                bookName.innerText = searchData.title;
                moreInfo.innerText = "see more";

                //정보 더보기 link연결
                moreInfo.href = searchData.infoLink;
                
//                moreInfo.setAttribute("target", "_blank");

                //img 삽입.
                if (searchData.imageLinks) {
                    img.src = searchData.imageLinks.thumbnail;
                } else {
                    img.src = 'noCover.jpg';
                }

                //출판 날짜 삽입.
                if (searchData.publishedDate) {
                    publishedYear.innerText = searchData.publishedDate;
                } else {
                    publishedYear.innerHTML = "no publish date found";
                }

                //작가 텍스트 삽입.
                if (searchData.authors) {
                    bookAuthor.innerText = searchData.authors[0];
                } else {
                    bookAuthor.innerText = "author's name not available";
                }

                //dom 구조 완성하기. - container.
                container.appendChild(img);
                container.appendChild(bookName);
                container.appendChild(bookAuthor);
                container.appendChild(publishedYear);
                container.appendChild(moreInfo);

                //dom 구조 붙이기.
                var result = document.getElementById("result");
                result.appendChild(container);
            }
        }
    })
};

//enter key 이벤트
function pressEnter(e) {
    if(e.keyCode === 13){
//        console.log(e);
//        console.log(this);
        bookSearch();
    }
};

//이벤트 걸기.
document.getElementById("search").addEventListener('click', bookSearch, false);
document.getElementById("searchName").addEventListener('keypress', pressEnter, false);