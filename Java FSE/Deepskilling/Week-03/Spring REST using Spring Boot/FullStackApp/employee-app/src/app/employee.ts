export interface Department {
  id: number;
  name: string;
}

export interface Employee {
  id: number;
  name: string;
  department: Department; 
}