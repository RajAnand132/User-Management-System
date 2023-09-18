
# User Management System

This is a simple User Management System built using Java and Spring Boot. It provides basic functionality for managing user information, including adding, retrieving, updating, and deleting user records.

## Run Locally

Clone the project

```bash
  git clone https://github.com/yourusername/user-management-system.git
```

Go to the project directory

```bash
  cd user-management-system
```

Install dependencies

```bash
  mvn clean install
```
Run the Spring Boot application

```bash
  mvn spring-boot:run
```

Start the server

```bash
  http://localhost:8080
```


## Tech Stack

**Languages & FrameWorks :** Java, SpringBoot

**Data Strucure :** ArrayList

**Tools Used :** IntelliJ, PostMan


## Documentation Dataflow

In your User Management System project, the data flows between different components as follows:

1. **Client Request**:
   - Data flow typically begins when a client (e.g., a web browser or mobile app) sends an HTTP request to your Spring Boot application. These requests can be for various operations like adding, retrieving, updating, or deleting user data.

2. **Controller Layer**:
   - The Spring Boot application's controller layer receives the incoming HTTP request. In your case, the `UserController` class handles these requests.
   - The controller extracts data from the request, which can be in the form of JSON or URL parameters.

3. **Data Access Layer**:
   - The data access layer typically interacts with a database to perform CRUD (Create, Read, Update, Delete) operations on user data. In your project, you're using a `List<User>` as an in-memory data store instead of a database.
   - When adding a user, the user object is added to the list.
   - When retrieving a user or all users, the controller fetches data from the list.
   - When updating a user, the controller finds the user in the list and updates their information.
   - When deleting a user, the controller removes the user from the list.


4. **Response**:
   - After processing the request, the controller returns an HTTP response to the client. This response can include data (e.g., user information, success messages) and an HTTP status code (e.g., 200 for success, 404 for not found, 500 for server error).

Overall, data flows from the client through the controller to the data access layer (in-memory list in your case) for CRUD operations, and then back to the client as an HTTP response.
## API Reference

#### Add a User

```http
  POST localhost:8080/api/users/addUser
```
| Parameter | Request Type     | Description                |
| :-------- | :------- | :------------------------- |
| `JSON` | `Request Body` | **Required**. User object with user details |

### Example
#### Request Body:
```
{
  "userId": 1,
  "name": "John Doe",
  "userName": "johndoe",
  "address": "123 Main St",
  "phoneNumber": "555-1234"
}
```
#### Response:
Username : johndoe added into User Repository !!!!!!!!!!!!

#### Add multiple Users

```http
  POST localhost:8080/api/users/addMultipleUsers
```

| Parameter | Request Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Array of JSON objects` | `Request Body` | **Required**. User objects with user details |

### Example
#### Request Body:
```
[
  {
  "userId": 1,
  "name": "John Doe",
  "userName": "johndoe",
  "address": "123 Main St",
  "phoneNumber": "555-1234"
  },
  {
  "userId": 2,
  "name": "John Haw",
  "userName": "johnhow",
  "address": "1257 Main St",
  "phoneNumber": "5755-12394"
  }
]
```
#### Response:
2 new users added into User Repository !!!!!!!!!!!!

#### Get User

```http
  GET localhost:8080/api/users/getUser/{userId}

```

| Parameter | Request Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `Path parameter` | **Required**.  userId of the user to fetch |

### Example
#### Response
```
{
  "userId": 1,
  "name": "John Doe",
  "userName": "johndoe",
  "address": "123 Main St",
  "phoneNumber": "555-1234"
}
```

#### Get All Users

```http
  GET localhost:8080/api/users/getAllUsers

```

| Parameter | Request Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `N/A`      | `N/A` | **Required**. Nothing |

### Example
#### Response
```
[
  {
  "userId": 1,
  "name": "John Doe",
  "userName": "johndoe",
  "address": "123 Main St",
  "phoneNumber": "555-1234"
  },
  {
  "userId": 2,
  "name": "John Haw",
  "userName": "johnhow",
  "address": "1257 Main St",
  "phoneNumber": "5755-12394"
  }
]
```
#### Update User

```http
  PUT localhost:8080/api/users/updateUserInfo/{userId}
```

| Parameter | Request Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `userId`      | `Path parameter` | **Required**.  userId of the user to Update |
| `JSON`      | `Request Body` | **Required**.  Body of the user to Update |

### Example
#### Request
```
{
  "userId": 11,
  "name": "John Doe K",
  "userName": "johndoe34",
  "address": "1234 Main St AU",
  "phoneNumber": "565-1234"
}
```
#### Response
User information updated successfully

#### Delete a User

```http
  DELETE localhost:8080/api/users/deleteUser/{userId}

```
| Parameter | Request Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `Path parameter` | **Required**. userId of the user to delete User |

### Example
#### Response:
User deleted successfully

## Support

For support, email abc@gmail.com or join our Slack channel.


## Acknowledgements

- [Awesome Readme Templates](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
- [Awesome README](https://github.com/matiassingers/awesome-readme)
- [How to write a Good readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)

