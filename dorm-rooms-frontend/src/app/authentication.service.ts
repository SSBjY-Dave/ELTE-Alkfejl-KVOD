import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from './model/User';
import {CookieService} from 'ngx-cookie-service';
import {ErrorType} from './app.component';
import {
  BACKEND_SERVER_AUTHENTICATE_USER,
  BACKEND_SERVER_CHECK_AUTH_TOKEN,
  BACKEND_SERVER_GET_USER_BY_AUTH_TOKEN,
  BACKEND_SERVER_GET_USER_BY_EMAIL,
  BASIC_JSON_HTTP_HEADER,
  BASIC_TEXT_HTTP_HEADER,
  COOKIE_AUTH_TOKEN_DOMAIN,
  COOKIE_AUTH_TOKEN_NAME,
  REGEX_EMAIL
} from './constants';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(http: HttpClient, cookieService: CookieService) {
    this.http = http;
    this.cookieService = cookieService;
  }
  private errorEvent: EventEmitter<ErrorType>;
  private http: HttpClient;
  private cookieService: CookieService;
  private currentUser: User;

  static isEmailSyntaxValue(email: string): boolean {
    const regexResult = email.match(REGEX_EMAIL);
    return regexResult !== null && regexResult.length === 1;
  }

  setErrorEvent(errorEvent: EventEmitter<ErrorType>): void {
    this.errorEvent = errorEvent;
  }

  getUserWithEmail(email: string): Observable<User> {
    return this.http.post<User>(BACKEND_SERVER_GET_USER_BY_EMAIL, email, { headers: BASIC_TEXT_HTTP_HEADER });
  }

  async isAuthTokenValid(authToken: string): Promise<boolean> {
    return this.http.post<boolean>(BACKEND_SERVER_CHECK_AUTH_TOKEN, authToken, { headers: BASIC_TEXT_HTTP_HEADER }).toPromise();
  }

  async getUserByAuthToken(authToken: string): Promise<User> {
    return this.http.post<User>(BACKEND_SERVER_GET_USER_BY_AUTH_TOKEN, authToken, { headers: BASIC_TEXT_HTTP_HEADER }).toPromise();
  }

  async isAuthTokenCookiePresentAndValid(): Promise<boolean> {
    let tokenValid = false;
    const cookiePresent = this.cookieService.check(COOKIE_AUTH_TOKEN_NAME);
    if (cookiePresent) {
      try {
        const authToken = this.cookieService.get(COOKIE_AUTH_TOKEN_NAME);
        tokenValid = await this.isAuthTokenValid(authToken);
        if (tokenValid) {
          this.currentUser = await this.getUserByAuthToken(authToken);
        }
      } catch (e) {
        this.errorEvent.emit(ErrorType.BackendError);
      }
    }
    return tokenValid;
  }

  async tryAuthenticate(email: string, password: string): Promise<boolean> {
    const tempUser = User.create(email, password);
    this.currentUser = await this.http.post<User>(BACKEND_SERVER_AUTHENTICATE_USER, tempUser,
      { headers: BASIC_JSON_HTTP_HEADER }).toPromise();
    if (this.currentUser !== null) {
      this.cookieService.set(COOKIE_AUTH_TOKEN_NAME, this.currentUser.authToken, 1, null, COOKIE_AUTH_TOKEN_DOMAIN, false, 'Strict')
    }

    return this.currentUser !== null;
  }

  getCurrentUser() {
    return this.currentUser;
  }
}
