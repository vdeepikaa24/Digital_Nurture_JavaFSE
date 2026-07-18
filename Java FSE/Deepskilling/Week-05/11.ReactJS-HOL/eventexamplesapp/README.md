# Event Examples App (React)

A small React (Create React App) project demonstrating basic React concepts using `useState` and event handling.

## What’s included

### 1) Counter
- Shows a numeric counter.
- **Increment** button: increases the counter by 1 and shows an alert: “Hello! Value was incremented.”
- **Decrement** button: decreases the counter by 1.

### 2) Simple event handlers (alerts)
- **Say welcome** button: shows an alert with message `welcome`.
- **Click on me** button: shows an alert: “I was clicked”.

### 3) Currency Converter (Euro → Rupees)
- A form with:
  - **Amount** (number)
  - **Currency** (fixed label: Euro)
- On submit, it converts using the assumption:
  - **1 Euro = 90 Rupees**
- Example: amount `2` ⇒ result `2 * 90 = 180` Rupees.

## Project setup

### Install dependencies
```bash
npm install
```

### Run in development mode
```bash
npm start
```
Open: http://localhost:3000

### Run tests
```bash
npm test
```

### Build for production
```bash
npm run build
```

## Files of interest
- `src/App.js` — contains the counter, buttons (event handlers), and the currency converter form.


