import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/interfaces/userInterface';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-barra-herramientas',
  templateUrl: './barra-herramientas.component.html',
  styleUrls: ['./barra-herramientas.component.scss']
})
export class BarraHerramientasComponent implements OnInit {

  user: User;

  isUserLogged: boolean;

  constructor(private tokenStorage: TokenStorageService) 
  { }

  ngOnInit(): void 
  {
    this.user = this.tokenStorage.getUser();
    console.log(this.user)
  }

}
