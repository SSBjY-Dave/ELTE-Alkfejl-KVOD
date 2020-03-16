import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ErrorType} from '../app.component';
import {AuthenticationService} from '../authentication.service';
import {Router} from '@angular/router';
import {User} from '../model/User';
import {Building} from '../model/Building';
import {AssetLoaderService} from '../asset-loader.service';

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

  public currentUser: User;
  public building: Building = new Building();

  constructor(authenticationService: AuthenticationService, router: Router, assetLoaderService: AssetLoaderService) {
    this.authenticationService = authenticationService;
    this.router = router;
    this.assetLoaderService = assetLoaderService;
  }

  ngOnInit(): void {
    // this.handleUserAuthenticationStatus();
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

  async loadBuilding() {
    this.building = await this.assetLoaderService.loadBuilding('floor_maps/adk/building.json');
  }


  calculateRoomX(base: number) {
    console.log(document.getElementById('building').style.width);
    return 0;
  }

  calculateRoomY(base: number) {
    // console.log(document.getElementById('building').style.width);
    return 0;
  }
}
