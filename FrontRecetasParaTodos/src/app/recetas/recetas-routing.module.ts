import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

const recetasRoutes: Routes = [
  {}
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(recetasRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class RecetasRoutingModule { }
