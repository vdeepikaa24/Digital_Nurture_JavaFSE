# Office Space Rental App (React)

A simple React application that displays basic office space rental details.

## What it shows

- Title: **Office Space** (with “Affordable Range”)
- Office image (`src/office.jpg`)
- Office name (static): **DBS**
- Rent (static): **Rs. 50000**
  - Rent text color changes based on rent value:
    - **red** when rent `<= 60000`
    - **green** otherwise
- Address (static): **Chennai**

## Project structure

- `src/App.js` — main UI and the rent-color logic
- `src/office.jpg` — image shown in the app
- `public/` — CRA static assets

## Running the app (optional)

This repository is bootstrapped with Create React App. To run locally:

- `npm install`
- `npm start`

(Commands are not executed in this task.)

