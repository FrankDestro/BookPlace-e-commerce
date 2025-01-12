export type RoleEnum = "ROLE_ADMIN" | "ROLE_OPERATOR";

export type CredentialsDTO = {
  username: string;
  password: string;
};

export type AccessTokenPayLoadDTO = {
  exp: number;
  username: string;
  authorities: RoleEnum[];
};
