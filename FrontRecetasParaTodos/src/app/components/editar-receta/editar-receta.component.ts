import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/interfaces/categoriaInterface';
import { Receta } from 'src/app/interfaces/recetaInterface';
import { RecetasService } from 'src/app/services/recetas.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-editar-receta',
  templateUrl: './editar-receta.component.html',
  styleUrls: ['./editar-receta.component.scss']
})
export class EditarRecetaComponent implements OnInit {

  receta: Receta;

  idReceta: number;

  raciones: number[];

  categorias: Categoria[];
  
  constructor(private tokenStorage: TokenStorageService,
              private recetaService: RecetasService) { }

  ngOnInit(): void 
  {
    this.idReceta = this.tokenStorage.getIdReceta();
    this.raciones = [1, 2, 3, 4, 5, 6, 7, 8];
    this.obtenerCategorias();
    this.obtenerReceta();
  }

  obtenerCategorias()
  {
    this.categorias = [];
    this.recetaService.obtenerCategorias().subscribe(cats =>
      {
        cats.forEach(cat => 
        {
          this.categorias.push(cat);
        });
      })
  }

  obtenerReceta()
  {
    if(this.idReceta != null && this.idReceta != undefined)
    {
      this.recetaService.obtenerReceta(this.idReceta).subscribe(resul =>
        {
          this.receta = resul;
        })
    }
    else{
      this.receta = 
      {
        nombre: '',
        ingredientes: [],
        preparacion: '',
        horas: 0,
        minutos: 0,
        raciones: 1,
        nombreUsuario: this.tokenStorage.getUser().username
      }
    }
  }

  aceptar()
  {

  }

}
