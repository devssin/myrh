import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CandidatureRequest } from '../interfaces/CandidatureRequest';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CandidatureService {

  constructor(private http:HttpClient) {}

  postule(candidatureRequest : CandidatureRequest): Observable<any> {

    const formdata = new FormData();
    formdata.append('offerId', candidatureRequest.offerId);
    formdata.append('fullname', candidatureRequest.fullname);
    formdata.append('email', candidatureRequest.email);
    formdata.append('phone', candidatureRequest.phone);
    formdata.append('coverLetter', candidatureRequest.coverLetter);
    formdata.append('cv', candidatureRequest.cv as File);
    return this.http.post('http://localhost:8080/candidatures', formdata);

  }

  getAllCandidatures(enterprise_id: string): Observable<any>{
    return this.http.get(`http://localhost:8080/candidatures/${enterprise_id}`);
  }
}
