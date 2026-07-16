# Cohort Tracker (React)

A small React app that displays a list of training cohorts and their details.

## Features

- Renders all cohorts from a shared data source (`CohortsData`).
- Shows each cohort in a styled card.
- Highlights the cohort header color based on status:
  - **Green** when `currentStatus === "Ongoing"`
  - **Blue** otherwise

## Tech Stack

- React (Create React App)
- CSS Modules (for `CohortDetails.module.css`)

## Project Structure

- `src/App.js`
  - Maps through `CohortsData` and renders `CohortDetails` for each cohort.
- `src/Cohort.js`
  - Defines the `Cohort` class and exports the sample `CohortsData` array.
- `src/CohortDetails.js`
  - Presentational component that displays cohort info.
  - Applies conditional inline styles for the header based on `currentStatus`.
- `src/CohortDetails.module.css`
  - Styles the cohort card layout (width, border, spacing, etc.).

## Getting Started

### Prerequisites

- Node.js and npm

### Install dependencies

```bash
npm install
```

### Run the app (development)

```bash
npm start
```

Open [http://localhost:3000](http://localhost:3000).

## Tests

```bash
npm test
```

## Build (production)

```bash
npm run build
```

The production build is generated in the `build/` folder.

