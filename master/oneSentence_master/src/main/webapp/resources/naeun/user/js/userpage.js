


//2.login id랑 userpage의 user가 같으면(=자신의 유저페이지 들어갔을때=flag:true) 팔로우x/수정o/설정o,
//login id랑 userpage의 user가 다르면(=타인의 유저페이지 들어갔을때=flag:false) 팔로우o/수정x/설정x

if($('#flag').val()=="same"){
	$('#follow').hide();
	$('#update').show();
	$('.fa-cog').show();
}else{
	//1. 팔로잉이 되어있는지 안되어있는지에 따라 버튼 색/내용 달라짐
	if($('#follow').val()=='팔로잉'){
	    $('#follow').css({'backgroundColor' : 'white',
	        			  'color' : 'black',
	        			  'border' : '1px solid silver'
	        			});
	}else{
	    $('#follow').css({'backgroundColor' : 'crimson',
	        			  'color' : 'white',
	        			  'border' : '1px solid crimson'
	        			});
	    }
		
	
	$('#follow').show();
	$('#update').hide();
	$('.fa-cog').hide();
	

}




$('#follow').click(function(){
    if(this.value=='팔로우'){
        this.value='팔로잉';
        $('#follow').css({'backgroundColor' : 'white',
                          'color' : 'black',
                          'border' : '1px solid silver'
                         });
    }else{
        this.value='팔로우';
        $('#follow').css({'backgroundColor' : 'crimson',
                          'color' : 'white',
                          'border' : '1px solid crimson'
                         });
    }         
});
