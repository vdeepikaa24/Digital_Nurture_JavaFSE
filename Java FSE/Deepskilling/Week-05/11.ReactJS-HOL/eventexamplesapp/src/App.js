import React, { useState } from 'react';

function App() {
  // State for Counter
  const [count, setCount] = useState(0);
  
  // State for Currency Converter
  const [amount, setAmount] = useState('');

  // 1. Counter Logic
  const handleIncrement = () => {
    setCount(count + 1);
    alert("Hello! Value was incremented.");
  };

  const handleDecrement = () => {
    setCount(count - 1);
  };

  // 2. Say Welcome Logic
  const sayWelcome = (message) => {
    alert(message);
  };

  // 3. Synthetic Event Logic
  const handleOnPress = (e) => {
    alert("I was clicked");
  };

  // 4. Currency Converter Logic (Euro to Rupees conversion)
  const handleSubmit = (e) => {
    e.preventDefault();
    // Assuming 1 Euro = 90 Rupees for this calculation
    const exchangeRate = 90;
    const result = amount * exchangeRate;
    alert(`Converting to: Euro Amount is ${result}`);
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>{count}</h1>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={handleDecrement}>Decrement</button>
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
      <button onClick={handleOnPress}>Click on me</button>

      <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
      <form onSubmit={handleSubmit}>
        <label>Amount: </label>
        <input 
          type="number" 
          value={amount} 
          onChange={(e) => setAmount(e.target.value)} 
        /><br />
        <label>Currency: Euro</label><br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;