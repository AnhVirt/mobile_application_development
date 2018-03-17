require 'test_helper'

class LocationsControllerTest < ActionDispatch::IntegrationTest
  test "should get search" do
    get locations_search_url
    assert_response :success
  end

end
