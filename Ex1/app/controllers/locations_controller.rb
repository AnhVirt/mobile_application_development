class LocationsController < ApplicationController
	PI = 3.14
	R = 6371
  def search
  end

  def direction
  	if params[:long_a].present? && params[:long_b].present? && params[:lat_a].present? && params[:lat_b].present? 
			long_a = params[:long_a].to_f
			lat_a = params[:lat_a].to_f
			long_b = params[:long_b].to_f
			lat_b = params[:lat_b].to_f
  		lat = (lat_a - lat_b)*PI/180.abs
	  	long = (long_a - long_b)*PI/180.abs
	  	la1_to_rad = lat_a*PI/180
	  	la2_to_rad = lat_b*PI/180
	  	a = Math.sin(lat/2)*Math.sin(lat/2) + Math.cos(la1_to_rad)*Math.cos(la2_to_rad)*Math.sin(lat/2)*Math.sin(long/2)
	  	a = a.abs
	  	b = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a))
	  	@d = R*b
	  	
		else
			@status  = "Wrong params"
			
		end
  	
  end
end
