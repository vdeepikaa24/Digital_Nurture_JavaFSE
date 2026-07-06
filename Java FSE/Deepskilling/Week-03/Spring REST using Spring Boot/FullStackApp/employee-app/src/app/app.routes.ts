import { Routes } from '@angular/router';
import { EditEmployeeComponent } from './edit-employee.component';
import { EmployeeListComponent } from './employee-list.component';

export const routes: Routes = [
  { path: '', component: EmployeeListComponent },
  { path: 'edit/:id', component: EditEmployeeComponent }
];