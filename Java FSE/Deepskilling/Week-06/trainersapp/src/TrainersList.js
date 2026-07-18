import { Link } from "react-router-dom";
import trainersMock from "./TrainersMock";

export default function TrainersList() {
  return (
    <div>
      <h3>Trainers List</h3>
      <ul>
        {trainersMock.map((t) => (
          <li key={t.trainerId}>
            <Link to={`/trainer/${t.trainerId}`}>{t.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}