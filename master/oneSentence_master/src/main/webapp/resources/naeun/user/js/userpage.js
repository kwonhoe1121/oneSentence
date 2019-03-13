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