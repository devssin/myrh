import { Component, OnInit } from '@angular/core';
import { OfferService } from '../services/offer/offer.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  offers: Array<any> = [];
  totalPages: number = 0;
  currentPage: number = 0;
  arrayPages: Array<number> = [];
  constructor(private offerService: OfferService) { }
  ngOnInit(): void {
    this.getAllOffers(10,0);
  }

  getAllOffers(size:number,page:number): void{
    this.offerService.getAllOffers(size,page).subscribe(
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
