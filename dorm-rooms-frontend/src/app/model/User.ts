export interface User {
  id: number;
  name: string;
  neptunId: string;
  email: string;
  newbie: boolean;
  passwordSalt: string;
  passwordHash: string;
  inviteToken: string;
  layout: object;
  admin: boolean;
}
