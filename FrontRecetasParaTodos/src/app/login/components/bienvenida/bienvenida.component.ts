import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AvisosService } from '../../../services/avisos.service';

import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-bienvenida',
  templateUrl: './bienvenida.component.html',
  styleUrls: ['./bienvenida.component.scss']
})
export class BienvenidaComponent implements OnInit {

  clickado: boolean;
  creado: boolean;

  constructor(private loginService: LoginService,
              private router: Router) { }

  ngOnInit(): void 
  {
    this.clickado = false;
    this.creado = false;
  }

  cambiarClickado()
  {
    this.clickado = !this.clickado;
  }

  creaUsuario()
  {
    this.router.navigate(['/signUp']);
  }

  loginInvitado()
  {
    this.loginService.invitadoLogin();
    this.router.navigate(['/signUp']);
  }

}
