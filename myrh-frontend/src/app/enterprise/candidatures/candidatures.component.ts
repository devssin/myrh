import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CandidatureService } from 'src/app/services/candidature.service';

@Component({
  selector: 'app-candidatures',
  templateUrl: './candidatures.component.html',
  styleUrls: ['./candidatures.component.css']
})
export class CandidaturesComponent implements OnInit{
  enterpriseId: string = localStorage.getItem('enterprise_id') || '';
  candidatures: Array<any> = [];
  
    constructor(private router:Router, private candidatureService: CandidatureService) { }
  
    ngOnInit(): void {
      if(this.enterpriseId == ''){
        this.router.navigate(['/enterprise/register']);
        return;   
      }
      this.getAllCandidatures();
    }

    getAllCandidatures(): void{
      this.candidatureService.getAllCandidatures(this.enterpriseId).subscribe(
        (response) => {
          this.candidatures = response;
        },
        (error) => {
          console.log(error);
        }
      );

    }


}
