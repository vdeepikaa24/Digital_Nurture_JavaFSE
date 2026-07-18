# Employee Management App (React Context API Lab)

## Objectives
- Explain the need and benefits of **React Context API**
- Work with **`createContext()`**
- List the types of **Router components**

## Overview
In the existing app, the theme (`light` / `dark`) was being passed down through multiple component levels using **props**. This is called **prop drilling** and becomes harder to maintain as the component tree grows.

This lab converts the theme passing approach to **React Context API** so that nested components (like `EmployeeCard`) can read the theme directly.

---

## Why React Context API? (Need & Benefits)
### Need
- Avoid passing the same value through many layers of components.
- Reduce tight coupling between parent and deeply nested children.

### Benefits
- **Eliminates prop drilling**: no need to pass `theme` through every intermediate component.
- **Centralized state/value**: the theme is provided once and consumed anywhere.
- **Cleaner component APIs**: child components focus on their own data/behavior.
- **Easier scalability**: when more components need the theme, they can consume the same context.

---

## Working with `createContext()`
The theme context is defined in:

- `src/ThemeContext.js`

Key idea:
- `createContext('light')` sets a default value for cases where no provider is found.
- Components can consume the context using `useContext(ThemeContext)`.

---

## Implementation Summary (What was changed)
### 1) Create context
- `src/ThemeContext.js`
  - Uses `createContext('light')`

### 2) Provide the context in `App.js`
- `src/App.js`
  - Wraps the app with `<ThemeContext.Provider value={theme}> ... </ThemeContext.Provider>`
  - Theme value comes from component state.
  - The `theme` is **no longer passed** as props to `EmployeesList`.

### 3) Consume context in `EmployeeCard.js`
- `src/EmployeeCard.js`
  - Imports `ThemeContext`
  - Uses `const theme = useContext(ThemeContext)`
  - Applies the theme to button `className`.

### 4) Remove theme prop passing from `EmployeesList.js`
- `src/EmployeesList.js`
  - Removed `theme={props.theme}` from `EmployeeCard` usage.

---

## List of Router Component Types
Common router component types (React Router):
- **BrowserRouter**: uses HTML5 history API (typical for web apps)
- **HashRouter**: uses hash portion of URL (useful for static hosts)

- **Routes**: container for route definitions
- **Route**: maps a path to a UI element

- **Link**: navigational link that doesn’t reload the page
- **NavLink**: like Link but can apply active styles

- **Outlet**: renders child routes in nested routing
- **Navigate**: redirects programmatically
- **useNavigate** / **useLocation** (hooks often used for routing logic)

---

## Lab Result / Status
✅ Theme was migrated from prop drilling to **React Context API**.

- `ThemeContext.js` created with default value `light`
- `App.js` provides the theme via `ThemeContext.Provider`
- `EmployeeCard.js` consumes theme using `useContext()`
- `EmployeesList.js` no longer passes theme as props

---

## How to Run
From the `employeesapp` directory:
1. `npm install`
2. `npm start`

Then open the app in your browser and switch between **Light/Dark**.

