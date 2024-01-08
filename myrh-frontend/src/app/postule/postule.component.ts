import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CandidatureRequest } from '../interfaces/CandidatureRequest';
import { CandidatureService } from '../services/candidature.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-postule',
  templateUrl: './postule.component.html',
  styleUrls: ['./postule.component.css']
})
export class PostuleComponent implements OnInit {
  candidatureRequest : CandidatureRequest = { 
    offerId : '',
    fullname : '',
    email : '',
    phone : '',
    coverLetter : '',
    cv : null,
  }
  
  constructor(private route: ActivatedRoute, private candidatureService: CandidatureService, private router:Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.candidatureRequest.offerId = params['offerId'];
    });
  }

  postule(): void {
    console.log(this.candidatureRequest);
    this.candidatureService.postule(this.candidatureRequest).subscribe(
      (response) => {
        console.log(response);
        Swal.fire({
          icon: 'success',
          title: 'Success',
          text: 'Your candidature has been sent successfully',
          timer: 1500
        }).then(() => {
          this.router.navigate(['/home']);
        });
      },
      (error) => {
        console.log(error);
      }
    );

  }
  onFileChange(event: any): void {
    this.candidatureRequest.cv = event.target.files[0];
  }
}
