import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/interfaces/userInterface';
import { LoginService } from 'src/app/services/login.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-barra-herramientas',
  templateUrl: './barra-herramientas.component.html',
  styleUrls: ['./barra-herramientas.component.scss']
})
export class BarraHerramientasComponent implements OnInit {

  user: User =
  {
    username: "",
    pass: ""
  };

  isUserLogged: boolean;

  constructor(private tokenStorage: TokenStorageService,
              private loginService: LoginService)
  { }

  ngOnInit(): void
  {
    // this.loginService.usuarioLogeado.subscribe(usu =>
    // {
    //   this.user = usu;
    // })
  }

}
