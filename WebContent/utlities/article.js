
function toggle(id) { 
    
    var myComment = document.getElementById(id);
    var displaySetting = myComment.style.display;
    var commentButton = document.getElementById('commentButton');
  
    if (displaySetting == 'block') {
    	myComment.style.display = 'none';
        commentButton.innerHTML = 'Show Box';
       
    }
    else { 
    	myComment.style.display = 'block';
        commentButton.innerHTML = 'Hide Box';
       
    }
  }