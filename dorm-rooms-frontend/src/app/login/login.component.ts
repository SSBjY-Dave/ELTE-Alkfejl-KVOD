import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AuthenticationService} from '../authentication.service';
import {User} from '../model/User';
import {Router} from '@angular/router';
import {ErrorType} from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css', '../css/forms.css', '../css/common.css']
})

export class LoginComponent implements OnInit {
  @Output() public errorEvent: EventEmitter<ErrorType> = new EventEmitter<ErrorType>();

  private authenticationService: AuthenticationService;
  private router: Router;
  private loginProcessRunning = false;

  private remoteUserWithEmail: User;

  public loginAttemptErrorList: Array<LOGIN_ERRORS> = [];

  public LOGIN_TYPES = LOGIN_TYPES;
  public LOGIN_ERRORS = LOGIN_ERRORS;

  isAdminEmail = false;
  email = '';
  password = '';

  constructor(authenticationService: AuthenticationService, router: Router) {
    this.authenticationService = authenticationService;
    this.router = router;

    this.authenticationService.setErrorEvent(this.errorEvent);
  }

  ngOnInit(): void {
    this.handleUserAlreadyLoggedIn();
  }

  checkIfAdminEmail(): void {
    this.authenticationService.getUserWithEmail(this.email).subscribe(
      data => this.isAdminEmail = data != null && data.admin,
      error => console.log(error)
    );
  }

  handleUserAlreadyLoggedIn(): void {
    this.authenticationService.isAuthTokenCookiePresentAndValid().then(loggedIn => {
      if (loggedIn) {
        this.router.navigate(['/reservation']).then();
      }
    }).catch(() => {
      this.errorEvent.emit(ErrorType.BackendError);
    });
  }

  validateLoginDataSyntax(): boolean {
    this.loginAttemptErrorList.splice(0, this.loginAttemptErrorList.length); // clear error array

    if (this.email.length === 0) {
      this.loginAttemptErrorList.push(LOGIN_ERRORS.EMAIL_EMPTY);
    } else if (!AuthenticationService.isEmailSyntaxValue(this.email)) {
      this.loginAttemptErrorList.push(LOGIN_ERRORS.EMAIL_SYNTAX);
    }

    if (this.password.length === 0) {
      this.loginAttemptErrorList.push(LOGIN_ERRORS.PASSWORD_EMPTY);
    }

    return this.loginAttemptErrorList.length === 0;
  }

  async tryLogin(loginAs: LOGIN_TYPES): Promise<void> {
    if (this.loginProcessRunning) {
      return; // mitigate spamming
    }

    this.loginProcessRunning = true;

    if (this.validateLoginDataSyntax()) {
      const isAuthenticationSuccessful = await this.authenticationService.tryAuthenticate(this.email, this.password);
      if (isAuthenticationSuccessful) {
        if (loginAs === LOGIN_TYPES.AS_ADMIN /*&& this.authenticationService.getCurrentUser().admin*/) {
          this.router.navigate(['/admin']).then();
        } else {
          this.router.navigate(['/reservation']).then();
        }
      } else {
        this.loginAttemptErrorList.push(LOGIN_ERRORS.INVALID_DATA);
      }
    }

    this.loginProcessRunning = false;
  }

  async inputFieldPressEvent(event: KeyboardEvent) {
    if (event.key === 'Enter' && this.validateLoginDataSyntax()) {
      await this.tryLogin(LOGIN_TYPES.AS_USER);
    }
  }
}

enum LOGIN_TYPES {
  AS_USER,
  AS_ADMIN
}

enum LOGIN_ERRORS {
  EMAIL_EMPTY,
  EMAIL_SYNTAX,
  PASSWORD_EMPTY,
  INVALID_DATA
}
