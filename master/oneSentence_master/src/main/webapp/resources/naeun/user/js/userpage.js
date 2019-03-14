
//var flag1=false;
//1. 팔로잉이 되어있는지 안되어있는지에 따라 버튼 색/내용 달라짐
if($('#follow').value=='팔로잉'){
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


//2.login id랑 userpage의 user가 같으면(=자신의 유저페이지 들어갔을때) 팔로우x/수정o,
//  login id랑 userpage의 user가 다르면(=타인의 유저페이지 들어갔을때) 팔로우o/수정x
var flag2=false;
if(flag2){
	$('#follow').hide();
	$('#update').show();
}else{
	$('#update').hide();
	$('#follow').show();
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
