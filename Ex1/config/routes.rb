Rails.application.routes.draw do
  get 'locations/search'
  get 'locations/direction'
  root 'locations#search'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
