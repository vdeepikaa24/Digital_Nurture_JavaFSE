import React from 'react';

const ListofPlayers = ({ players }) => (
    <ul>
        {players.map((item) => (
            <li>Mr. {item.name} {item.score}</li>
        ))}
    </ul>
);
export default ListofPlayers;