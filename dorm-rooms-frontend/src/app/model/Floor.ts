import {Room} from './Room';

export interface Floor {
  level: number;
  rooms: Array<Room>;
}
