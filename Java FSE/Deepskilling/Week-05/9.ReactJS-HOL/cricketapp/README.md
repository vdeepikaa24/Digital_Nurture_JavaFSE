# Cricket App (React)

This is a small React (Create React App) project that renders lists of cricket players and demonstrates simple prop passing and array handling.

## Features

- **Player List**: Shows all players from the `players` array.
- **Scores Below / At 70**: Filters and displays players with `score <= 70`.
- **Odd/Even Indian Team Players**: Uses destructuring to display players at odd and even indices from `IndianTeam`.
- **Merged Indian Players**: Displays the `IndianPlayers` array.

## How it works

- Data is defined in `src/Players.js`:
  - `players` (array of `{ name, score }`)
  - `IndianTeam` (array of player names)
  - `IndianPlayers` (merged array from two internal lists)
- UI components are in `src/`:
  - `ListofPlayers.js`
  - `Scorebelow70.js`
  - `OddEvenPlayers.js`
  - `ListofIndianPlayers.js`
- `src/App.js` controls which sections show based on the `flag` variable.
  - If `flag === true`, it shows the **List of Players** and **Scores <= 70**.
  - Otherwise, it shows **Odd Players**, **Even Players**, and **List of Indian Players Merged**.

## Run the project

From the `cricketapp` folder:

```bash
npm install
npm start
```

Open:
- http://localhost:3000

## Project Scripts

- `npm start` — run in development mode
- `npm test` — run tests
- `npm run build` — create production build

