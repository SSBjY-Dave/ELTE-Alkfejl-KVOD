import {AfterViewInit, Component, EventEmitter, OnInit, Output, QueryList, ViewChildren} from '@angular/core';
import {ErrorType} from '../app.component';
import {AuthenticationService} from '../authentication.service';
import {Router} from '@angular/router';
import {User} from '../model/User';
import {Building} from '../model/Building';
import {AssetLoaderService} from '../asset-loader.service';
import {Util} from '../util';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit, AfterViewInit {
  @Output() public errorEvent: EventEmitter<ErrorType> = new EventEmitter<ErrorType>();

  private authenticationService: AuthenticationService;
  private router: Router;
  private assetLoaderService: AssetLoaderService;

  public currentUser: User;
  public building: Building = new Building();

  // animation stuff
  private floorAnimationHoverDisabled = false;
  private buildingOffsetBase = 30;
  private buildingElement: HTMLElement;
  private floorElements: HTMLCollection;
  private buildingLevelSelectorElement: HTMLElement;

  public pageOverlayElement: HTMLElement;
  public buildingOffset = this.buildingOffsetBase;
  public buildingLevelSelectorOverlayOffset = '0rem';
  public shownFloor = 0;

  @ViewChildren('floorRenderer') floors: QueryList<any>;

  constructor(authenticationService: AuthenticationService, router: Router, assetLoaderService: AssetLoaderService) {
    this.authenticationService = authenticationService;
    this.router = router;
    this.assetLoaderService = assetLoaderService;
  }

  ngOnInit(): void {
    // this.handleUserAuthenticationStatus();
    this.loadBuilding();
    this.attachScrollEventListener();
  }

  ngAfterViewInit(): void {
    this.floors.changes.subscribe(() => this.floorsRendered());
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

  checkoutFromRoom($event: MouseEvent): void {
    $event.preventDefault();
    // TODO: implement
  }

  loadBuilding(): void {
    this.assetLoaderService.loadBuilding('floor_maps/adk/building.json').then(b => {
      this.building = b;
    });
  }

  // utility stuff

  calculateRoomX(base: number): string {
    const building = document.getElementById('building');
    const buildingWidth = Util.removeUnit(getComputedStyle(building).width);

    return Util.convertPxToRem(buildingWidth * base / 880);
  }

  calculateRoomY(base: number): string {
    const building = document.getElementById('building');
    const buildingHeight = Util.removeUnit(getComputedStyle(building).height);

    return Util.convertPxToRem(buildingHeight * base / 1128);
  }

  // animation stuff

  showFloor(floorIndex: number): void {
    if (this.pageOverlayElement.classList.contains('active')) { return; }
    if (floorIndex < 0 || this.floorElements.length <= floorIndex) { return; }

    this.shownFloor = floorIndex;

    if (floorIndex !== 0) {
      this.buildingOffset = -this.buildingOffsetBase / this.floorElements.length * floorIndex;
    } else {
      this.buildingOffset = this.buildingOffsetBase;
    }

    const buildingSelectorHeight = Util.removeUnit(getComputedStyle(this.buildingLevelSelectorElement).height);
    this.buildingLevelSelectorOverlayOffset = Util.convertPxToRem(buildingSelectorHeight / this.floorElements.length * floorIndex);
  }

  showPageOverlay($event: MouseEvent): void {

  }

  applyForRoom(): void {

  }

  attachScrollEventListener(): void {
    document.addEventListener('wheel',
      (event: WheelEvent) => this.showFloor(this.shownFloor + ((event.deltaY > 0) ? 1 : -1))
    );
  }

  floorsRendered(): void {
    this.buildingElement = document.getElementById('building');
    this.floorElements = this.buildingElement.getElementsByClassName('floor');
    this.buildingLevelSelectorElement = document.getElementById('building_level_selector');
    this.pageOverlayElement = document.getElementById('page_overlay');
    this.showFloor(0);
  }

}
