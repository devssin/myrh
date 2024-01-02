import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './enterprise/register/register.component';
import { VerifieComponent } from './enterprise/verifie/verifie.component';

const routes: Routes = [
  {path : '', redirectTo : '/home', pathMatch : 'full'},
  {path: 'home', component : HomeComponent },
  {path :"enterprise/register", component: RegisterComponent},
  {path :"enterprise/verify", component: VerifieComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
