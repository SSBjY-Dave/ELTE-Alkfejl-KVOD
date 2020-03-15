interface Offset {
  x: number;
  y: number;
}
interface Size {
  width: number;
  height: number;
}
export interface Room {
  number: number;
  offset: Offset;
  size: Size;
}
