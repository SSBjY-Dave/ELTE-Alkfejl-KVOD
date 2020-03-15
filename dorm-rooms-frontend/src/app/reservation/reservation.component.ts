import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ErrorType} from '../app.component';
import {AuthenticationService} from '../authentication.service';
import {Router} from '@angular/router';
import {User} from '../model/User';
import {Building} from '../model/Building';
import {AssetLoaderService} from '../asset-loader.service';
import {Floor} from '../model/Floor';
import {log} from 'util';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  @Output() public errorEvent: EventEmitter<ErrorType> = new EventEmitter<ErrorType>();

  private authenticationService: AuthenticationService;
  private router: Router;
  private assetLoaderService: AssetLoaderService;

  private currentUser: User;
  private building: Building;

  constructor(authenticationService: AuthenticationService, router: Router, assetLoaderService: AssetLoaderService) {
    this.authenticationService = authenticationService;
    this.router = router;
    this.assetLoaderService = assetLoaderService;
  }

  ngOnInit(): void {
    this.handleUserAuthenticationStatus();
    this.loadBuilding();
  }


  handleUserAuthenticationStatus(): void {
    this.authenticationService.isAuthTokenCookiePresentAndValid().then(loggedIn => {
      if (!loggedIn) {
        this.router.navigate(['/login']).then();
      } else {
        this.currentUser = this.authenticationService.getCurrentUser();
      }
    }).catch(() => {
      this.errorEvent.emit(ErrorType.BackendError);
    });
  }

  checkoutFromRoom() {
    // TODO: implement
  }

  loadBuilding() {
    this.assetLoaderService.loadAsset<Array<Floor>>('floor_maps/adk/building.json').subscribe(
      data => console.log(data),
        error => console.log(error)
    );
  }
}
