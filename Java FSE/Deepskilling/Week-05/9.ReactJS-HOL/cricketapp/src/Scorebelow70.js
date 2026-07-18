import React from 'react';

const Scorebelow70 = ({ players }) => {
    let players70 = [];
    
    // Changed .map() to .forEach()
    players.forEach((item) => {
        if (item.score <= 70) {
            players70.push(item);
        }
    });

    return (
        <ul>
            {players70.map((item) => (
                <li key={item.name}>Mr. {item.name} {item.score}</li>
            ))}
        </ul>
    );
};

export default Scorebelow70;