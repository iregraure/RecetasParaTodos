import { Injectable } from '@angular/core';
import { User } from '../interfaces/userInterface';
import { Usuario } from '../interfaces/usuarioInterface';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { Md5 } from 'ts-md5/dist/md5';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  user: User;
  usuario: Usuario;
  clickado: boolean = false;

  constructor(private http: HttpClient,
              private tokenStorage: TokenStorageService) { }

  invitadoLogin(): Observable<any>
  {
    this.user = 
    {
      username: 'invitado',
      pass: 'invitado'
    };
    return this.http.post<any>(environment.loginUrl, this.user);
  }

  usuarioLogin(formUser: User): Observable<any>
  {
    this.user = formUser;
    return this.http.post(environment.loginUrl, this.user, { responseType: 'text' });
  }

  registraUsuario(formUsuario: Usuario): Observable<any>
  {
    this.usuario = formUsuario;
    return this.http.post<User>(environment.signUpUrl, this.usuario);
  }

  cambiaClickado()
  {
    this.clickado = !this.clickado;
  }

}
