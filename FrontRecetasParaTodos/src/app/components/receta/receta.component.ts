import { Component, EventEmitter, OnInit, Output, Input } from '@angular/core';
import { Receta } from 'src/app/interfaces/recetaInterface';
import { User } from 'src/app/interfaces/userInterface';
import { RecetasService } from 'src/app/services/recetas.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-receta',
  templateUrl: './receta.component.html',
  styleUrls: ['./receta.component.scss']
})
export class RecetaComponent implements OnInit {

  @Input() receta: Receta;

  usuario: User;

  ingredientes: string[];

  @Output() mostrarReceta: EventEmitter<null> = new EventEmitter<null>();
  
  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    this.usuario = this.tokenStorage.getUser();
  }

  cancelar()
  {
    this.mostrarReceta.emit(null);
  }

}
