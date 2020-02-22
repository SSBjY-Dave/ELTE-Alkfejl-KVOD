import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from './model/User';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private remoteServerUrl = 'http://localhost:8080';
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  getUserWithEmail(email: string): Observable<User> {
    const httpHeaders = new HttpHeaders();
    httpHeaders.set('Authorization', 'Basic');
    httpHeaders.set('Content-type', 'application/json');
    const body = { 'email': email };
    return this.http.post<User>('http://localhost:8080/getUserWithEmail', body, {headers: httpHeaders});
  }
}
