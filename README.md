# WebService

This project contains a web service for user registration. It includes a front-end written in React and a back-end written in Spring Boot.

## Installation

1. Clone the project:

```
git clone <project-url>
```

2. Navigate to the project directory:

```
cd <project-directory>
```

3. Start the React application:

```
cd frontend
npm install
npm start
```

4. Start the Spring Boot application:

```
cd ..
mvn spring-boot:run
```

5. Visit `http://localhost:5173` in your browser to view the application.

## Usage

WebService provides a simple interface for user registration. The React application allows users to enter their name, email address, and password. This information is processed and saved via the UserController in the Spring Boot backend.

## Endpoints

### Create User Registration

- **URL:** `/api/v1/users`
- **Method:** POST
- **Description:** Creates a new user registration.
- **Parameters:**
    - `username` (string, required): User's username.
    - `email` (string, required): User's email address.
    - `password` (string, required): User's password.
- **Example Usage:**
  ```http
  POST /api/v1/users HTTP/1.1
  Content-Type: application/json

  {
      "username": "user",
      "email": "user@example.com",
      "password": "password123"
  }
  ```
- **Successful Response:**
  ```json
  {
      "status": "success",
      "data": {
          "id": 1,
          "username": "user",
          "email": "user@example.com"
      }
  }
  ```
- **Error Response:**
  ```json
  {
      "status": "error",
      "message": "Username already taken."
  }
  ```

## License

This project is licensed under the MIT License. For more information, see the [LICENSE](LICENSE) file.
