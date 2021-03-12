import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signOut(): void
  {
    window.sessionStorage.clear();
  }

  saveToken(token: string): void
  {
    window.sessionStorage.removeItem('jwt');
    window.sessionStorage.setItem('jwt', token);
  }

  public getToken(): string
  {
    return sessionStorage.getItem('jwt');
  }

  public saveUser(user): void
  {
    window.sessionStorage.removeItem('user');
    window.sessionStorage.setItem('user', JSON.stringify(user));
  }

  public getUser(): any
  {
    return JSON.parse(sessionStorage.getItem('user'));
  }

  public saveIdReceta(id: number): void
  {
    window.sessionStorage.removeItem('id');
    window.sessionStorage.setItem('idReceta', id.toString());
  }

  public getIdReceta(): any
  {
    return Number.parseInt(sessionStorage.getItem('idReceta'));
  }

}
