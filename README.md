# Syslibrary
This repository contains the source code for a RESTful API designed for efficient library management. The API allows for CRUD operations on books, users, loans, and reservations.

# Overview
The Library Management RESTful API is developed to streamline library operations, catering to both public and private libraries, educational institutions, and personal collections. It provides a straightforward communication interface, enabling users to manage library resources seamlessly.

# Features
Book Management: Add, update, delete, and query books in the library database.

User Control: Register, update, and remove users from the system.

Loan and Reservation Management: Facilitate loan and reservation processes, ensuring efficient resource allocation.

Advanced Search: Allow users to search for books based on various criteria like title, author, or ISBN.

Reporting: Generate reports on loans, reservations, and user activities.

Technologies Used

Programming language: Java 17

Framework: SpringBoot

Database: MySql

## Installation

To use the Library Management API, start by setting the base URL in your client application. The base URL is the root address of our API service, through which all API requests are made.

Base URL: [https://localhost/](http://localhost/)

Ensure your application is configured to send requests to this base URL for all API interactions.

## Usage
Here are some common endpoints provided by the Library Management RESTful API, showcasing how to interact with various resources like books, users, and loans.


List all books: GET /books

Add a new book: POST /books
```JSON
{
  "title": "Book Title",
  "author": "Author Name",
  "isbn": "ISBN-Number"
  ...
}
```
Get a book by ID: GET /books/{id}

Register a new user: POST /users
```JSON
{
  "name": "User Name",
  "email": "user@example.com"
  ...
}
```
List all users: GET /users

Create a loan: POST /loans

```JSON 
{
  "bookId": "BookId",
  "userId": "UserId",
  "dueDate": "YYYY-MM-DD"
  ...
}
```
List all loans: GET /loans

For a complete list of endpoints and detailed usage instructions, please refer to the API documentation.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
