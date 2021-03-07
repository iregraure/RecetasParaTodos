import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Nacionalidad } from '../../interfaces/nacionalidadInterface';
import { User } from '../../interfaces/userInterface';
import { Usuario } from '../../interfaces/usuarioInterface';
import { AvisosService } from '../../services/avisos.service';
import { LoginService } from '../../services/login.service';
import { NacionalidadService } from '../../services/nacionalidad.service';

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.scss']
})
export class UserSignupComponent implements OnInit {

  signUpForm: FormGroup;
  usuario: Usuario = null;
  nacionalidades: Nacionalidad[];

  constructor(private nacionalidadService: NacionalidadService,
              private router: Router,
              private loginService: LoginService,
              private avisos: AvisosService) { }

  // Cuando se inicia el componente se cargan las nacionalidades y se inicializa el formulario
  ngOnInit(): void {
    this.obtenerNacionalidades();

    this.signUpForm = new FormGroup(
      {
        username: new FormControl('', [Validators.required, Validators.minLength(4)]),
        pass: new FormControl('', [Validators.required, Validators.minLength(6), Validators.pattern("((?=.*[A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z]))^.{0,}$")]),
        nombre: new FormControl('', [Validators.required]),
        fechaNacimiento: new FormControl('', [Validators.required]),//, Validators.pattern("^\d{2}\/\d{2}\/\d{4}$")]),
        nacionalidad: new FormControl('', []),
        genero: new FormControl('', [])
      }
    )
  }

  // Método que recupera todas las nacionalidades de la base de datos y las guarda en una variable
  obtenerNacionalidades()
  {
    this.nacionalidades = [];
    this.nacionalidadService.getListadoNacionalidades().subscribe(paises =>
      {
        paises.forEach(pais =>
          {
            this.nacionalidades.push(pais);
          })
      });
  }

  // Método para crear el usuario
  aceptar()
  {
    this.usuario = 
    {
      username: this.signUpForm.value.username,
      pass: this.signUpForm.value.pass,
      nombre: this.signUpForm.value.nombre,
      fechaNacimiento: this.signUpForm.value.fechaNacimiento,
      nacionalidad: this.signUpForm.value.nacionalidad,
      genero: this.signUpForm.value.genero
    }
    
    this.loginService.registraUsuario(this.usuario).subscribe((resul: any) =>
      {
        this.avisos.usuarioCreado();
        this.router.navigate(['/login']);
      });
  }

  // Método para cancelar y volver a la página inicial
  cancelar()
  {
    this.router.navigate(['/bienvenida']);
  }

}
