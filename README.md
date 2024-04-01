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

### - Author

GET /api/authors - public List<Author> getAllAuthors()

GET /api/authors/{id} - public Author getAuthorById(@PathVariable UUID id)

POST /api/authors - public Author createAuthor(@RequestBody Author author)
```JSON
{
    "fullName":"Author Full Name"
}
```
PUT /api/authors/{id} - public Author updateAuthor(@PathVariable UUID id, @RequestBody Author authorDetails)
```JSON
{
    "fullName":"Author Full Name"
}
```
DELETE /api/authors/{id} - public ResponseEntity<?> deleteAuthor(@PathVariable UUID id)

### - Category
GET /api/categories - public List<Category> getAllCategories()

GET /api/categories/{id} - public Category getCategoryById(@PathVariable UUID id)

POST /api/categories - public Category createCategory(@RequestBody Category category)
```JSON
{
    "name":  "Category Name"
}
```
PUT /api/categories/{id} - public Category updateCategory(@PathVariable UUID id, @RequestBody Category categoryDetails)
```JSON
{
    "name":  "Category Name"
}
```
DELETE /api/categories/{id} - public ResponseEntity<?> deleteCategory(@PathVariable UUID id)

### - Publisher
GET /api/publishers - public List<Publisher> getAllPublishers()

GET /api/publishers/{id} - public Publisher getPublisherById(@PathVariable UUID id)

POST /api/publishers - public Publisher createPublisher(@RequestBody Publisher publisher)
```JSON
{
    "name": "Martin Claret"
}
```
PUT /api/publishers/{id} - public Publisher updatePublisher(@PathVariable UUID id, @RequestBody Publisher publisherDetails)
```JSON
{
    "name": "Martin Claret"
}
```
DELETE /api/publishers/{id} - public ResponseEntity<?> deletePublisher(@PathVariable UUID id)

### - Language
GET /api/languages - public List<Language> getAllLanguages()

GET /api/languages/{id} - public Language getLanguageById(@PathVariable UUID id)

POST /api/languages - public Language createLanguage
(@RequestBody Language language)
```JSON
{
    "name": "language name"
}
```
PUT /api/languages/{id} - public Language updateLanguage(@PathVariable UUID id, @RequestBody Language languageDetails)
```JSON
{
    "name": "language name"
}
```
DELETE /api/languages/{id} - public ResponseEntity<?> deleteLanguage(@PathVariable UUID id)

### - Book
GET /api/books - public List<Book> getAllBooks()

GET /api/books/{id} - public Book getBookById(@PathVariable UUID id)

POST /api/books - public Book createBook(@RequestBody Book book)
```Json
    {
      "title": "Title this Book",
      "author": {
        "idAuthor": "idAuthor"
      },
      "category": {
        "idCategory": "idCategory"
      },
      "language": {
        "idLanguage": "idLanguage"
      },
      "publisher": {
        "idPublisher": "idPublisher"
      },
      "publicationYear": ano,
      "numberOfPages": 0, //Only integers
      "summary": "summary",
      "isbn": "isbn number",
      "copy": 1, //Number of Copies
    }
```
PUT /api/books/{id} - public Book updateBook(@PathVariable UUID id, @RequestBody Book bookDetails)

```Json
    {
      "title": "Title this Book",
      "author": {
        "idAuthor": "idAuthor"
      },
      "category": {
        "idCategory": "idCategory"
      },
      "language": {
        "idLanguage": "idLanguage"
      },
      "publisher": {
        "idPublisher": "idPublisher"
      },
      "publicationYear": ano,
      "numberOfPages": 0, //Only integers
      "summary": "summary",
      "isbn": "isbn number",
      "copy": 1, //Number of Copies
    }
```
### - User
GET /api/users - public List<User> getAllUsers()

GET /api/users/{id} - public User getUserById(@PathVariable UUID id)

POST /api/users - public User createUser(@RequestBody User user)

PUT /api/users/{id} - public User updateUser(@PathVariable UUID id, @RequestBody User userDetails)

DELETE /api/users/{id} - public ResponseEntity<?> deleteUser(@PathVariable UUID id)

### -Reservation
GET /api/reservations - public List<Reservation> getAllReservations()

GET /api/reservations/{id} - public Reservation getReservationById(@PathVariable UUID id)

POST /api/reservations - public Reservation createReservation(@RequestBody Reservation reservation)

PUT /api/reservations/{id} - public Reservation updateReservation(@PathVariable UUID id, @RequestBody Reservation reservationDetails)

DELETE /api/reservations/{id} - public ResponseEntity<?> deleteReservation(@PathVariable UUID id)


### - Loan
GET /api/loans - public List<Loan> getAllLoans()

GET /api/loans/{id} - public Loan getLoanById(@PathVariable UUID id)

POST /api/loans - public Loan createLoan(@RequestBody Loan loan)
PUT /api/loans/{id} - public Loan updateLoan(@PathVariable UUID id, @RequestBody Loan loanDetails)

DELETE /api/loans/{id} - public ResponseEntity<?> deleteLoan(@PathVariable UUID id)

### - LoanHistory
GET /api/loanHistories - public List<LoanHistory> getAllLoanHistories()

GET /api/loanHistories/{id} - public LoanHistory getLoanHistoryById(@PathVariable UUID id)

POST /api/loanHistories - public LoanHistory createLoanHistory(@RequestBody LoanHistory loanHistory)

PUT /api/loanHistories/{id} - public LoanHistory updateLoanHistory(@PathVariable UUID id, @RequestBody LoanHistory loanHistoryDetails)

DELETE /api/loanHistories/{id} - public ResponseEntity<?> deleteLoanHistory(@PathVariable UUID id)

Here are some common endpoints provided by the Library Management RESTful API, showcasing how to interact with various resources like books, users, and loans.

For a complete list of endpoints and detailed usage instructions, please refer to the API documentation.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
