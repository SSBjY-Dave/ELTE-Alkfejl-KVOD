import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'dorm-rooms-frontend';
  error: ErrorType = ErrorType.None;
  ErrorType = ErrorType;

  onRouterActivate(componentReference: any) {
    componentReference.errorEvent.subscribe(errorType => this.error = errorType);
  }

  onRouterDeactivate(componentReference: any) {
    componentReference.errorEvent.unsubscribe();
  }
}
export enum ErrorType {
  None,
  BackendError
}
