import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OfferService } from 'src/app/services/offer/offer.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
  enterpriseId: string = localStorage.getItem('enterprise_id') || '';
  offers: Array<any> = [];
  totalPages: number = 0;
  currentPage: number = 0;
  arrayPages: Array<number> = [];
  constructor(private offerService: OfferService, private router:Router) { }

  ngOnInit(): void {
    if(this.enterpriseId == ''){
      this.router.navigate(['/enterprise/register']);
      return;
    }
    this.getAllOffers(10,0);
    
  }
  getAllOffers(size:number,page:number): void{
    this.offerService.getAllOffersByEnterprise(size,page, this.enterpriseId).subscribe(
      (response) => {
        console.log(response);
        this.offers = response.content;
        this.totalPages = response.totalPages;
        this.currentPage = response.number;
        this.arrayPages = new Array(this.totalPages);
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
