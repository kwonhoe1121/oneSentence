<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script src="http://127.0.0.1:52273/socket.io/socket.io.js"></script>
<script>
	$().ready(
			function() {
					$.ajax({
						url : 'http://127.0.0.1:52273/chatRoom/'+ $('#isbn').val(),
						type : 'GET',
						dataType : 'json',
						contentType : 'application/json; charset=utf-8',
						async : true,
						success : function(data) {
							for (var i = 0; i < data.data.length; i++) {
								let html = '';
								html += '<p><b>' + data.data[i].userName + '</b></p>';
								html += '<p>' + data.data[i].message + '</p>';
								html += '<p style="color=grey;">' + data.data[i].time + '</p>';
								$(html).appendTo('#come');
							}
						},
						error : function(error) {
							console.error();
						}
						});

				var socket = io.connect('http://127.0.0.1:52273');
				//이벤트 연결
				var room = $('#isbn').val();
				socket.emit('join', room);
				socket.on('first', function(data) {
					$('<p><b>' + data.userName + '님이 입장하셨습니다.</b></p>')
							.appendTo('#content2');
					window.scrollTo(0, $(document).height());
				});
				socket.emit('first', {
					isbn : $('#isbn').val(),
					userName : $('#userName').val()
				});
				socket.on('message', function(data) {
					//추가할 문자열 만든다.
					var output = '';
					output += '<li>';
					output += '   <p><b>' + data.userName + '</b></p>';
					output += '   <p>' + data.message + '</p>';
					output += '   <p style="color:grey">' + data.time + '</P>';
					output += '</li>';
					//문서객체를 추가한다.
					$(output).appendTo('#content2');
					window.scrollTo(0, $(document).height());
				});
				//버튼을 클릭할 때(서버의 message이벤트 발생시킴과 동시에 데이터를 전달하도록)
				$('#btn').click(function() {
					let message = $('#message').val().replace(/(^ +|)/g, '');
					if (message == null || message == '') {
						alert('메시지를 입력하세요.')
					} else {
						socket.emit('message', {
							isbn : $('#isbn').val(),
							userName : $('#userName').val(),
							message : $('#message').val(),
							time : new Date().toLocaleString()
						});
						document.getElementById('message').value = '';
					}
				});
			});
</script>
</head>
<body>
	<input id="isbn" value="${isbn}" hidden="true" />
	<input id="userName" value="${userName} " hidden="true" />
	<div data-role="page">
		<div data-role="header" data-position="fixed">
			<h1>${bookTitle}</h1>
		</div>
		<div data-role="content">
			<div data-role="collapsible" id="oldChat">
				<h1 data-icon="arrow-d">이전 대화보기</h1>
				<div id="come"></div>
			</div>
			<ul id="content2" style="list-style: none"></ul>
		</div>
		<div data-role="footer" data-position="fixed">

			<input id="message" /> <a href="#" id="btn" data-role="button"
				data-icon="check" data-line="false" style="width: 100%;">click</a>
		</div>
	</div>
	<script>
		
	</script>
</body>
</html>