# FetchUserApp

This project is a React application built as a hands-on lab exercise to demonstrate the consumption of REST APIs within class-based components.

## Objectives

* Learn to construct a React application that invokes a REST API.
* Fetch and display live data from an external source.

## Features

* **API Integration**: Uses the `[https://api.randomuser.me/](https://api.randomuser.me/)` endpoint to retrieve user information.
* **Asynchronous Data Fetching**: Implements `componentDidMount()` to handle asynchronous network requests and state updates.
* **Dynamic Rendering**: Displays the user's title, first name, and profile image upon successful data retrieval.

## Tech Stack

* **Framework**: React
* **Language**: JavaScript
* **Tools**: Node.js, NPM, Visual Studio Code

## Project Structure

* `src/Getuser.js`: The core class component containing the API logic and render method.
* `src/App.js`: The main application entry point that mounts the `Getuser` component.

## How to Run

1. Navigate to the `fetchuserapp` directory.
2. Run `npm install` to install necessary dependencies.
3. Run `npm start` to launch the development server and view the output in your browser.