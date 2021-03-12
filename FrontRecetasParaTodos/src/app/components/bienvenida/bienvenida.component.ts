import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { LoginService } from '../../services/login.service';
import { User } from '../../interfaces/userInterface';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-bienvenida',
  templateUrl: './bienvenida.component.html',
  styleUrls: ['./bienvenida.component.scss'],
})
export class BienvenidaComponent implements OnInit {
  clickado: boolean;
  creado: boolean;

  constructor(
    private loginService: LoginService,
    private router: Router,
    private tokenStorage: TokenStorageService
  ) {}

  ngOnInit(): void {
    this.clickado = false;
    this.creado = false;
  }

  cambiarClickado() {
    this.clickado = !this.clickado;
  }

  creaUsuario() {
    this.router.navigate(['/signUp']);
  }

  loginInvitado() {
    this.loginService.invitadoLogin().subscribe((res) => {
      if (res != null && res != undefined) {
        let user: User = {
          username: 'invitado',
          pass: 'Invitado'
        };
        this.router.navigate(['/recetas']);
        this.tokenStorage.saveToken(res);
        this.tokenStorage.saveUser(user);
        Swal.fire(
          {
            title: `Bienvenid@ ${user.username}`,
            text: 'Logado con éxito',
            icon: 'success'
          }
        )
      }
    });
  }
}
