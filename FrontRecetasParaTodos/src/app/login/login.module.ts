import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { LoginRoutingModule } from './login-routing.module';

import { BienvenidaComponent } from './components/bienvenida/bienvenida.component';

import { LoginService } from './services/login.service';

import { UserLoginComponent } from './components/user-login/user-login.component';
import { UserSignupComponent } from './components/user-signup/user-signup.component';

@NgModule({
  declarations: [BienvenidaComponent, UserLoginComponent, UserSignupComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [ LoginService ]
})
export class LoginModule { }
