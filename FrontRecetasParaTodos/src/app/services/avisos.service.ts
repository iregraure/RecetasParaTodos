import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AvisosService {

  usuCreado: boolean = false;

  constructor() { }

  usuarioCreado()
  {
    this.usuCreado = !this.usuCreado;
  }
}
