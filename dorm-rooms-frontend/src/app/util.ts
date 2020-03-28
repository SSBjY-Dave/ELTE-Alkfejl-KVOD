export class Util {
  static convertPxToRem(value: number): string {
    const htmlTag = document.getElementsByTagName('html')[0];
    const htmlFontSize = Util.removeUnit(getComputedStyle(htmlTag).fontSize);
    return value / htmlFontSize + 'rem';
  }

  static convertPxToEem(value: number): string {
    const htmlTag = document.getElementsByTagName('html')[0];
    const htmlFontSize = Util.removeUnit(getComputedStyle(htmlTag).fontSize);
    return value / htmlFontSize + 'em';
  }

  static removeUnit(value: string): number {
    const valueWithoutUnit = value.substring(0, value.length - 2);
    return parseFloat(valueWithoutUnit);
  }

  static roomNumberToFuckingHungarianRagozottForma(roomNumber) {
    let prefix = '';
    let suffix = '';
    switch (roomNumber[0]) {
      case '1': case '5':
        prefix += 'az'; break;
      default:
        prefix += 'a'; break;
    }
    switch (roomNumber.substr(1, 2)) {
      case '00':
        suffix += 'ás'; break;
      case '03': case '08':
        suffix += 'as'; break;
      case '05': case '15':
        suffix += 'ös'; break;
      default:
        suffix += 'es'; break;
    }
    return prefix + ' ' + roomNumber + '-' + suffix;
  }
}
