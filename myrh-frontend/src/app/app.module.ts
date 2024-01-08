import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './enterprise/register/register.component';
import { VerifieComponent } from './enterprise/verifie/verifie.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './inc/header/header.component';
import { FooterComponent } from './inc/footer/footer.component';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from './inc/sidebar/sidebar.component';
import { DashboardComponent } from './enterprise/dashboard/dashboard.component';
import { AddOfferComponent } from './enterprise/add-offer/add-offer.component';
import { PostuleComponent } from './postule/postule.component';
import { CandidaturesComponent } from './enterprise/candidatures/candidatures.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    VerifieComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    DashboardComponent,
    AddOfferComponent,
    PostuleComponent,
    CandidaturesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
