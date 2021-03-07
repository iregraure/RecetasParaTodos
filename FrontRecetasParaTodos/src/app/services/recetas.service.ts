import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Receta } from '../interfaces/recetaInterface';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RecetasService {

  constructor(private http: HttpClient) { }

  obtenerRecetasCategoria(categoria: String): Observable<any>
  {
    return this.http.get(`${environment.recetasCategoriaUrl}${categoria}`);
  }

  obtenerCategorias(): Observable<any>
  {
    return this.http.get(environment.categoriasUrl);
  }

  obtenerReceta(id: number): Observable<any>
  {
    return this.http.get(`${environment.recetaUrl}${id}`);
  }

}
