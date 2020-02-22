import {Component, OnChanges, OnInit} from '@angular/core';
import {AuthenticationService} from '../authentication.service';
import {User} from '../model/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css', '../css/forms.css', '../css/common.css']
})

export class LoginComponent implements OnInit {
  private authenticationService: AuthenticationService;
  private remoteUserWithEmail: User;

  isAdminEmail = false;
  email = '';
  password = '';

  constructor(authenticationService: AuthenticationService) {
    this.authenticationService = authenticationService;
  }

  ngOnInit(): void {
  }

  checkIfAdminEmail() {
    this.authenticationService.getUserWithEmail(this.email).subscribe(
      data => this.isAdminEmail = data != null && data.admin,
      error => console.log(error)
    );
    // this.http.post("http://localhost:8080/isAdminEmail")
  }
}
