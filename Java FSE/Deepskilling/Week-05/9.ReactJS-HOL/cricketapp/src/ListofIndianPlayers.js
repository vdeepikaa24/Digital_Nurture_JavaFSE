import React from 'react';

const ListofIndianPlayers = ({ IndianPlayers }) => (
    <ul>
        {IndianPlayers.map((player) => (
            <li>Mr. {player}</li>
        ))}
    </ul>
);
export default ListofIndianPlayers;