import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Receta } from '../interfaces/recetaInterface';
import { environment } from '../../environments/environment';
import { Categoria } from '../interfaces/categoriaInterface';

@Injectable({
  providedIn: 'root'
})
export class RecetasService {

  constructor(private http: HttpClient) { }

  obtenerRecetasCategoria(categoria: String): Observable<any>
  {
    return this.http.get<Receta[]>(`${environment.recetasCategoriaUrl}${categoria}`);
  }

  obtenerCategorias(): Observable<Categoria[]>
  {
    return this.http.get<Categoria[]>(environment.categoriasUrl);
  }

  obtenerReceta(id: number): Observable<any>
  {
    return this.http.get<Receta>(`${environment.recetaUrl}${id}`);
  }

  obtenerRecetaRandom(): Observable<any>
  {
    return this.http.get<Receta>(environment.recetaRandomUrl);
  }

}
