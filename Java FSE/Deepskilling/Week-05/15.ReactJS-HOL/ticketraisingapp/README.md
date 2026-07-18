# Ticket Raising App (React)

A simple React application that lets users register a complaint through a form and generates a random **Transaction ID** for each submission.

## Features
- **Complaint registration form** with:
  - Name input (`ename`)
  - Complaint textarea (`complaint`)
- **Random Transaction ID** generated when the `ComplaintRegister` component initializes.
- **Submit behavior**:
  - Validates required fields
  - On submit, shows an `alert()` message containing:
    - The user’s name
    - Confirmation that the complaint was submitted
    - The generated Transaction ID

## Tech Stack
- React (Class Component)
- Create React App (CRA)

## Project Structure
- `src/App.js`  
  Renders the main `ComplaintRegister` component.
- `src/ComplaintRegister.js`  
  Implements the complaint form, state handling, random transaction ID generation, and submit alert.

## Getting Started

### 1) Install dependencies
```bash
npm install
```

### 2) Start the development server
```bash
npm start
```
Open:
- http://localhost:3000

### 3) Run tests (if available)
```bash
npm test
```

### 4) Build for production
```bash
npm run build
```

## Notes
- The app currently displays submission feedback using a browser `alert()` (no backend/API integration).
