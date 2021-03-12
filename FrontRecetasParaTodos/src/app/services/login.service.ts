import { EventEmitter, Injectable, Output } from '@angular/core';
import { User } from '../interfaces/userInterface';
import { Usuario } from '../interfaces/usuarioInterface';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { TokenStorageService } from './token-storage.service';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  user: User =
  {
    username: "",
    pass: ""
  };
  usuario: Usuario;
  clickado: boolean = false;

  @Output() usuarioLogeado = new EventEmitter<User>();

  public isUserLogged = new Subject<boolean>();
  public isLogged = this.isUserLogged.asObservable();
  public url = '';

  constructor(private http: HttpClient,
              private tokenStorage: TokenStorageService) { }

  invitadoLogin(): Observable<any>
  {
    this.user =
    {
      username: 'invitado',
      pass: 'Invitado'
    };
    return this.http.post(environment.loginUrl, this.user, { responseType: 'text' });
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

  obtenerUsuario(username: String): Observable<any>
  {
    return this.http.get<Usuario>(`${environment.usuarioUrl}${username}`);
  }

  actualizarUsuario(usuario: Usuario): Observable<any>
  {
    return this.http.put(`${environment.usuarioUrl}${usuario.username}`, usuario);
  }

  // getUserAutenticado(): Observable<User>
  // {
  //   return this.http.get<User>(environment.usuarioAutenticadoUrl)
  // }

  // getUsuarioAutenticado(): Observable<User>
  // {
  //   let jwt = this.tokenStorage.getToken();
  //   return this.http.get<User>(`${environment.usuarioAutenticadoUrl}${jwt}`).pipe(
  //     tap(usu =>
  //       {
  //         if((this.user == null && usu != null) || (this.user != null && usu == null) ||
  //         (this.user != null && usu == null && this.user.username != usu.username))
  //         {
  //           this.emitirUsuarioLogeado();
  //           this.user = usu;
  //         }
  //       })
  //   )
  // }

  // emitirUsuarioLogeado()
  // {
  //   this.getUsuarioAutenticado().subscribe(usu =>
  //     {
  //       this.usuarioLogeado.emit(usu);
  //     });
  // }

  isLoggedIn(url: string)
  {
    const logged = this.tokenStorage.getToken();
    if(!logged)
    {
      this.url = url;
      return false;
    }
    return true;
  }

}
