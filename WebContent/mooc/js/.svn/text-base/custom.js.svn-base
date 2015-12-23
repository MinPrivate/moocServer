		$(function () {
			$('.counter').countdown({until: new Date(2013, 10 - 1, 11)}); 
			});
	

		$(function(){
			// Set starting slide to 1
			var startSlide = 1;
			// Get slide number if it exists
			if (window.location.hash) {
				startSlide = window.location.hash.replace('#','');
			}
			// Initialize Slides
			$('#slides').slides({
				preload: true,
				preloadImage: 'img/loading.gif',
				generatePagination: false,
				play: 500000,
				pause: 2500,
				hoverPause: true,
				// Get the starting slide
				start: startSlide,
				animationComplete: function(current){
					// Set the slide number as a hash
					window.location.hash = '#' + current;
				}
			});
		});
        
		
		$(document).ready(function() {
		
		$('.scroll-pane').jScrollPane({
             
			 autoReinitialise: true
		});
        
		});