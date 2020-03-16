class Offset {
  x: number;
  y: number;

  constructor(x: number, y: number) {
    this.x = x;
    this.y = y;
  }
}
class Size {
  width: number;
  height: number;

  constructor(width: number, height: number) {
    this.width = width;
    this.height = height;
  }
}
export class Room {
  num: number;
  offset: Offset;
  size: Size;

  constructor(num: number, offsetX: number, offsetY: number, sizeW: number, sizeH: number) {
    this.num = num;
    this.offset = new Offset(offsetX, offsetY);
    this.size = new Size(sizeW, sizeH);
  }
}
