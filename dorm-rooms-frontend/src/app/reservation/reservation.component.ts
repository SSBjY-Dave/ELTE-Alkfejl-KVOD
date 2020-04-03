import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ErrorType} from '../app.component';
import {AuthenticationService} from '../authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  @Output() public errorEvent: EventEmitter<ErrorType> = new EventEmitter<ErrorType>();

  private authenticationService: AuthenticationService;
  private router: Router;

  constructor(authenticationService: AuthenticationService, router: Router) {
    this.authenticationService = authenticationService;
    this.router = router;
  }

  ngOnInit(): void {
    // this.handleUserAuthenticationStatus();
  }


  handleUserAuthenticationStatus(): void {
    this.authenticationService.isAuthTokenCookiePresentAndValid().then(loggedIn => {
      if (!loggedIn) {
        this.router.navigate(['/login']).then();
      }
    }).catch(() => {
      this.errorEvent.emit(ErrorType.BackendError);
    });
  }
}
