import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-bienvenida',
  templateUrl: './bienvenida.component.html',
  styleUrls: ['./bienvenida.component.scss']
})
export class BienvenidaComponent implements OnInit {

  clickado: boolean;

  constructor(private loginService: LoginService,
              private router: Router) { }

  ngOnInit(): void 
  {
    this.clickado = false;
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
    
  }

}
