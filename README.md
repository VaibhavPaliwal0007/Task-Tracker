# Task Management Application

This is a Task Management Application built using Spring Boot for the backend and Next.js for the frontend. It allows users to manage their tasks, including creating, updating, deleting, and marking tasks as completed.

## Features

- **User Authentication**: Users can register, login, and logout securely.
- **Task Management**: Users can create, update, delete, and mark tasks as completed.
- **RESTful API**: The backend provides RESTful API endpoints for CRUD operations on tasks.
- **Pagination**: Task retrieval is optimized with pagination to enhance performance.
- **Validation**: Validation mechanisms are implemented to ensure data integrity.
- **Error Handling**: Clear and informative error messages are provided for better user experience.
- **Database Integration**: PostgreSQL is used to store task information securely.
- **Logging**: Comprehensive logging system tracks critical events and errors.
- **Authentication**: User authentication is implemented using Spring Security and JWT (JSON Web Tokens) for secure access to the application.
- **Global Exception Handling**: Comprehensive global exception handling is implemented to provide consistent error responses across the application.
- **Tailwind CSS Styling**: The frontend is styled using Tailwind CSS responsive user interface.
- **React Hooks**: React Hooks are utilized to handle state and lifecycle management in the frontend for cleaner and more concise code.

## Routes

- `/login`: User login endpoint.
- `/register`: User registration endpoint.
- `/logout`: User logout endpoint.
- `/create-task`: Endpoint to create a new task.
- `/update-task`: Endpoint to update an existing task.
- `/delete-task`: Endpoint to delete a task.
- `/get-tasks`: Endpoint to retrieve tasks.
- `/get-tasks/:id`: Endpoint to retrieve a specific task by ID.

## Technologies Used

- **Backend**:
  - Java
  - Spring Boot
  - PostgreSQL
  - WebSocket

- **Frontend**:
  - Next.js
  - React.js
  - HTML
  - CSS
  - JavaScript

## How to Run Locally

1. Clone this repository.
2. Navigate to the backend folder and run `./mvnw spring-boot:run` to start the backend server or either open the task-tracker-backend in IntelliJ and run the project. 
3. Navigate to the frontend folder and run `npm install && npm start` to start the frontend server.
4. Access the application in your browser at `http://localhost:3000`.
