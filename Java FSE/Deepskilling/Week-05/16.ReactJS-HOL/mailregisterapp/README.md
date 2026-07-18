# Mail Register App

This project is a React-based registration form application developed to demonstrate component-based architecture, state management, and field-level form validation.

## Features
* **User Input Handling**: Controlled components for Full Name, Email, and Password fields.
* **Real-time Validation**:
    * **Full Name**: Minimum 5 characters.
    * **Email**: Validates against a standard email regex format.
    * **Password**: Minimum 8 characters.
* **Responsive Feedback**: Uses alert messages to notify users of validation errors or successful form submission.
* **Centered Layout**: Modern CSS implementation for a clean, centered user interface.

## Tech Stack
* **Framework**: React
* **Language**: JavaScript
* **Styling**: CSS

## Project Structure
* `src/App.js`: Main application entry point and component container.
* `src/Register.js`: Core component handling form logic, validation, and layout.
* `src/App.css`: Stylesheet for centering and layout presentation.

## How to Run
1. Navigate to the `mailregisterapp` directory.
2. Run `npm install` to install dependencies.
3. Run `npm start` to launch the development server.