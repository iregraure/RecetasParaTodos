import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Nacionalidad } from '../interfaces/nacionalidadInterface';

@Injectable({
  providedIn: 'root'
})
export class NacionalidadService {

  constructor(private http: HttpClient) { }

  getListadoNacionalidades(): Observable<Nacionalidad []>
  {
    return this.http.get<Nacionalidad[]>(environment.nacionalidadUrl);
  }
}
