import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EnterpriseRequest } from 'src/app/interfaces/enterprise-request';
import { EnterpriseService } from 'src/app/services/enterprise/enterprise.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private entrepriseService: EnterpriseService,
    private router: Router) { }
  public enterpriseRequest: EnterpriseRequest = {
    name: '',
    login: '',
    email: '',
    password: '',
    image: undefined,
    phone: ''
  }

  register(): void {
    this.entrepriseService.register(this.enterpriseRequest).subscribe(
      (response) => {
        console.log(response);
        Swal.fire({
          icon: 'success',
          title: 'Success',
          text: 'Your account has been created successfully',
          showConfirmButton: false,
          timer: 1500
        }).then(() => {
          this.router.navigate(['/enterprise/verify'], { queryParams: { id : response.id } });
        });
      },
      (error) => {
        console.log(error);
      }
    );
    
  }
  onFileSelected(event: any): void {
    this.enterpriseRequest.image = event.target.files[0];
  }

  
}
