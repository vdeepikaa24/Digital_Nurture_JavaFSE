import React from 'react';
import officeImage from './office.jpg'; 

function App() {
  const element = "Office Space";
  const ItemName = { 
    Name: "DBS", 
    Rent: 50000, 
    Address: 'Chennai' 
  };
  
  // Logic to determine color: Red if <= 60000, otherwise Green
  const rentColor = ItemName.Rent <= 60000 ? 'red' : 'green';

  return (
    <div>
      <h1>{element} , at Affordable Range</h1>
      <img src={officeImage} width="25%" height="25%" alt="Office Space" />
      <h1>Name: {ItemName.Name}</h1>
      <h3 style={{ color: rentColor }}>Rent: Rs. {ItemName.Rent}</h3>
      <h3>Address: {ItemName.Address}</h3>
    </div>
  );
}

export default App;