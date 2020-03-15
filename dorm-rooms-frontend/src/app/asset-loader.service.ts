import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssetLoaderService {
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  loadAsset<T>(path: string): Observable<T> {
    return this.http.get<T>('assets/' + path);
  }
}
