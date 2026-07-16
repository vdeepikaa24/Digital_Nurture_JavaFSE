# Blog App (React)

This is a React app (Create React App) that demonstrates **component life cycle methods** using a class-based component.

## Features
- Fetches blog posts from `https://jsonplaceholder.typicode.com/posts` using the **Fetch API**
- Implements:
  - `constructor()` to initialize component state
  - `loadPosts()` to load data into state
  - `componentDidMount()` to trigger data loading when the component mounts
  - `componentDidCatch()` to display errors using an alert
- Renders a list of posts with:
  - Post title as a heading
  - Post body as a paragraph

## Project Structure
- `src/App.js` – renders the `Posts` component
- `src/Posts.js` – main class component implementing life cycle hooks and rendering posts
- `src/Post.js` – `Post` model class (id, title, body)

## How to Run

### 1) Install dependencies
```bash
npm install
```

### 2) Start the development server
```bash
npm start
```

Then open:
- `http://localhost:3000`

> Note: If port `3000` is already in use, CRA will prompt you to use another port.

## Scripts
- `npm start` – runs the app in development mode
- `npm test` – runs tests
- `npm run build` – creates a production build
- `npm run eject` – ejects CRA configuration (one-way)

## Learning Outcomes (Life Cycle)
- **Mounting**: `componentDidMount()` is called once after the component is inserted into the DOM.
- **Error Handling**: `componentDidCatch()` lets class components act as error boundaries.


