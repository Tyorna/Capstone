import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './componenti/auth/auth-int/auth.interceptor';

import { RouterModule, Route } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { NavbarComponent } from './componenti/navbar/navbar/navbar.component';
import { ProfileComponent } from './componenti/profile/profile.component';
import { LoginComponent } from './componenti/login/login.component';
import { RegistrazioneComponent } from './componenti/registrazione/registrazione.component';
import { ErrorPageComponent } from './componenti/error-page/error-page.component';
import { HomeComponent } from './componenti/home/home.component';
import { DettagliutenteComponent } from './componenti/dettagliutente/dettagliutente.component';
import { AuthGuard } from './componenti/auth/auth-int/auth.guard';
import { DomandeComponent } from './componenti/domande/domande.component';
import { LevelComponent } from './componenti/level/level.component';
import { RisultatiComponent } from './componenti/risultati/risultati.component';
import { GradesComponent } from './componenti/grades/grades.component';


const rotte: Route[] = [
  {
    path: 'test',
    component: LevelComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'domande/by-level/:level',
    component: DomandeComponent,
  },
  {
    path: 'risultati',
    component: RisultatiComponent,
  },
  {
    path: 'profilo',
    component: ProfileComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'dettagli/:id',
        component: DettagliutenteComponent,
      },
      {
        path: 'grades/:id',
        component: GradesComponent,
      },
    ],
  },
  {
    path: 'auth/login',
    component: LoginComponent,
  },
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'auth/register',
    component: RegistrazioneComponent,
  },
  {
    path: '**',
    component: ErrorPageComponent,
  },

];
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProfileComponent,
    LoginComponent,
    RegistrazioneComponent,
    DettagliutenteComponent,
    ErrorPageComponent,
    HomeComponent,
    DomandeComponent,
    LevelComponent,
    RisultatiComponent,
    GradesComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(rotte),
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
