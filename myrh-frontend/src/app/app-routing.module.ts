import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './enterprise/register/register.component';
import { VerifieComponent } from './enterprise/verifie/verifie.component';
import { DashboardComponent } from './enterprise/dashboard/dashboard.component';
import { AddOfferComponent } from './enterprise/add-offer/add-offer.component';
import { PostuleComponent } from './postule/postule.component';
import { CandidaturesComponent } from './enterprise/candidatures/candidatures.component';

const routes: Routes = [
  {path : '', redirectTo : '/home', pathMatch : 'full'},
  {path: 'home', component : HomeComponent },
  {path :"enterprise/register", component: RegisterComponent},
  {path :"enterprise/verify", component: VerifieComponent},
  {path:"enterprise/dashboard", component: DashboardComponent},
  {path: 'add-offer', component: AddOfferComponent},
  {path: 'postule/:offerId', component: PostuleComponent},
  {path: 'enterprise/candidatures', component: CandidaturesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
