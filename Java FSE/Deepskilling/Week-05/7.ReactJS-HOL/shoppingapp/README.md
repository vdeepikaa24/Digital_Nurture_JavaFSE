# Shopping App (React)

A simple React shopping app that displays a list of ordered items and their prices in a table.

## Features
- Shows a predefined catalog of items (hardcoded in the app).
- Renders the items as a table (Name + Price).

## Project Setup
This project was bootstrapped with **Create React App**.

### Install dependencies
```bash
npm install
```

### Run the app (development)
```bash
npm start
```
Open your browser at: http://localhost:3000

## How it Works
- **`src/App.js`**: Root component that renders the shopping page.
- **`src/Component/OnlineShopping.js`**: Contains the hardcoded `CartInfo` array (Laptop, TV, Washing Machine, Mobile, Fridge) and passes it to the cart.
- **`src/Component/Cart.js`**: Receives the `item` prop and displays it in a table.

## Commands
- Build for production:
```bash
npm run build
```
- Run tests:
```bash
npm test
```

## Notes
- The shopping items are currently **hardcoded** inside `OnlineShopping.js`. If you want to load items dynamically (API / JSON file), that would be the next enhancement.

