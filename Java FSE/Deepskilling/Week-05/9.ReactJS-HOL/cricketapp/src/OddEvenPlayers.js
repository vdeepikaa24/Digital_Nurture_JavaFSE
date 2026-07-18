import React from 'react';

export const OddPlayers = ({ IndianTeam: [first, , third, , fifth] }) => (
    <ul>
        <li>First : {first}</li>
        <li>Third : {third}</li>
        <li>Fifth : {fifth}</li>
    </ul>
);

export const EvenPlayers = ({ IndianTeam: [, second, , fourth, , sixth] }) => (
    <ul>
        <li>Second : {second}</li>
        <li>Fourth : {fourth}</li>
        <li>Sixth : {sixth}</li>
    </ul>
);