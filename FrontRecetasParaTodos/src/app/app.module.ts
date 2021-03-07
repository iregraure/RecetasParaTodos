import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BienvenidaComponent } from './components/bienvenida/bienvenida.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { UserSignupComponent } from './components/user-signup/user-signup.component';
import { BarraHerramientasComponent } from './components/barra-herramientas/barra-herramientas.component';
import { RecetasComponent } from './components/recetas/recetas.component';
import { RecetaComponent } from './components/receta/receta.component';

@NgModule({
  declarations: [
    AppComponent,
    BienvenidaComponent,
    UserLoginComponent,
    UserSignupComponent,
    BarraHerramientasComponent,
    RecetasComponent,
    RecetaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [
    BarraHerramientasComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
