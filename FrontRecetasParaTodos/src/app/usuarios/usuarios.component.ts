import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../interfaces/userInterface';
import { Usuario } from '../interfaces/usuarioInterface';
import { AvisosService } from '../services/avisos.service';
import { LoginService } from '../services/login.service';
import { NacionalidadService } from '../services/nacionalidad.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss'],
})
export class UsuariosComponent implements OnInit {
  signUpForm: any;
  nacionalidades: any[];
  usuario: Usuario;
  user: User;

  constructor(
    private nacionalidadService: NacionalidadService,
    private router: Router,
    private loginService: LoginService,
    private avisos: AvisosService,
    private tokenStorage: TokenStorageService
  ) {}

  // Cuando se inicia el componente se cargan las nacionalidades y se inicializa el formulario
  ngOnInit(): void {
    this.obtenerNacionalidades();

    this.user = this.tokenStorage.getUser();

    this.obtenerUsuario();
    
  }

  // Método que recupera todas las nacionalidades de la base de datos y las guarda en una variable
  obtenerNacionalidades() {
    this.nacionalidades = [];
    this.nacionalidadService.getListadoNacionalidades().subscribe((paises) => {
      paises.forEach((pais) => {
        this.nacionalidades.push(pais);
      });
    });
  }

  obtenerUsuario()
  {
    this.loginService.obtenerUsuario(this.user.username).subscribe(resul =>
      {
        this.usuario = resul;
      })
  }

  // Método para actualizar el usuario
  actualizar() {
    this.loginService.actualizarUsuario(this.usuario).subscribe((resul: any) => {
      this.router.navigate(['/recetas']);
    });
  }
}
