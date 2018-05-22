class PessoasController < ApplicationController
	def show
	  	url = 'http://localhost:8091/java-rest-api/rest/pessoas/list'
		@pessoas = HTTParty.get(url)
		JSON.parse(@pessoas.body)
	end
end
