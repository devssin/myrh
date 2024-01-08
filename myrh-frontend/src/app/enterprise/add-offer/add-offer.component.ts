import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { offerRequest } from 'src/app/interfaces/offer-request';
import { OfferService } from 'src/app/services/offer/offer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-offer',
  templateUrl: './add-offer.component.html',
  styleUrls: ['./add-offer.component.css']
})
export class AddOfferComponent implements OnInit {
  constructor(private router: Router,private offerService: OfferService) { }
  enterpriseId: string = '';
  offerRequert : offerRequest = {
    title : '',
    description : '',
    profile : '',
    salary : '',
    enterprise_id : '',
  }
  ngOnInit(): void {
    this.enterpriseId = localStorage.getItem('enterprise_id') || '';
    if (this.enterpriseId === '') {
      this.router.navigate(['/enterprise/register']);
    }
  }

  addOffer(): void {
    this.offerRequert.enterprise_id = this.enterpriseId;
    this.offerService.addOffer(this.offerRequert).subscribe(
      (response) => {
        Swal.fire({
          icon: 'success',
          title: 'Success',
          text: 'Your offer has been created successfully',
          timer: 1500
        }).then(() => {
          this.router.navigate(['/enterprise/dashboard']);
        });
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
