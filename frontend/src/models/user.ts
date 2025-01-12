import { RoleDTO } from "./role";

export type UserDTO = {
  id: number;
  fullName: string;
  cpf: string;
  phone: string;
  birthDate: string;
  email: string;
  roles: RoleDTO[];
};
