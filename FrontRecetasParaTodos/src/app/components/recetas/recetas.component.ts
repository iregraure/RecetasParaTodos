import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/interfaces/categoriaInterface';
import { Receta } from 'src/app/interfaces/recetaInterface';
import { RecetasService } from 'src/app/services/recetas.service';

@Component({
  selector: 'app-recetas',
  templateUrl: './recetas.component.html',
  styleUrls: ['./recetas.component.scss']
})
export class RecetasComponent implements OnInit {

  recetas: Receta[];
  receta: Receta;
  categorias: Categoria[];
  seleccionada: string;
  visible: boolean;
  recargada = false;

  constructor(private recetasService: RecetasService) { }

  ngOnInit(): void {
    this.obtenerCategorias();
    this.visible = false;
  }

  obtenerCategorias()
  {
    this.categorias = [];
    this.recetasService.obtenerCategorias().subscribe(cats => 
      {
        cats.forEach(categoria => {
          this.categorias.push(categoria);
        });
      })
  }

  obtieneRecetasCategoria(categoria: string)
  {
    this.seleccionada = categoria;
    this.recetas = [];
    this.recetasService.obtenerRecetasCategoria(categoria).subscribe(recibidas =>
      {
        recibidas.forEach(receta => {
          this.recetas.push(receta);
        });
      })
  }

  verReceta(id: number){
    this.recetasService.obtenerReceta(id).subscribe(resul => 
      {
        this.receta = resul;
        this.visible = !this.visible;
      })
  }

  mostrar()
  {
    this.visible = !this.visible;
  }

}
