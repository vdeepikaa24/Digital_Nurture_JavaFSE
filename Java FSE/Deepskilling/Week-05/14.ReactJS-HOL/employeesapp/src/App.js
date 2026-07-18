import './App.css';
import { EmployeesData } from './Employee';
import EmployeesList from './EmployeesList';
import { useState } from 'react';
import ThemeContext from './ThemeContext'; // 1. Import the context

function App() {
  const Employees = EmployeesData;
  const [theme, setTheme] = useState('light');

  return (
    // 2. Wrap the application with the Provider and pass the theme state
    <ThemeContext.Provider value={theme}>
      <div>
        <label>SELECT A THEME </label>
        <select onChange={(e) => setTheme(e.target.value)}>
          <option value='light'>Light</option>
          <option value='dark'>Dark</option>
        </select>
      </div>
      {/* 3. Theme is no longer passed as a prop here */}
      <EmployeesList employees={Employees} />
    </ThemeContext.Provider>
  );
}

export default App;