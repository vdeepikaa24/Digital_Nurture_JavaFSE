# TrainersApp (React + React Router)

## What this app does
This single-page application (SPA) maintains a list of Cognizant Academy trainers and their expertise.

### Pages / URLs
- **`/`** → Redirects to **Home**
- **`/trainers`** → Shows the **Trainers List** (clickable trainer names)
- **`/trainer/:id`** → Shows **Trainer Details** for the trainer whose `trainerId` matches `id`

---

## Why React Router? (Need & Benefits)
React apps often become SPAs (Single Page Applications). In SPAs:
- The UI changes without full page refresh.
- Navigation should update the visible component while keeping the app state.

**React Router** provides:
1. **Client-side routing**: map URLs to components.
2. **Declarative navigation**: use components like `<Link />` instead of manual page reloads.
3. **Route parameters**: read URL parameters (e.g., `:id`) using hooks like `useParams()`.
4. **Composability**: nest routes and build structured navigation UIs.

---

## Key React Router Components used in this lab
- **`BrowserRouter`**: Router implementation that uses the browser history API.
- **`Routes`**: Container that holds route definitions.
- **`Route`**: Declares a path and the component to render.
- **`Link`**: Creates navigation links without reloading the page.
- **`useParams`**: Hook to read route parameters (e.g., `{ id }` from `/trainer/:id`).

---

## Types of Router Components (conceptual)
In React Router (v6), the “components” used for routing generally fall into:
1. **Router Provider**
   - `BrowserRouter`, `HashRouter` (provider components that enable routing)
2. **Route Matching / Rendering**
   - `Routes`, `Route`
3. **Navigation / Linking**
   - `Link` (and `NavLink`)
4. **Data access from the URL**
   - `useParams`, `useNavigate`, `useLocation`

---

## Parameter passing via URL (lab requirement)
### How it works here
1. **TrainersList** renders trainer names as links:
   - `to={`/trainer/${t.trainerId}`}`
2. **TrainerDetail** reads the parameter using:
   - `const { id } = useParams();`
3. The trainer data is found by matching:
   - `trainersMock.find((t) => t.trainerId === id)`

So the URL `/trainer/t-syed8` maps to the trainer with `trainerId = "t-syed8"`.

---

## Project structure (important files)
- `src/App.js`
  - Sets up `BrowserRouter`, `Routes`, and `Route` definitions
- `src/Home.js`
  - Home page content
- `src/TrainersList.js`
  - Renders list of trainers and links to trainer details
- `src/TrainerDetail.js`
  - Uses `useParams` to fetch trainer details by `id`
- `src/TrainersMock.js`
  - Mock trainer data
- `src/Trainer.js`
  - `Trainer` class model

---

## Setup and Run
### Prerequisites
- Node.js
- NPM
- Visual Studio Code

### Install dependencies
```bash
cd trainersapp
npm install
```

### Start the development server
```bash
npm start
```
Then open:
- **http://localhost:3000**

---

## Notes
- This project uses **React Router DOM v6+** (`react-router-dom` package).
- Navigation is performed via `<Link />`, so transitions happen without full page reloads.

