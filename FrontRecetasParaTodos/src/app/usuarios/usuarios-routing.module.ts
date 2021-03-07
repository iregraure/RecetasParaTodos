import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IsLogedGuard } from '../guards/is-loged.guard';

import { UsuariosComponent } from './usuarios.component';

const routes: Routes = [{ path: '', component: UsuariosComponent, canActivate: [IsLogedGuard] }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuariosRoutingModule { }
