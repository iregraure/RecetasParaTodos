import { HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { TokenStorageService } from '../../services/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService {

  constructor(private tokenStorage: TokenStorageService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>
  {
    // Obtenemos el token que tenemos almacenado
    const token = this.tokenStorage.getToken();

    // Si hay token almacenado lo añadimos al header de la petición
    if(token)
    {
      request = request.clone(
        {
          headers: request.headers.set('Authorization', `Bearer ${token}`)
        }
      );
    }

    // Si la cabecera no tiene content-type se lo ponemos
    if(!request.headers.has('Content-Type'))
    {
      request = request.clone(
        {
          headers: request.headers.set('Content-Type', 'application/json; charset=utf-8')
        }
      );
    }

    // Indicamos que tiene que recibir obtetos en formato JSON
    request = request.clone(
      {
        headers: request.headers.set('Accept', 'application/json')
      }
    );

    return next.handle(request).pipe(
      map((event: HttpEvent<any>) => 
      {
        return event;
      })
    )
  }

}
