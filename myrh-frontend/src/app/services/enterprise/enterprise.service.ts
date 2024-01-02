import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VerifieComponent } from 'src/app/enterprise/verifie/verifie.component';
import { EnterpriseRequest } from 'src/app/interfaces/enterprise-request';
import { VerifyRequest } from 'src/app/interfaces/verify-request';

@Injectable({
  providedIn: 'root'
})
export class EnterpriseService {
  

  constructor(private http: HttpClient) { }

  register(enterprise : EnterpriseRequest): Observable<any>{
    const formdata = new FormData();
    formdata.append('name', enterprise.name);
    formdata.append('login', enterprise.login);
    formdata.append('email', enterprise.email);
    formdata.append('password', enterprise.password);
    formdata.append('image', enterprise.image as File);
    formdata.append('phone', enterprise.phone);
    return this.http.post('http://localhost:8080/enterprises', formdata);

  }

  verify(verifyRequest: VerifyRequest): Observable<any>{
    return this.http.post(`http://localhost:8080/enterprises/verify`, verifyRequest );
  }
}
