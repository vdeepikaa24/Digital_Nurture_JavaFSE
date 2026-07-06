import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router'; 
import { Employee } from './employee';
import { EmployeeService } from './employee.service'; 

@Component({
  selector: 'app-edit-employee',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  employee: Employee | null = null;
  employeeName = '';
  departmentName = '';

  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private router: Router 
  ) {}

ngOnInit() {
  const id = Number(this.route.snapshot.paramMap.get('id'));
  this.employeeService.getEmployeeById(id).subscribe({
    next: (data: Employee) => {
      this.employee = data;
      this.employeeName = data.name;
      
      this.departmentName = typeof data.department === 'object' && data.department !== null
                            ? (data.department as any).name 
                            : data.department;
    },
    error: (err) => console.error('Error fetching employee', err)
  });
}

  saveEmployee() {
    if (this.employee) {
      const updatedEmployee: Employee = {
        id: this.employee.id,
        name: this.employeeName,
        // Corrected: Map the string departmentName to the expected Department object structure
        department: {
          id: this.employee.department.id, // Keep the existing department ID
          name: this.departmentName        // Use the updated name
        }
      };

      this.employeeService.updateEmployee(this.employee.id, updatedEmployee).subscribe(() => {
        alert('Employee updated successfully!');
        this.router.navigate(['/employees']); 
      });
    }
  }
}