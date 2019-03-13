<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>search page</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/dahye/search/css/bootstrap.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/dahye/search/css/search.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/dahye/search/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/dahye/search/js/util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/dahye/search/js/search.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/dahye/search/js/bootstrap.js"></script>
</head>
<body>
	<div class="all">
		<h2 class="h2">
			<strong>통합 검색 결과</strong><a href=""><span class="more"><strong>더보기</strong></span></a>
		</h2>
		<div class="container">
			<div class="row">
				<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1"
					id="MultiCarousel" data-interval="1000">
					<div class="MultiCarousel-inner">
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
								<p class="ptitle">
									<strong>강아지와고양이</strong>
								</p>
								<p class="ptext_01">김철수</p>
								<p class="ptext_01">강아지출판사</p>
								<p class="ptext_01">2019</p>
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book2.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book3.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book4.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book5.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book6.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book2.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book3.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
					</div>

					<button class="btn btn-primary leftLst"><</button>
					<button class="btn btn-primary rightLst">></button>
				</div>
			</div>
		</div>
	</div>
	</div>


	<hr>

	<div class="book_lank">
		<h2 class="h2">
			<strong>인기순</strong><a href=""><span class="more"><strong>더보기</strong></span></a>
		</h2>
		<div class="container">
			<div class="row">
				<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1"
					id="MultiCarousel" data-interval="1000">
					<div class="MultiCarousel-inner">
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
								<p class="ptitle">
									<strong>강아지와고양이</strong>
								</p>
								<p class="ptext_01">김철수</p>
								<p class="ptext_01">강아지출판사</p>
								<p class="ptext_01">2019</p>
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book2.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book3.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book4.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book5.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book6.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book2.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book3.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
						<div class="item">
							<div class="pad15">
								<img src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg" alt="book_1"
									class="img-fluid img-rounded book_img">
							</div>
						</div>
					</div>

					<button class="btn btn-primary leftLst"><</button>
					<button class="btn btn-primary rightLst">></button>
				</div>
			</div>
		</div>
		<hr>
	</div>
	<div class="user_search">
		<h2 class="h2">
			<strong>사용자</strong><a href=""><span class="more"><strong>더보기</strong></span></a>
		</h2>
		<div class="line">
			<img src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png" alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img"> <span class="usertext">강아지</span>
			<img src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png" alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img"> <span class="usertext">강아지</span>
			<img src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png" alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img"> <span class="usertext">강아지</span>
			<hr>
			<img src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png" alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img"> <span class="usertext">강아지</span>
			<img src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png" alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img"> <span class="usertext">강아지</span>
			<img src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png" alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img"> <span class="usertext">강아지</span>

			<hr>
			<img src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png" alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img"> <span class="usertext">강아지</span>
			<img src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png" alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img"> <span class="usertext">강아지</span>
			<img src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png" alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img"> <span class="usertext">강아지</span>
		</div>
	</div>
	<hr>
	</div>
	<div class="hashtagsearch">

		<h2 class="h2">
			<strong>한문장 검색결과</strong><a href=""><span class="more"><strong>더보기</strong></span></a>
		</h2>
		<table>
			<tr>
				<td>이름</td>
				<td>책이름</td>
				<td>저자</td>
				<td>출판사</td>
				<td>한문장</td>
				<td>페이지</td>
			</tr>
			<tr>
				<td>유다혜</td>
				<td>에어프라이어 만능 레시피북</td>
				<td>김영희</td>
				<td>한빛출판사</td>
				<td>어쩌구저쩌구</td>
				<td>128p</td>
			</tr>
		</table>
	</div>
	</div>
	</div>
</body>
</html>