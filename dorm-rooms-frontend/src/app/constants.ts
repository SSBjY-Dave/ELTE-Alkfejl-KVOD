export const BASIC_JSON_HTTP_HEADER = {'Content-Type': 'application/json'};

export const BACKEND_SERVER_URL_PREFIX = 'http://localhost:8080/';
export const BACKEND_SERVER_GET_USER_BY_EMAIL = BACKEND_SERVER_URL_PREFIX + 'getUserWithEmail';
export const BACKEND_SERVER_GET_USER_BY_AUTH_TOKEN = BACKEND_SERVER_URL_PREFIX + 'getUserByAuthToken';
export const BACKEND_SERVER_CHECK_AUTH_TOKEN = BACKEND_SERVER_URL_PREFIX + 'isAuthTokenValid';
export const BACKEND_SERVER_AUTHENTICATE_USER = BACKEND_SERVER_URL_PREFIX + 'authenticate';

export const COOKIE_PREFIX = 'DormRoomsCookie_';
export const COOKIE_AUTH_TOKEN_NAME = COOKIE_PREFIX + 'auth_token';

// Email regex according to RFC 5322 standard
// tslint:disable-next-line:max-line-length
export const REGEX_EMAIL = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/g;
