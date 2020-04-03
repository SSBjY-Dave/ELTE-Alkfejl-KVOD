export class User {
  id: number;
  name: string;
  neptunId: string;
  email: string;
  newbie: boolean;
  passwordSalt: string;
  passwordHash: string;
  authToken: string;
  inviteToken: string;
  layout: object;
  admin: boolean;

  static create(email: string, password: string): User {
    const createdUser = new User();
    createdUser.id = 0;
    createdUser.name = '';
    createdUser.neptunId = '';
    createdUser.email = email;
    createdUser.newbie = false;
    createdUser.passwordSalt = '';
    createdUser.passwordHash = password;
    createdUser.authToken = '';
    createdUser.inviteToken = '';
    createdUser.layout = null;
    createdUser.admin = false;
    return createdUser;
  }
}
