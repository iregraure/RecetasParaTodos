import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../interfaces/userInterface';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent implements OnInit {
  
  user: User = null;

  @Output() eventEmmiter: EventEmitter<null> = new EventEmitter<null>();

  constructor(private loginService: LoginService,
              private router: Router) { }

  ngOnInit(): void 
  {
    this.user = 
    {
      username: '',
      pass: ''
    }
  }

  aceptar()
  {
    this.loginService.usuarioLogin(this.user);

    this.router.navigate(['/signUp']);
  }

  cancelar()
  {
    this.eventEmmiter.emit(null);
  }

}
