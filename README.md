# SpringRestApplication
A Spring boot application that uses REST to get information or update the mocked dataset.

# Getting started
In order to build and run the application the user needs to use the command ./mvnw spring-boot:run
while it is pointing in the base directory of the project.

The list of commands with the mapped URL's is:
  - GET(localhost:8080/movies) retrieves the list of the movies
  - GET(localhost:8080/movies/{id}) retrieves the movie with the specified id
  - POST(localhost:8080/movies/search) retrieves a list of movies that contain the searched text (specified "text" field in the request)
  - POST(localhost:8080/movies) creates a movie with the specified "title" and "content" fields in the request
  - PUT(localhost:8080/movies/{id}) updates the movie with the specified id, with the newly specified "title" and "content" in the request
  - DELETE(localhost:8080/movies/{id}) deletes the movie with the specified id

