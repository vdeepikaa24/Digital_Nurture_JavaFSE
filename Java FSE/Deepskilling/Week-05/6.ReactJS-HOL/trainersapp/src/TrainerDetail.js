import { useParams } from "react-router-dom";
import trainersMock from "./TrainersMock";

export default function TrainerDetail() {
  const { id } = useParams();
  const trainer = trainersMock.find((t) => t.trainerId === id);

  return (
    <div>
      <h3>Trainers Details</h3>
      <p>{trainer.name} ({trainer.technology})</p>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>{trainer.skills.map((s, i) => <li key={i}>{s}</li>)}</ul>
    </div>
  );
}