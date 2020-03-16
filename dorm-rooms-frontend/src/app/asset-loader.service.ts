import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Building} from './model/Building';
import {Floor} from './model/Floor';
import {Room} from './model/Room';

@Injectable({
  providedIn: 'root'
})
export class AssetLoaderService {
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  async loadBuilding(path: string): Promise<Building> {
    const buildingJSON = await this.http.get<any>('assets/' + path).toPromise();
    const building = new Building();
    building.floors = new Array<Floor>();
    for (const currentRawFloor of buildingJSON) {
      const currentFloor = new Floor();
      currentFloor.level = currentRawFloor.level;
      currentFloor.rooms = new Array<Room>();
      for (const currentRawRoom of currentRawFloor.rooms) {
        const roomNum = currentRawRoom.number;
        const roomOffsetX = currentRawRoom.offset.x;
        const roomOffsetY = currentRawRoom.offset.y;
        const roomSizeW = currentRawRoom.size.width;
        const roomSizeH = currentRawRoom.size.height;

        const currentRoom = new Room(roomNum, roomOffsetX, roomOffsetY, roomSizeW, roomSizeH);
        currentFloor.rooms.push(currentRoom);
      }
      building.floors.unshift(currentFloor);
    }
    return building;
  }

  loadAsset<T>(path: string): Observable<T> {
    return this.http.get<T>('assets/' + path);
  }
}
