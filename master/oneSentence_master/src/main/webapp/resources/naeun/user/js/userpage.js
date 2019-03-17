// 1. 로그인 안했을 경우
if($('#loginIdx').val()=="로그인필요"){
	$('#follow').hide();
	$('#update').hide();
	$('.fa-cog').hide();
} else{ // 2. 로그인 했을 경우
	
	// 2-1.login id랑 userpage의 user가 같으면(=자신의 유저페이지 들어갔을때=flag:true) 팔로우x/수정o/설정o
	if($('#flag').val()=="same"){
		$('#follow').hide();
		$('#update').show();
		$('.fa-cog').show();
	} else{ // 2-2.login id랑 userpage의 user가 다르면(=타인의 유저페이지 들어갔을때=flag:false) 팔로우o/수정x/설정x
		
		// 2-2 (1). 이미 팔로잉 되어있는 경우
		if($('#follow').val()=='팔로잉'){
			$('#follow').css({'backgroundColor' : 'white',
							  'color' : 'black',
	        			  	  'border' : '1px solid silver'
	        			  	});
		} else{ // 2-2 (2). 아직 팔로잉 되어있지 않은 경우
			$('#follow').css({'backgroundColor' : 'crimson',
	        			  	  'color' : 'white',
	        			  	  'border' : '1px solid crimson'
	        				});
			}
			
		$('#follow').show();
		$('#update').hide();
		$('.fa-cog').hide();	
	}
}



$('#follow').click(function(){
	
    if($('#follow').val()=='팔로우'){
    	$('#follow').val('팔로잉');
        $('#follow').css({'backgroundColor' : 'white',
                          'color' : 'black',
                          'border' : '1px solid silver'
                         });
    }else{
    	$('#follow').val('팔로우');
        $('#follow').css({'backgroundColor' : 'crimson',
                          'color' : 'white',
                          'border' : '1px solid crimson'
                         });
    }
	
	
    // ajax로 보낼 데이터 정의
    var userIdx = $('#userIdx').val();
    var loginIdx = $('#loginIdx').val();

    var follow = 0;
    
    if($('#follow').val()=='팔로잉') follow = 1;
	else follow = 2;
	  
    var allData = { "userIdx": userIdx, "loginIdx": loginIdx, "follow":follow };
    
    // FollowingController에 allData를 GET방식으로 보냄
    $.ajax({
        url:'following',
        type:'GET',
        data: allData,
        success:function(data){        	
        	console.log("ajax 성공")      	
        },
        error:function(jqXHR, textStatus, errorThrown){
        	console.log("ajax 실패")
        }
    });
		
});
$('#update').click(function(){
	console.log("수정Click");
	var idx = $('#userIdx').val();
	var url="../profile/popup/"+idx;
	var popupOption="width=700,height=600";
	window.open(url,"user update",popupOption);
});
