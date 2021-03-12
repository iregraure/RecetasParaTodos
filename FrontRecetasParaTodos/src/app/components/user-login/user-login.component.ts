import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../interfaces/userInterface';
import { AvisosService } from '../../services/avisos.service';
import { LoginService } from '../../services/login.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent implements OnInit {
  
  user: User = null;

  @Output() mostrarModal: EventEmitter<null> = new EventEmitter<null>();

  constructor(private loginService: LoginService,
              private router: Router,
              public avisos: AvisosService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit(): void 
  {
    this.user = 
    {
      username: '',
      pass: ''
    }
  }

  aceptar()
  {
    this.loginService.usuarioLogin(this.user).subscribe((res) =>
      {
        if(res != null && res != undefined)
        {
          this.tokenStorage.saveToken(res);
          this.tokenStorage.saveUser(this.user);
          this.router.navigate(['/recetas']);
          Swal.fire(
            {
              title: `Bienvenid@ ${this.user.username}`,
              text: 'Logado con éxito',
              icon: 'success'
            }
          )
        }
      },
      (error) =>
      {
        if(error.status == 401)
        {
          Swal.fire(
            {
              title: 'Error',
              text: 'Usuario o contraseña incorrectos',
              // text: 'Se ha producido un error inesperado',
              icon: 'warning'
            }
          )
        }
        else{
          Swal.fire(
            {
              title: 'Error inesperado',
              text: 'Se ha producido un error inesperado. Pongase en contacto con el administrador',
              // text: 'Se ha producido un error inesperado',
              icon: 'error'
            }
          )
        }
      });
  }

  cancelar()
  {
    this.mostrarModal.emit(null);
    this.router.navigate(['/bienvenida']);
  }

}
