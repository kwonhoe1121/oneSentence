//login id랑 userpage의 user가 같으면(=자신의 유저페이지 들어갔을때) flag=true
var flag=false;
if(flag){
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