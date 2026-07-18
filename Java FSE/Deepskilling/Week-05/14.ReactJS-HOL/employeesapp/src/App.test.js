import { render, screen } from '@testing-library/react';
import App from './App';

test('renders theme selector and employees list', () => {
  render(<App />);

  // Theme selector
  expect(screen.getByText(/select a theme/i)).toBeInTheDocument();

  // Employees list heading
  expect(screen.getByRole('heading', { name: /employees list/i })).toBeInTheDocument();
});

