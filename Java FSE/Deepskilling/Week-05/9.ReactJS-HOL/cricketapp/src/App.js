import React from 'react';
import { players, IndianTeam, IndianPlayers } from './Players';
import ListofPlayers from './ListofPlayers';
import Scorebelow70 from './Scorebelow70';
import { OddPlayers, EvenPlayers } from './OddEvenPlayers';
import ListofIndianPlayers from './ListofIndianPlayers';

function App() {
    var flag = false; 
    
    if (flag === true) {
        return (
            <div>
                <h1>List of Players</h1>
                <ListofPlayers players={players} />
                <hr />
                <h1>List of Players having Scores Less than 70</h1>
                <Scorebelow70 players={players} />
            </div>
        );
    } else {
        return (
            <div>
                <h1>Odd Players</h1>
                {/* Corrected prop passing for destructuring */}
                <OddPlayers IndianTeam={IndianTeam} />
                <hr />
                <h1>Even Players</h1>
                {/* Corrected prop passing for destructuring */}
                <EvenPlayers IndianTeam={IndianTeam} />
                <hr />
                <h1>List of Indian Players Merged:</h1>
                <ListofIndianPlayers IndianPlayers={IndianPlayers} />
            </div>
        );
    }
}
export default App;