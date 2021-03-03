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
    window.sessionStorage.setItem('user', user);
  }

  public getUser(): any
  {
    return JSON.parse(sessionStorage.getItem('user'));
  }

}
