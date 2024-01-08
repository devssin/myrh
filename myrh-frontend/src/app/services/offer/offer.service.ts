import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { offerRequest } from 'src/app/interfaces/offer-request';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  constructor(private http:HttpClient) { }

  apiUrl = "http://localhost:8080/offers";

  getAllOffersByEnterprise(size:number,page:number, enterprise_id: string): Observable<any>{
    const params = new HttpParams().set('page', page.toString()).set('size', size.toString());

    return this.http.get(`${this.apiUrl}/${enterprise_id}`, {params});
  }

  getAllOffers(size:number,page:number): Observable<any>{
    const params = new HttpParams().set('page', page.toString()).set('size', size.toString());
    return this.http.get(`${this.apiUrl}`, {params});
  }

  


  addOffer(offer: offerRequest) : Observable<any>{
    
    return this.http.post(`${this.apiUrl}`, offer);
  }
}
