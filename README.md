<h1 align="center">Movie Catalog Api</h3>

---

Simple REST Api that maintains a Movie catalog. 

## 📝 Table of Contents

- [Api Calls](#apiCalls)
- [Getting Started](#getting_started)
- [Deployment](#deployment)
- [Usage](#usage)
- [Built Using](#built_using)
- [TODO](../TODO.md)
- [Contributing](../CONTRIBUTING.md)
- [Authors](#authors)
- [Acknowledgments](#acknowledgement)

## Api Calls <a name = "apiCalls"></a>

### Movie Endpoints
#### GET /movies/all
Fetch all movies present on the system
###### Respone Body example
```
{
  "status": "OK",
  "message": "Success",
  "body": [
    {
      "id": 1,
      "title": "Mummy",
      "overview": "The best movie",
      "duration": 300,
      "rating": 4,
      "movieDirector": {
        "id": 1,
        "name": "Donald",
        "middleName": "Emeka",
        "surname": "Achugo"
      },
      {
      "id": 2,
      "title": "Mask",
      "overview": "The second best movie",
      "duration": 230,
      "rating": 3,
      "movieDirector": {
        "id": 1,
        "name": "Donald",
        "middleName": "Emeka",
        "surname": "Achugo"
      }
    }
  ]
}
```
#### GET /movies?movieId={}
Fetch a movie by *movieId*
###### Respone Body example
```
{
  "id": 2,
  "title": "Mask",
  "overview": "The second best movie",
  "duration": 230,
  "rating": 3,
  "movieDirector": {
    "id": 1,
    "name": "Donald",
    "middleName": "Emeka",
    "surname": "Achugo"
  }
}
```
#### POST /movies
Add a Movie into the catolg
###### Request Body example
```
{
  "title": "Mummy", // Title of the movie
  "overview": "The best movie of the world", // Description of the movie
  "duration": 300, // Duration in minutes of the movie
  "rating": 3, // Rating of the movie from 1 to 5
  "movieDirectorId": 1, // Movie director id. NB: the movie director has been saved before
}
```
###### Response Body example
```
{
  "id": 3,
  "title": "Mummy",
  "overview": "The second best movie",
  "duration": 300,
  "rating": 3,
  "movieDirector": {
    "id": 1,
    "name": "Donald",
    "middleName": "Emeka",
    "surname": "Achugo"
  }
}
```
#### PUT /movies
Update a Movie
###### Request Body example
```
{
  title: "Mummy", // Title of the movie
  overview: "The best movie of the world", // Description of the movie
  duration: 300, // Duration in minutes of the movie
  rating: 3, // Rating of the movie from 1 to 5
  movieDirectorId: 1, // Movie director id. NB: the movie director has been saved before
}
```
###### Response Body example
```
{
  "id": 3,
  "title": "Mummy",
  "overview": "The second best movie",
  "duration": 300,
  "rating": 3,
  "movieDirector": {
    "id": 1,
    "name": "Donald",
    "middleName": "Emeka",
    "surname": "Achugo"
  }
}
```
#### DELETE /movies?movieId={}
Remove a Movie by *movieId* 
#### GET /movies/searchByRating?aboveRating={} 
Fetch movies where the rating is greater than or equals to *aboveReting*
###### Request Body example
```
{
  "status": "OK",
  "message": "Success",
  "body": [
    {
      "id": 1,
      "title": "Mummy",
      "overview": "The best movie",
      "duration": 300,
      "rating": 4,
      "movieDirector": {
        "id": 1,
        "name": "Donald",
        "middleName": "Emeka",
        "surname": "Achugo"
      },
      {
      "id": 2,
      "title": "Mask",
      "overview": "The second best movie",
      "duration": 230,
      "rating": 3,
      "movieDirector": {
        "id": 1,
        "name": "Donald",
        "middleName": "Emeka",
        "surname": "Achugo"
      }
    }
  ]
}
```
#### GET /movies/searchByMovieDirector?movieDirectorId={}
Fetch Movies by *movieDirectorId*
```
{
  "status": "OK",
  "message": "Success",
  "body": [
    {
      "id": 1,
      "title": "Mummy",
      "overview": "The best movie",
      "duration": 300,
      "rating": 4,
      "movieDirector": {
        "id": 1,
        "name": "Donald",
        "middleName": "Emeka",
        "surname": "Achugo"
      },
      {
      "id": 2,
      "title": "Mask",
      "overview": "The second best movie",
      "duration": 230,
      "rating": 3,
      "movieDirector": {
        "id": 1,
        "name": "Donald",
        "middleName": "Emeka",
        "surname": "Achugo"
      }
    }
  ]
}
```
### Movie Director Endpoints
#### GET /movies/directors/all
Fetch all movies directors present on the system
###### Respone Body example
```
{
  "status": "OK",
  "message": "Success",
  "body": [
    {
      "id": 1,
      "name": "Donald",
      "middleName": "Emeka",
      "surname": "Achugo"
    },
    {
      "id": 2,
      "name": "Donald",
      "middleName": null,
      "surname": "Trump"
    }
  ]
}
```
#### GET /movies/directors?movieDirectorId={}
Fetch a movie director by *movieDirectorId*
###### Respone Body example
```
{
  "id": 1,
  "name": "Donald",
  "middleName": "Emeka",
  "surname": "Achugo"
}
```
#### POST /movies/directors
Add a Movie Direcotr into the catolg
###### Request Body example
```
{
  "name": "Donald",
  "middleName": "Emeka",
  "surname": "Achugo"
}
```
###### Response Body example
```
{
  "id": 3,
  "name": "Donald",
  "middleName": "Emeka",
  "surname": "Achugo"
}
```
#### PUT /movies
Update a Movie Director
###### Request Body example
```
{
  "id": 3,
  "name": "Tommy"
}
```
###### Response Body example
```
{
  "id": 3,
  "name": "Tommy",
  "middleName": "Emeka",
  "surname": "Achugo"
}
```
#### DELETE /movies/directors?movieDirectorId={}
Remove a Movie Director by *movieDirectorId*

## 🏁 Getting Started <a name = "getting_started"></a>

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See [deployment](#deployment) for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them.

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running.

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo.

## 🔧 Running the tests <a name = "tests"></a>

Explain how to run the automated tests for this system.

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## 🎈 Usage <a name="usage"></a>

Add notes about how to use the system.

## 🚀 Deployment <a name = "deployment"></a>

Add additional notes about how to deploy this on a live system.

## ⛏️ Built Using <a name = "built_using"></a>

- [MongoDB](https://www.mongodb.com/) - Database
- [Express](https://expressjs.com/) - Server Framework
- [VueJs](https://vuejs.org/) - Web Framework
- [NodeJs](https://nodejs.org/en/) - Server Environment

## ✍️ Authors <a name = "authors"></a>

- [@kylelobo](https://github.com/kylelobo) - Idea & Initial work

See also the list of [contributors](https://github.com/kylelobo/The-Documentation-Compendium/contributors) who participated in this project.

## 🎉 Acknowledgements <a name = "acknowledgement"></a>

- Hat tip to anyone whose code was used
- Inspiration
- References
