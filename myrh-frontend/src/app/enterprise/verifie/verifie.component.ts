import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VerifyRequest } from 'src/app/interfaces/verify-request';
import { EnterpriseService } from 'src/app/services/enterprise/enterprise.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-verifie',
  templateUrl: './verifie.component.html',
  styleUrls: ['./verifie.component.css'],
})
export class VerifieComponent implements OnInit {
  verifyRequest: VerifyRequest = {
    id: '',
    code: '',
  };
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private enterpriseService: EnterpriseService
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.verifyRequest.id = params['id'];
    });
    console.log(this.verifyRequest.id);
  }

  verify(): void {
    this.enterpriseService.verify(this.verifyRequest).subscribe(
      (response) => {
        if (response) {
          localStorage.setItem('enterprise_id', this.verifyRequest.id);
          Swal.fire({
            icon: 'success',
            title: 'Success',
            text: 'Your account has been verified successfully',
            showConfirmButton: true
          }).then(() => {
            this.router.navigate(['/home']);
          });
        }else{
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Your code is incorrect',
            showConfirmButton: true
          });
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
